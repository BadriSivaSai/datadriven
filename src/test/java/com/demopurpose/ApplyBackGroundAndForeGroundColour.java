package com.demopurpose;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class ApplyBackGroundAndForeGroundColour {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet();
		
		XSSFRow row=sheet.createRow(1);
		
		//Setting BackGround Color
		XSSFCellStyle style=workbook.createCellStyle();
		style.setFillBackgroundColor(IndexedColors.BLUE_GREY.getIndex());
		style.setFillPattern(FillPatternType.DIAMONDS);
		
		XSSFCell cell=row.createCell(1);
		cell.setCellValue("Welcome");
		cell.setCellStyle(style);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
		style.setFillPattern(FillPatternType.DIAMONDS);
		
		cell=row.createCell(2);
		cell.setCellValue("Automation");
		cell.setCellStyle(style);
		
		FileOutputStream fos= new FileOutputStream(".\\DataFile\\color.xlsx");
		workbook.write(fos);
		workbook.close();
		fos.close();
		
		System.out.println("Done!...");
		
	}

}
