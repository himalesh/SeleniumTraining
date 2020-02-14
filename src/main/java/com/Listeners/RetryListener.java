package com.Listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.BasePackage.BaseTest;

public class RetryListener extends BaseTest implements ITestListener 
{
	public void onTestFailure(ITestResult result)
	{
		if(!result.isSuccess())
		{
			Date dt=new Date();
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try 
			{
				FileHandler.copy(srcFile, new File(projectPath+"\\FailureScreens\\"+dt+".jpeg"));
			} 
			catch (IOException e) 
			{			
				e.printStackTrace();
			}
			Reporter.log("Test failed: "+result.getMethod().getMethodName());
		}
		
	}

}
