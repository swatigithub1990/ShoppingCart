package Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping_Cart_Demo.Shopping_Cart_Demo.AbstractComponents.AbstractComponent;

public class CataloguePage extends AbstractComponent{
	WebDriver driver;
	public CataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".inventory_item")
	List<WebElement> products;
	By addToCart=By.cssSelector(".btn_primary");
	
	
	
	//ActionMethod
	public List<WebElement> getProductList()
	{
		return products;
	}
	public WebElement getProductByName(String productName1)
	{
		WebElement prod=getProductList().stream().filter(product->product.findElement(By.cssSelector("div[class='inventory_item_name ']")).
				getText().equalsIgnoreCase(productName1)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProduct(String productName1) throws InterruptedException
	{
		WebElement prod=getProductByName(productName1);
		prod.findElement(addToCart).click();
		Thread.sleep(2000);
	}
	

}
