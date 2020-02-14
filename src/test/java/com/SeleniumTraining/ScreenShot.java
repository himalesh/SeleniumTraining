package com.SeleniumTraining;

import org.testng.annotations.Test;

import com.BasePackage.BaseTest;
import com.Listeners.RetryListener;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

@Listeners(RetryListener.class)
public class ScreenShot extends BaseTest 
{
	@BeforeMethod
	public void beforeMethod() 
	{
		browserLaunch("chrome");
		navigateUrl("amazonurl");
	}

	@AfterMethod
	public void afterMethod() throws Exception 
	{
		closeBrowser();
	}
	
	@Test
	public void TakeScreenShot() 
	{
		  Assert.assertEquals(false, true);
	}
	
	@Test
	public void TakeScreenShot1() 
	{
		  Assert.assertEquals(false, true);
	}
	
	@Test
	public void TakeScreenShot2() 
	{
		  Assert.assertEquals(false, true);
	}
  
}
