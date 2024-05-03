package com.demopurpose;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;

public class TotalSumFormulawrite {

	public static void main(String[] args) throws IOException{

		String path=".\\DataFile\\TotalSum.xlsx";
		FileInputStream fi= new FileInputStream(path);
		XSSFWorkbook workbook=new XSSFWorkbook(fi);
		
		XSSFSheet sheet=workbook.getSheetAt(0);
		sheet.getRow(7).getCell(2).setCellFormula("SUM(C2:C6)");
		fi.close();
		
		FileOutputStream fos= new FileOutputStream(path);
		workbook.write(fos);
		workbook.close();
		fos.close();
		System.out.println("Done.......");
	}

}
