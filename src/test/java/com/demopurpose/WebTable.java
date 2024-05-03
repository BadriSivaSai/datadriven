package com.demopurpose;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws IOException {

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));

		String path=".\\DataFile\\Poplation.xlsx";
		XLUtilities xlutil=new XLUtilities(path);

		xlutil.setCellData("Sheet1", 0, 0, "Country");
		xlutil.setCellData("Sheet1", 0, 1, "population");
		xlutil.setCellData("Sheet1", 0, 2, "% of World");
		xlutil.setCellData("Sheet1", 0, 3, "Date");
		xlutil.setCellData("Sheet1", 0, 4, "Source");

		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement table=driver.findElement(By.xpath("//table[@class='wikitable sortable jquery-tablesorter']/tbody"));
		js.executeScript("arguments[0].scrollIntoView(true)",table);
		int rows=table.findElements(By.xpath("./tr")).size();
		System.out.println(rows);

		for(int r=2;r<=rows;r++)
		{
			String Country=table.findElement(By.xpath("./tr["+r+"]/td[1]")).getText();
			String population=table.findElement(By.xpath("./tr["+r+"]/td[2]")).getText();
			String World=table.findElement(By.xpath("./tr["+r+"]/td[3]")).getText();
			String Date=table.findElement(By.xpath("./tr["+r+"]/td[4]")).getText();
			String Source=table.findElement(By.xpath("./tr["+r+"]/td[5]")).getText();

			System.out.println(Country+population+World+Date+Source);

			xlutil.setCellData("Sheet1", r, 0,Country);
			xlutil.setCellData("Sheet1", r, 1,population);
			xlutil.setCellData("Sheet1", r, 2,World);
			xlutil.setCellData("Sheet1", r, 3,Date);
			xlutil.setCellData("Sheet1", r, 4,Source);
		}
		
		System.out.println("WebTable Successfull Entered......");

	}


}
