package com.webappsecurity.zero.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation 
{
	@FindBy(css="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement confMsgBox;
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement usrname;
	
	@FindBy(linkText="Logout")
	private WebElement lgout;
	
	@FindBy(id="signin_button")
	private WebElement signin;
	
	
	
	public TransferFundsConfirmation(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getConfMsg()
	{
		String actualText = confMsgBox.getText();		
		return actualText;
	}


	public void logoutFromApplicaton() 
	{
		usrname.click();
		lgout.click();
		signin.click();
		
	}
	
	
}
