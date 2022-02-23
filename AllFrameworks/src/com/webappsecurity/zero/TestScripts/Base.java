package com.webappsecurity.zero.TestScripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base 
{
	WebDriver driver;
	//for multiple classes
	@BeforeClass
	
	public void openApplication() 
	{
		driver =  new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}
	
	
}
