package com.demopurpose;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

	WebDriver driver;
	
	public void launchBrowser() {

		driver= new ChromeDriver();
				
	}
	
	public void navigateURL() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
	}
	
	public void enterUsername() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	}
	
	public void enterPassword() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	}
	
	public void clickLogin() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//button[@type='submit']")).click();

}
}
