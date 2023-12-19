package Shopping_Cart_Demo.Shopping_Cart_Demo.test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 //This is a basic navigation test case and it does not have FRamework flow, created as the first test case
public class FlowTestCaseofCart {

	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void add() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		String productName1="Sauce Labs Backpack";
		String productName2="Sauce Labs Bike Light";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Login
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		
		//Add item to cart
		
		List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
		WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("div[class='inventory_item_name ']")).
				getText().equalsIgnoreCase(productName1)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn_primary")).click();
		
		WebElement prod2=products.stream().filter(product->product.findElement(By.cssSelector("div[class='inventory_item_name ']")).
				getText().equalsIgnoreCase(productName2)).findFirst().orElse(null);
		prod2.findElement(By.cssSelector(".btn_primary")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("div[id='shopping_cart_container'] a")).click();
		
		 //shopping cart test
		List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cart_item"));
		
		Boolean match= cartProducts.stream().anyMatch(cartproduct->cartproduct.findElement(By.cssSelector("div[class='inventory_item_name']")).
				getText().equalsIgnoreCase(productName1)); //Verify if item added is correct or not
		Boolean match1= cartProducts.stream().anyMatch(cartproduct->cartproduct.findElement(By.cssSelector("div[class='inventory_item_name']")).
				getText().equalsIgnoreCase(productName2)); //Verify if item added is correct or not
		
		
		Assert.assertTrue(match); //Verifying the item added by performing Assertion
		Assert.assertTrue(match1);//Verifying the item added by performing Assertion
		Thread.sleep(2000);
	     	
	 	driver.findElement(By.id("checkout")).click();
	 	//
	 	driver.findElement(By.id("first-name")).sendKeys("Merry");
	 	driver.findElement(By.id("last-name")).sendKeys("xmas");
	 	driver.findElement(By.id("postal-code")).sendKeys("TF3 2HU");
	 	Thread.sleep(2000);
	 	driver.findElement(By.id("continue")).click();
	 	
	 	//
	 	driver.findElement(By.id("finish")).click();
	 	String confirmMessage = driver.findElement(By.cssSelector("div[id='checkout_complete_container'] h2")).getText();
	 	Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
	 	System.out.println(confirmMessage);
	 	Thread.sleep(2000);
	 	driver.findElement(By.id("back-to-products")).click();
	 	Thread.sleep(2000);
	 	driver.close();
	 	
		
	}

}
