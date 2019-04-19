package com.paazl.cases.test4;

import com.paazl.cases.test4.csv.CsvFileReader;
import com.paazl.cases.test4.csv.CsvFileWriter;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
	/*
	 * Read and parse "testdata.csv" (located in
	 * src/main/resources/com/paazl/cases/test4) into a list of POJOs. Increase
	 * each POJO's "number" field by 1, and move the "date" field one day ahead.
	 * Write the results to a file named "testdata.new.csv".
	 */
	public static void main(String[] args) throws FileNotFoundException {
		List<POJO> list = CsvFileReader.readCsvFile("src/main/resources/com/paazl/cases/test4/testdataф.csv");
		CsvFileWriter.writeCsvFile(list, "src/main/resources/com/paazl/cases/test4/testdata.new.csv");

		//Tests are located in src/test/java package
	}
}