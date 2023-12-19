package Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//driver.findElement(By.id("user-name")).sendKeys("standard_user");
	@FindBy(id="user-name")
	WebElement userName;
	
	//driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("secret_sauce");
	
	@FindBy(css="input[placeholder='Password']")
	WebElement password;
	
	@FindBy(css="input[type='submit']")
	WebElement loginButton;
	
	@FindBy(css="div[class*='error-message-container']")
	WebElement failure;
	
	//driver.findElement(By.cssSelector("div[class*='error-message-container']")).getText();
	
	//ActionMethod
	public void loginApplication(String username,String pass)
	{
		userName.sendKeys(username);
		password.sendKeys(pass);
		loginButton.click();
	}
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/");
	}
	public String failToLogin()
	{
		return failure.getText();
	}

}
