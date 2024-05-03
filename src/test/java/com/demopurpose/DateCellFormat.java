package com.demopurpose;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFCreationHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DateCellFormat {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Sheet1");
		
		XSSFCell cell=sheet.createRow(0).createCell(0);
		cell.setCellValue(new Date());
		
		XSSFCreationHelper Creationhelper=workbook.getCreationHelper();
		
		//Format1: dd-mm-yyyy
		XSSFCellStyle style=workbook.createCellStyle();
		style.setDataFormat(Creationhelper.createDataFormat().getFormat("dd-mm-yyyy"));
		
		XSSFCell cell1=sheet.createRow(1).createCell(0);
		cell1.setCellValue(new Date());
		cell1.setCellStyle(style);
		
		//Format2: dd-mm-yyyy hh:mm:ss
		XSSFCellStyle style1=workbook.createCellStyle();
		style1.setDataFormat(Creationhelper.createDataFormat().getFormat("dd-mm-yyyy hh:mm:ss"));
		
		XSSFCell cell2=sheet.createRow(2).createCell(0);
		cell2.setCellValue(new Date());
		cell2.setCellStyle(style1);
		
		//Format3: hh:mm:ss
		XSSFCellStyle style2=workbook.createCellStyle();
		style2.setDataFormat(Creationhelper.createDataFormat().getFormat("hh:mm:ss"));
		
		XSSFCell cell3=sheet.createRow(3).createCell(0);
		cell3.setCellValue(new Date());
		cell3.setCellStyle(style2);
		
		FileOutputStream fos= new FileOutputStream(".\\DataFile\\DateFormat.xlsx");
		workbook.write(fos);
		fos.close();
	}

}
