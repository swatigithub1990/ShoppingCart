package Shopping_Cart_Demo.Shopping_Cart_Demo.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Shopping_Cart_Demo.Shopping_Cart_Demo.TestComponents.BaseTest;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.LandingPage;

public class LoginFail extends BaseTest{
	@Test
	public void loginFailure() throws IOException
	{
			WebDriver driver=initializeDriver();
		
		
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo(); 
		landingpage.loginApplication("test", "test");
		System.out.println("Validated Login Failure , incorrect user name and password");
		String failureMessage=landingpage.failToLogin();
		System.out.println(failureMessage);
		Assert.assertTrue(failureMessage.equalsIgnoreCase("Epic sadface: Username and password do not match any user in this service"));
	}

}
