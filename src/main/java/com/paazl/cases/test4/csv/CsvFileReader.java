package com.paazl.cases.test4.csv;

import com.paazl.cases.test4.POJO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class CsvFileReader {

    public static List<POJO> readCsvFile(String fileName) throws FileNotFoundException{
        final String SEMICOLON_DELIMITER = ";";
        BufferedReader fileReader = null;
        try {
            fileReader = new BufferedReader(new FileReader(fileName));
            fileReader.readLine();
            return fileReader.lines()
                    .filter(s -> s.length() > 0)
                    .map(s -> {
                        String[] array = s.split(SEMICOLON_DELIMITER);
                        return new POJO(array[0], array[1], array[2], incrementInteger(Integer.valueOf(array[3])), DateHelper.incrementDate(DateHelper.parseStringToDate(array[4])));
                    })
                    .collect(Collectors.toList());
        }catch (IOException e) {
            System.err.println("Error in CsvFileReader !!!");
        } finally {
            try {
            if(fileReader!=null)
                fileReader.close();
            } catch (IOException e) {
                System.err.println("Error while closing fileReader !!!");
            }
        }
        return null;
    }

    private static int incrementInteger(int integer) {
        return integer + 1;
    }

}
