package com.TestNGConcepts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.BasePackage.RetryAnalyzer;

public class TestRetry 
{
	  @Test
	  public void Test1() 
	  {
		  Assert.assertEquals(true, false);
	  }
	  
	  @Test
	  public void Test2() 
	  {
		  Assert.assertEquals(true, false);
	  }
}
