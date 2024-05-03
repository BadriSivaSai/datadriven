package com.demopurpose;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToDataBase {

	public static void main(String[] args) throws SQLException, IOException {

	Connection con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/emp1","root","root");
	
	Statement stm=con.createStatement();
	stm.execute("Create table emp2(id int(5),name varchar(40),salary varchar(40),designation varchar(40))");
	
	//Excel
	FileInputStream fi= new FileInputStream(".\\DataFile\\DataBaseEmployee.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fi);
	XSSFSheet sheet=workbook.getSheet("Employee");
	
	int rowno=sheet.getLastRowNum();
	
	for(int r=1;r<=rowno;r++) 
	{
	XSSFRow row=sheet.getRow(r);
	int id=(int) row.getCell(0).getNumericCellValue();
	String name=row.getCell(1).getStringCellValue();
	String salary=row.getCell(2).getStringCellValue();
	String designation=row.getCell(3).getStringCellValue();
	
	stm.execute("insert into emp2 values('"+id+"','"+name+"','"+salary+"','"+designation+"')");
	stm.execute("commit");
	System.out.println("Done!...");
	}
	
	workbook.close();
	fi.close();
	con.close();
	}

}
