package com.demopurpose;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;


public class PasswordEcxel {

	public static void main(String[] args) throws IOException {

		String path=".\\DataFile\\password.xlsx";
		FileInputStream fi= new FileInputStream(path);
		String password="test123";
		//Two Ways to write the Code

		//	Workbook workbook=WorkbookFactory.create(fi,password);
		//(or)
		XSSFWorkbook workbook=(XSSFWorkbook)WorkbookFactory.create(fi,password);
		XSSFSheet sheet=workbook.getSheetAt(0);

		/*	int rows= sheet.getLastRowNum();

		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println(rows+" "+cols);

		for(int r=0;r<=rows;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<cols;c++)
			{
				XSSFCell cell=row.getCell(c);
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
		}*/

		//Using Iterator
		Iterator iterator=sheet.rowIterator();

		while(iterator.hasNext()) {
			XSSFRow row=(XSSFRow) iterator.next();

			Iterator celliterator=row.cellIterator();
			while(celliterator.hasNext())
			{
				XSSFCell cell=(XSSFCell) celliterator.next();
				switch (cell.getCellType()) {
				case STRING:System.out.print(cell.getStringCellValue());break;
				case NUMERIC:System.out.print(cell.getNumericCellValue());break;
				case BOOLEAN:System.out.print(cell.getBooleanCellValue());break;	
				}
				System.out.print(" | ");
			}
			System.out.println();
		}

	}
}
