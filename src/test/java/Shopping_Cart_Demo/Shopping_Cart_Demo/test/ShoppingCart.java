package Shopping_Cart_Demo.Shopping_Cart_Demo.test;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shopping_Cart_Demo.Shopping_Cart_Demo.TestComponents.BaseTest;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.CartPage;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.CataloguePage;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.CheckoutPage;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.Userdetails;
import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.LandingPage;

public class ShoppingCart extends BaseTest{

	
	@Test(dataProvider="getData")
	public void submit(String username, String password, String firstname,String lastname, String postal ) throws IOException, InterruptedException
	{
		
		String productName1="Sauce Labs Backpack";
		String productName2="Sauce Labs Bike Light";
		
		WebDriver driver =initializeDriver();
		
		
		
		LandingPage landingpage=new LandingPage(driver);
		landingpage.goTo(); 
		
		//Login
		landingpage.loginApplication(username, password);
		System.out.println("Login done");
		
		//Add item to cart, Catalog page
		
		
		CataloguePage cataloguepage=new CataloguePage(driver);
		List<WebElement> products= cataloguepage.getProductList();
		cataloguepage.addProduct(productName1); //added First product to cart
		cataloguepage.addProduct(productName2); // added second product to cart
	
		cataloguepage.goToCart();
		System.out.println("Navigated to Cart Page now");
		
		 //shopping cart test, cart page
		CartPage cartpage=new CartPage(driver);
		Boolean match1=cartpage.verifyproduct(productName1); //Verify if product 1 is correctly added
		Boolean match2=cartpage.verifyproduct(productName2);//Verify if product 2 is correctly added
	
		
		
		Assert.assertTrue(match1); //Verifying the item added by performing Assertion
		Assert.assertTrue(match2);//Verifying the item added by performing Assertion
		cartpage.checkoutpage();
		
	     System.out.println("Verified items in the Cart");
	 	
	     
	     //User details page, user details page
	     Userdetails userdetails=new Userdetails(driver);
	     //Thread.sleep(1000);
	    // userdetails.addUserDetails("Merry", "xmas", "TF3 2HU");
	     userdetails.addUserDetails(firstname, lastname, postal);
	     userdetails.clickcontinue();
	     System.out.println("User details added");
	 	
	     
	 	//Checkout page
	     
	     CheckoutPage checkout=new CheckoutPage(driver);
	     checkout.clickOnFinish();
	     String message=checkout.confirm();
	 	Assert.assertTrue(message.equalsIgnoreCase("Thank you for your order!"));
	 	checkout.goBackToHomePage(); 		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		return new Object[][] {{"standard_user","secret_sauce","Merry","joe","TF32HU"}};

	}
	

}
