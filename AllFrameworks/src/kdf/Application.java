package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.GenericMethods;

public class Application 
{
	@Test
	public void verifyInvalidLogin() throws IOException 
	{
		Methods mtd = new Methods();
		String [][] data = GenericMethods.getData("D:\\\\QATesting\\\\TestData.xlsx", "Sheet2");
		
		for(int i=1; i<data.length;i++)
		{
			switch(data[i][3])
			{
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowser();
				break;
			case "impWait":
				mtd.implicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplicaton(data[i][6]);
				break;
			case "enterTextBox":
				mtd.enterInTextBox(data[i][5], data[i][6]);
				break;

			case "clickButton":
				mtd.clickButton(data[i][4],data[i][5]);
				break;
			case "verifyMessage":
				String actualMessage = mtd.verifyMessage(data[i][5]);
				Assert.assertEquals(actualMessage, data[i][6]);
				break;
			case "closeApp":
				mtd.closeApplication();
				break;
				
			}
		}
	}
}
