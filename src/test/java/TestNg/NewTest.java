package TestNg;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	
	@AfterMethod
	public void refreshPg(){
		System.out.println("To refresh the page after each validation");
	}
	
	@Test (priority=1)
	public void userReg(){
		System.out.println("Validate user Registration");
	}
	@Test (priority=2)
	public void userReg1(){
		System.out.println("Validate user Registration");
	}
	@Test (priority=3)
	public void userReg2(){
		System.out.println("Validate user Registration");
	}
	@Test (priority=4)
	public void userLogin(){
		System.out.println("Login validation");
	}
	@BeforeTest
	public void setUp(){
		System.out.println("To initialize browser and to open URL");
	}
	
	@BeforeMethod
	public void homePg(){
		System.out.println("To set Home page before each validation");
	}
	
	@AfterTest
	public void tearDown(){
		System.out.println("to close application");
	}

}
