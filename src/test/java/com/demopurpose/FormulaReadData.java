package com.demopurpose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class FormulaReadData {

	public static void main(String[] args) throws IOException {

		FileInputStream fi= new FileInputStream(".//DataFile//FormulaSheet.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		for(int r=0;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++) 
			{
			XSSFCell cell=	row.getCell(c);
			switch(cell.getCellType())
			{
			case STRING:System.out.print(cell.getStringCellValue());break;
			case NUMERIC:System.out.print(cell.getNumericCellValue());break;
			case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;
			case FORMULA:System.out.print(cell.getCellFormula());break;
			}
			System.out.print(" | ");
			}
			System.out.println();
		}
	}

}
