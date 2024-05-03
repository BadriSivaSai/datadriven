package com.demopurpose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHashMap {

	public static void main(String[] args) throws IOException {

		FileInputStream fi= new FileInputStream(".\\DataFile\\Student.xlsx");
		XSSFWorkbook workbook= new XSSFWorkbook(fi);
		XSSFSheet sheet= workbook.getSheet("Student Info");
		
		int row=sheet.getLastRowNum();
		
		HashMap<String,String> data= new HashMap<String, String>();
		
		for(int r=0;r<=row;r++) {
		String key=	sheet.getRow(r).getCell(0).getStringCellValue();
		String value=sheet.getRow(r).getCell(1).getStringCellValue();
		data.put(key, value);
		}
		
		for(Map.Entry entry:data.entrySet())
		{
			System.out.println(entry.getKey()+"   "+entry.getValue());
		}
		
	}

}
