package com.demopurpose;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class OHRMLoginTest {

	@Test
	public void loginTest() throws IOException {
		LoginDemo loginKeys=new LoginDemo();
		FileInputStream fi= new FileInputStream(".//DataFile//ActionsKeywords.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws= wb.getSheet("Sheet1");
		
		//to find number of rows
		int rows=ws.getLastRowNum();
		System.out.println(rows);
		for(int i=1; i<= rows; i++) {
			//to read runmode
			System.out.println(i);
			XSSFRow runMode=ws.getRow(i);
		    String cell= runMode.getCell(4).toString();
			if(cell.equals("YES") || cell.equals("NO")) {
				//to read Keyword
				String KW=ws.getRow(i).getCell(3).toString();
				
				switch (KW)
				{
				case"launchBrowser":
					loginKeys.launchBrowser();
					break;
				case"navigateURL":
					loginKeys.navigateURL();
					break;
				case"enterUsername":
					loginKeys.enterUsername();
					break;
					
				case"enterPassword":
					loginKeys.enterPassword();
					break;
				case"clickLogin":
					loginKeys.clickLogin();
					break;
				}
			}
		}
		
		
	}
}
