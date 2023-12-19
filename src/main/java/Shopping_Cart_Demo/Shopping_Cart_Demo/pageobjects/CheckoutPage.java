package Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{
	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.id("finish")).click();
	@FindBy(id="finish")
	WebElement finishbutton;
	
	@FindBy(css="div[id='checkout_complete_container'] h2")
	WebElement confirmMessage;
	
	@FindBy(id="back-to-products")
	WebElement home;
	
	public void clickOnFinish() throws InterruptedException {
		finishbutton.click();
		Thread.sleep(2000);
	}
	
	public String confirm()
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
	     js.executeScript("window.scrollBy(0,1000)");
		//String confirmMessage = driver.findElement(By.cssSelector("div[id='checkout_complete_container'] h2")).getText();
		String message=confirmMessage.getText();
		return message;
	}
	
	public void goBackToHomePage() throws InterruptedException
	{
		home.click();
		Thread.sleep(2000);
	}
	
	

	
	//ActionMethod
 	

	
	
	
	
	
	

}
