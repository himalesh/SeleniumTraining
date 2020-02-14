package com.SeleniumTraining;

import com.BasePackage.BaseTest;
import com.relevantcodes.extentreports.LogStatus;

public class BrowserLaunch extends BaseTest 
{

	public static void main(String[] args) throws Exception
	{
		extest=report.startTest("BrowserLaunch");
		initialize();
		extest.log(LogStatus.INFO, "Initiliaze properties file...");
		
		browserLaunch("chrome");
		extest.log(LogStatus.INFO, "Launching browser...");
		
		navigateUrl("amazonurl");
		extest.log(LogStatus.INFO, "Opening url");
		
		closeBrowser();
		extest.log(LogStatus.INFO, "Closing browser...");
		
		report.endTest(extest);
		report.flush();
	}

}
