package DataDriven;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Login12 {

	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver","D://Chrome//chromedriver_win32");

		ChromeOptions co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSe_lFjpW51I7UerrYU25IPGpNGi4LzISc3RIErpSZC8msOgiA/viewform");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//div[@class='ry3kXd' ])[1]")).click();
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath("//span[text()='Log In']"));
		System.out.println(ele.getSize());
	//	System.out.println(ele.getText());
		Actions act= new Actions(driver);
		act.moveToElement(ele).click().perform();
	}
}