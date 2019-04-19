import com.paazl.cases.test4.csv.DateHelper;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDateHelper {

    @Test
    public void testParseStringToDate(){
        final String stringDate = "24/07/2014";
        Date date = DateHelper.parseStringToDate(stringDate);
        Calendar cal = Calendar.getInstance();
        assertNotNull(date);
        cal.setTime(date);

        assertEquals(24, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(6, cal.get(Calendar.MONTH));
        assertEquals(2014, cal.get(Calendar.YEAR));
        assertEquals(0, cal.get(Calendar.HOUR));
        assertEquals(0, cal.get(Calendar.MINUTE));
        assertEquals(0, cal.get(Calendar.SECOND));
        assertEquals(0, cal.get(Calendar.MILLISECOND));
    }

    @Test
    public void testParseDateToString(){
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 6, 24, 0,0,0);
        Date date = cal.getTime();
        String stringDate = DateHelper.parseDateToString(date);
        String [] array = stringDate.split("/");
        assertEquals(array[0], "24");
        assertEquals(array[1], "07");
        assertEquals(array[2], "2014");
    }



    @Test
    public void testIncrementDate(){
        Calendar cal = Calendar.getInstance();
        cal.set(2014, 6, 24, 0,0,0);
        Date date = cal.getTime();
        Date newDate = DateHelper.incrementDate(date);
        cal.setTime(newDate);
        assertEquals(cal.get(Calendar.DAY_OF_MONTH), 25);

    }
}
