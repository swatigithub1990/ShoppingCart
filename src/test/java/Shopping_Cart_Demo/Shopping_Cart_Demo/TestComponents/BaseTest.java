package Shopping_Cart_Demo.Shopping_Cart_Demo.TestComponents;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Shopping_Cart_Demo.Shopping_Cart_Demo.pageobjects.LandingPage;

import java.io.FileInputStream;
import java.io.IOException;

public class BaseTest {
	 WebDriver driver;
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop= new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Shopping_Cart_Demo\\Shopping_Cart_Demo\\resources\\GlobalData.properties");
		prop.load(fis);
		
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
		 driver = new ChromeDriver();
		
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
		}
	/*
	public LandingPage launchApplication() throws IOException
	{
		driver=initializeDriver();
		LandingPage landingpage= new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
		
	}*/
	
	@AfterMethod(alwaysRun=true)// then it  will run always irrespective of the grouping
	public void teardown()
	{
		driver.quit();
		
		//driver.manage().deleteAllCookies();
	}
	
	
	
}
