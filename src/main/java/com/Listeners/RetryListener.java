package com.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.BasePackage.BaseTest;

public class RetryListener extends BaseTest implements ITestListener 
{

	public void onTestStart(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test "+"'"+result.getMethod().getMethodName()+"'"+" failed...");
		testFail();
	}

	public void onTestSkipped(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
