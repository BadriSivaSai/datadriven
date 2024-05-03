package com.demopurpose;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class HashMapToExcel {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Student Info");
		
		Map<String,String> data= new HashedMap<String, String>();
		data.put("101", "Kim");
		data.put("102", "Siva");
		data.put("103", "Anil");
		data.put("104", "Naveen");
		data.put("105", "Mohan");
		
		int rowno=0;
		for(Map.Entry entry:data.entrySet())
		{
			XSSFRow row= sheet.createRow(rowno++);
			
			row.createCell(0).setCellValue((String)entry.getKey());
			row.createCell(1).setCellValue((String)entry.getValue());
		}
		
		FileOutputStream fos= new FileOutputStream(".\\DataFile\\Student.xlsx");
		workbook.write(fos);
		fos.close();
		System.out.println("Data successfull Entry......");
		
	}

}
