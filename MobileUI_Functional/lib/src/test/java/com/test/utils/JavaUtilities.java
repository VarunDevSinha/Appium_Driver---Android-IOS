package com.test.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class JavaUtilities {

	public static void readExcelData(File readFile, Object[][] readData) throws IOException, InvalidFormatException {

		FileInputStream readFileIS = new FileInputStream(readFile);

		XSSFWorkbook workbook = new XSSFWorkbook(readFileIS);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (int r = 0; r <= sheet.getLastRowNum(); r++) {
			XSSFRow row = sheet.getRow(r);
			for (int c = 0; c < row.getLastCellNum(); c++) {
				XSSFCell cell = row.getCell(c);
				String cellVal = cell.toString();
				readData[r][c] = cellVal;
			}
		}

		workbook.close();
		System.out.println("Successfully created \"readData\" Java object, from \"readFile.xlsx\" file.\n");

		for (int i = 0; i < readData.length; i++) {
			for (int j = 0; j < readData[i].length; j++) {
				System.out.print(readData[i][j] + " | ");
			}
			System.out.print("\n");
		}
	}

	public static void adbCommand(String batFilePath) throws IOException, InterruptedException {

		// Create process builder to configure the batch file.
		ProcessBuilder batProcessBuild = new ProcessBuilder(batFilePath);

		// Create and start process using the ProcessBuilder object.
		Process batProcess = batProcessBuild.start();

		// To read the console output of the batch command.
		BufferedReader reader = new BufferedReader(new InputStreamReader(batProcess.getInputStream()));

		// Reading and Storing the console output to perform relative actions and end
		// the process.
		StringBuilder output = new StringBuilder();

		// Store line as String.
		String outputLine;
		while ((outputLine = reader.readLine()) != null) {
			output.append(outputLine + "\n");
		}
		
		int exitVal = batProcess.waitFor();
		if (exitVal == 0) {
            System.out.println(output);
            System.exit(0);
        } else {
            
        	System.out.println("Abnormal behaviour of cmd");
        }

	}
}