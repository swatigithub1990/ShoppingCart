package Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents.AbstractComponent;

public class Userdetails extends AbstractComponent{
	WebDriver driver;
	public Userdetails(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//List<WebElement> cartProducts= driver.findElements(By.cssSelector(".cart_item"));
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement cont;
	

	
	//ActionMethod
 	public void addUserDetails(String firstname, String lastname, String postcode) throws InterruptedException
 	{
 		firstName.sendKeys(firstname);
 		lastName.sendKeys(lastname);
 		postalcode.sendKeys(postcode);
 		Thread.sleep(2000);
 		
 	}
 	public void clickcontinue() throws InterruptedException
 	{
 		cont.click();
 		Thread.sleep(2000);
 	}


	
	
	
	
	
	

}
