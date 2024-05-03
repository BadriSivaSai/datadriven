package com.demopurpose;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingData {

	public static void main(String[] args) throws IOException {

		XSSFWorkbook workbook= new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Emp Info");
		
		ArrayList<Object[]> empdata=new ArrayList<Object[]>();
		empdata.add(new Object[] {"EmpId","Name","Job"});
		empdata.add(new Object[] {101,"siva","Tester"});
		empdata.add(new Object[] {102,"Sai","software"});
		empdata.add(new Object[] {103,"Mohan","analytic"});
		
	/*	Object empdata[][]= {
				{"EmpId","Name","Job"},
				{101,"siva","Tester"},
				{102,"Sai","software"},
				{103,"Mohan","analytic"}
		};		
		
		
		int rows=empdata.length;
		int cols=empdata[0].length;
		
		System.out.println(rows+"   "+cols);*/
		
		//Using For loop
	
	/*	for(int r=0;r<rows;r++) {
			XSSFRow row=sheet.createRow(r);
			for(int c=0;c<cols;c++) {
				XSSFCell cell=row.createCell(c);
				
				Object value=empdata[r][c];
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				
			}
		}*/
		
		// Using For..each Loop
		
		int rowCount=0;
		
		for(Object emp[]:empdata) {
			XSSFRow row=sheet.createRow(rowCount++);
		int cellcount=0;
			for(Object value:emp) {
				XSSFCell cell=row.createCell(cellcount++);
				
				if(value instanceof String)
					cell.setCellValue((String)value);
				if(value instanceof Integer)
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				
			}
		}
		
		String path=".//DataFile//EmployeeInfo.xlsx";
		FileOutputStream fos= new FileOutputStream(path);	
		workbook.write(fos);
		workbook.close();
	}

}
