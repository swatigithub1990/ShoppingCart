package Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cart_item"));
	@FindBy(css=".cart_item")
	List<WebElement> cartProducts;
	
	//driver.findElement(By.id("checkout")).click();
	@FindBy(id="checkout")
	WebElement checkout;
	
	By itmelist=By.cssSelector("div[class='inventory_item_name']");
	
	//ActionMethod
	public Boolean verifyproduct(String productName) {
		Boolean match= cartProducts.stream().anyMatch(cartproduct->cartproduct.findElement(itmelist).
				getText().equalsIgnoreCase(productName));
		return match;
		
	}
	public void checkoutpage() throws InterruptedException
	{
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(0,500)");
		checkout.click();
	}
	
	
	
	
	
	

}
