package com.SeleniumTraining.BasePackage;


import java.io.File;
import java.util.Date;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentRepManager extends BaseTest
{
	public static ExtentReports exrep;
	
	public static ExtentReports getInstance()
	{
		if(exrep==null)
		{
			Date dt=new Date();
			String filePath=dt.toString().replace(":", "-").replace(" ", "-")+".html";
			exrep=new ExtentReports(projectPath+"\\HTMLReports\\"+filePath);
			exrep.loadConfig(new File(projectPath+"\\resources\\extentreportconfig.xml"));
		}
		return exrep;
		
	}

}
