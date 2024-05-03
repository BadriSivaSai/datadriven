package com.demopurpose;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenExcel {

	WebDriver driver;

		@BeforeMethod
		public void setUp()
		{
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		}
		
		@Test(dataProvider = "DataInfo")
		public void Login(String Username,String pwd,String valid)
		{
			driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
			WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
			email.clear();
			email.sendKeys(Username);
			
			WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
			password.clear();
			password.sendKeys(pwd);
			
			driver.findElement(By.xpath("//button[.='Log in']")).click();
			
			
			String exp_title="Dashboard / nopCommerce administration";
			String acutalTitle=driver.getTitle();
			
			if(valid.equals("Valid"))
			{
				if(exp_title.equals(acutalTitle))
				{
					driver.findElement(By.xpath("//a[.='Logout']")).click();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			else if(valid.equals("InValid"))
			{
				if(exp_title.equals(acutalTitle))
				{
					driver.findElement(By.xpath("//a[.='Logout']")).click();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		}
		
		@DataProvider(name="DataInfo")
		public String[][] getData() throws IOException
		{
		/*	String loginData[][]= {
					{"admin@yourstore.com","admin","Valid"},
					{"admin@yourstore.com","admi","InValid"},
					{"admin@yourstore.com","adin","InValid"},
					{"admin@yourstore.com","adnim","InValid"}
			};
			return loginData; */
			
			String path=".\\DataFile\\ApplicationLoginData.xlsx";
			XLUtilities xlutil= new XLUtilities(path);
			int rowNum=xlutil.getRow("Sheet1");
			int colNum=xlutil.getCellCount("Sheet1", rowNum);
			
			String loginData[][]=new String[rowNum][colNum];
			for(int r=1;r<=rowNum;r++)
			{
				
				for(int c=0;c<colNum;c++)
				{
					loginData[r-1][c]=	xlutil.getCellData("Sheet1", r, c);
				}
			}
			return loginData;
		}
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
	

}
