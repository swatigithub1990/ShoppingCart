package Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this); // Initialize PageFactory
	}
	
	
	@FindBy(css="div[id='shopping_cart_container'] a")
	WebElement cart;
	
	//Action Method
	public void goToCart()
	{
		cart.click();
		
	}

}
