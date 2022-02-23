package com.webappsecurity.zero.TestScripts;

import utils.GenericMethods;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.Pages.AccountSummary;
import com.webappsecurity.zero.Pages.Login;
import com.webappsecurity.zero.Pages.TransferFunds;
import com.webappsecurity.zero.Pages.TransferFundsConfirmation;
import com.webappsecurity.zero.Pages.TransferFundsVerify;


public class VerifyFundTransferTest extends Base 
{
	@Test
	public void verifyFundTransfer() throws IOException 
	{
		Login ln = new Login(driver);
		AccountSummary acc = new AccountSummary(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		
		String[][] info = GenericMethods.getData("D:\\QATesting\\TestData.xlsx","Sheet1");
		
		for(int i=1;i<info.length;i++)
		{
			ln.applicationLogIn(info[i][0],info[i][1]);
			driver.navigate().back();
			driver.navigate().to(info[i][2]);
			acc.clickTransferFunds();
			tf.doFundTransfer(info[i][3],info[i][4]);
			tfv.clickSubmit();
			String actualMessage = tfc.getConfMsg();
			String expectedMessage = info[i][5];
			
			Assert.assertEquals(actualMessage, expectedMessage);
			tfc.logoutFromApplicaton();
		}
	}

}
