package com.demopurpose;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class DataBaseToExcel {

	/**
	 * @param args
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String[] args) throws SQLException, IOException {

	Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/emp1","root","root");
	
	Statement stmt=con.createStatement();
	
	ResultSet rs=stmt.executeQuery("select * from emp");
	
	//Excel
	XSSFWorkbook workbook= new XSSFWorkbook();
	XSSFSheet sheet= workbook.createSheet("Employee");
	
	XSSFRow row=sheet.createRow(0);
	row.createCell(0).setCellValue("id");
	row.createCell(1).setCellValue("name");
	row.createCell(2).setCellValue("salary");
	row.createCell(3).setCellValue("designation");
	
	int r=1;
	while(rs.next())
	{	
		int id=rs.getInt("id");
		String name=rs.getString("name");
		String salary=rs.getString("salary");
		String designation=rs.getString("designation");
		
		row=sheet.createRow(r++);
		row.createCell(0).setCellValue(id);
		row.createCell(1).setCellValue(name);
		row.createCell(2).setCellValue(salary);
		row.createCell(3).setCellValue(designation);
	}
	
	FileOutputStream fos= new FileOutputStream(".\\DataFile\\DataBaseEmployee.xlsx");
	workbook.write(fos);
	fos.close();
	System.out.println("Done!...");
	
	}
	
}
