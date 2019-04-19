package com.paazl.cases.test4.csv;

import com.paazl.cases.test4.POJO;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter {

    public static void writeCsvFile(List<POJO> list, String fileName) {
        final String SEMICOLON_DELIMITER = ";";
        final String NEW_LINE_SEPARATOR = "\n";
        final String FILE_HEADER = "name;city;country;number;date";

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (POJO s : list) {
                fileWriter.append(s.getName())
                        .append(SEMICOLON_DELIMITER)
                        .append(s.getCity())
                        .append(SEMICOLON_DELIMITER)
                        .append(s.getCountry())
                        .append(SEMICOLON_DELIMITER)
                        .append(String.valueOf(s.getNumber()))
                        .append(SEMICOLON_DELIMITER)
                        .append(String.valueOf(DateHelper.parseDateToString(s.getDate())))
                        .append(NEW_LINE_SEPARATOR);
            }

        } catch (Exception e) {
            System.err.println("Error in CsvFileWriter !!!");
        } finally {
            try {
                if(fileWriter!=null){
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                System.err.println("Error while flushing/closing fileWriter !!!");
            }

        }
    }
}