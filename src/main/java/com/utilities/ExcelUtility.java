package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	File path;
	FileInputStream read;
	XSSFWorkbook wBook;
	FileOutputStream write;

	public String excelReadData(String sheet, int rowNumber, int cellNumber) throws IOException {
		path = new File("src/test/resources/TestData/FlipkartTestData.xlsx");
		read = new FileInputStream(path);
		wBook = new XSSFWorkbook(read);

		XSSFSheet sh = wBook.getSheet(sheet);
		XSSFRow row = sh.getRow(rowNumber);
		XSSFCell cell = row.getCell(cellNumber);
		return cell.getStringCellValue();
	}

	public void excelWrite(String sheet, int rowNumber, int cellNumber, String text) throws IOException {
		path = new File("src/test/resources/TestData/FlipkartTestData.xlsx");
		read = new FileInputStream(path);
		wBook = new XSSFWorkbook(read);

		XSSFSheet sheet2 = wBook.getSheet(sheet);
		XSSFRow row = sheet2.getRow(rowNumber);
		XSSFCell cell = row.createCell(cellNumber);
		cell.setCellValue(text);

		write = new FileOutputStream(path);
		wBook.write(write);
	}
}
