package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	
	public ExcelDataProvider() {
		
		File src = new File("./TestData/Data.xlsx");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read excel file: "+e.getMessage());
		}
		
		
	}
	
	public String getStringData(int sheetNo, int row, int column) {
		
		sheet = wb.getSheetAt(sheetNo);
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column) {
		
		sheet = wb.getSheet(sheetName);
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column) {
		
		sheet = wb.getSheet(sheetName);
		return sheet.getRow(row).getCell(column).getNumericCellValue();
	}
	
	public double getNumericData(int sheetNo, int row, int column) {
		
		sheet = wb.getSheetAt(sheetNo);
		return sheet.getRow(row).getCell(column).getNumericCellValue();
	}
}
