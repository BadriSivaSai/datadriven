package TestNg;

import org.testng.annotations.Test;

public class NewTest4 {
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
}
