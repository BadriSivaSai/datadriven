package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest1 {
	@AfterTest
	public void tearDown() {
		System.out.println("AfterClass");
	}
	@BeforeMethod
	public void homePg(){
		System.out.println("BeforeMethod");
	}
	@AfterMethod
	public void refreshPg(){
		System.out.println("AfterMethod");
	}
	@Test (priority=1)
	public void userReg(){
		System.out.println("Test1");
	}
	@Test (priority=2)
	public void userLogin(){
		System.out.println("Test2");
	}
	@BeforeTest
	public void setUp() {
		System.out.println("BeforeClass");
	}
	
}
