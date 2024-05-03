package com.demopurpose;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class WriteFormulaExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Numbers");
		
		XSSFRow row=sheet.createRow(0);
		
		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);
		
		row.createCell(3).setCellFormula("A1*B1*C1");
		
		FileOutputStream fos= new FileOutputStream(".\\DataFile\\cls.xlsx");
		workbook.write(fos);
		fos.close();
		
		System.out.println("cls.xslx is created...........");
		
	}

}
