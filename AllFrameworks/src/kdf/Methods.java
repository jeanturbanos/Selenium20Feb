package kdf;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods 
{
	WebDriver driver;
	
	public void openBrowser()
	{
		driver = new ChromeDriver();
		
	}

	public void maximizeBrowser() 
	{

		driver.manage().window().maximize();
		
	}

	public void implicitWait() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
	}
	
	public void navigateToApplicaton(String url)
	{
		driver.get(url);
	}
	
	public void enterInTextBox(String locValue, String testData)
	{
		driver.findElement(By.id(locValue)).sendKeys(testData);
	}
	
	public void clickButton(String loc, String locValue)
	{
		if(loc.equals("id"))
		{
			driver.findElement(By.id(locValue)).click();	
		}
		else if(loc.equals("name"))
		{
			driver.findElement(By.name(locValue)).click();	
		}
		else if(loc.equals("xpath"))
		{
			driver.findElement(By.xpath(locValue)).click();	
		}
	}
	
	public String verifyMessage(String locValue)
	{
		String actualText = driver.findElement(By.cssSelector(locValue)).getText();
		return actualText;
	}
	

	public void closeApplication()
	{
		driver.quit();
		
	}
}
