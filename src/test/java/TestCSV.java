import com.paazl.cases.test4.POJO;
import com.paazl.cases.test4.csv.CsvFileReader;
import com.paazl.cases.test4.csv.CsvFileWriter;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class TestCSV {

    @Test
    public void testReadAndWrite(){
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 6, 24, 0,0,0);
        Date date = cal.getTime();
        List<POJO> list = new ArrayList<>();
        list.add(new POJO("Piet1", "Amsterdam1", "NL1", 0, date));
        list.add(new POJO("Piet2", "Amsterdam2", "NL2", 1, date));
        list.add(new POJO("Piet3", "Amsterdam3", "NL3", 2, date));
        list.add(new POJO("Piet4", "Amsterdam4", "NL4", 3, date));
        list.add(new POJO("Piet5", "Amsterdam5", "NL5", 4, date));

        final String fileName = "src/main/resources/com/paazl/cases/test4/testdata.test.new.csv";
        List<POJO> newList = null;
        try{
            newList = CsvFileReader.readCsvFile(fileName);
        }catch (FileNotFoundException e){
            assertNotNull(e);
        }

        CsvFileWriter.writeCsvFile(list, fileName);

        try{
            newList = CsvFileReader.readCsvFile(fileName);
        }catch (FileNotFoundException ignored){
        }

        assertNotNull(newList);
        assertEquals(5, newList.size());
        for(int i=0; i<5; i++){
            assertEquals(newList.get(i).getNumber(), list.get(i).getNumber()+1);
            Calendar localCal = Calendar.getInstance();
            localCal.setTime(newList.get(i).getDate());

            Assert.assertEquals(localCal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.DAY_OF_MONTH) + 1);
            Assert.assertEquals(cal.get(Calendar.MONTH), cal.get(Calendar.MONTH));
            Assert.assertEquals(cal.get(Calendar.YEAR), cal.get(Calendar.YEAR));
            Assert.assertEquals(cal.get(Calendar.HOUR), cal.get(Calendar.HOUR));
            Assert.assertEquals(cal.get(Calendar.MINUTE), cal.get(Calendar.MINUTE));
            Assert.assertEquals(cal.get(Calendar.SECOND), cal.get(Calendar.SECOND));
            Assert.assertEquals(cal.get(Calendar.MILLISECOND), cal.get(Calendar.MILLISECOND));
        }

        File file = new File(fileName);
        file.delete();
    }
}
