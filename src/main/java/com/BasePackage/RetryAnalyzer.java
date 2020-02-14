package com.BasePackage;

import org.apache.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryAnalyzer implements IRetryAnalyzer
{
	public static final Logger log=Logger.getLogger(RetryAnalyzer.class.getName());
	int counter=0;
	int retryLimit=3;
	
	public boolean retry(ITestResult result) 
	{
		if(counter<retryLimit)
		{
			log("Retrying test "+result.getTestName() +" with status "+result.getStatus()+" for the "+ (counter + 1)+ " time(s).");
			counter++;
			return true;
		}
		return false;
	}

	public void log(String data) 
	{
		log.info(data);
		Reporter.log(data);		
	}


}
