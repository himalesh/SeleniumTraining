package com.BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


public class BaseTest 
{
	public static String projectPath=System.getProperty("user.dir");
	public static Properties p;
	public static Properties envProp;
	public static WebDriver driver;
	
	public static ExtentReports report=ExtentRepManager.getInstance();
	public static ExtentTest extest;
	
	public static void initialize() throws Exception
	{
		FileInputStream fisd=new FileInputStream(projectPath+"\\resources\\data.properties");
		p=new Properties();
		p.load(fisd);
	}
	
	public static void browserLaunch(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", projectPath+"\\drivers\\chromedriver.exe");
			
			ChromeOptions op=new ChromeOptions();
			op.addArguments("user-data-dir=C:\\Users\\himalesh\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 2");
			op.addArguments("--disable--notifications");
			op.addArguments("--disable-infobars");
			
			driver=new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		}
		else if(p.getProperty(browser).equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", projectPath+"\\drivers\\geckodriver.exe");
			
			FirefoxOptions fop=new FirefoxOptions();
			
			ProfilesIni p=new ProfilesIni();
			FirefoxProfile profile=p.getProfile("default");
			
			profile.setPreference("dom.webnotifications.enabled", false);
			fop.setProfile(profile);
						
			driver=new FirefoxDriver(fop);
			
		}
						
	}
	
	public static void navigateUrl(String url)
	{
		if(url.equalsIgnoreCase("amazonurl"))
		{
			driver.navigate().to("https://www.amazon.in");
		}else if(url.equalsIgnoreCase("googleurl"))
		{
			driver.navigate().to("https://www.google.in");
		}
		else
		{
			System.out.println("URL not found in list...");
		}
		
		
	}
	
	public static void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	
	public static void testFail()
	{
		Date dt=new Date();
		SimpleDateFormat dtFormat=new SimpleDateFormat("dd-mm-yy hh-mm-ss");
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String fileName = dt.toString().replace(":", "_").replace(" ", "_")+".jpeg";
		try 
		{
			FileUtils.copyFile(srcFile, new File(projectPath+"/FailureScreens/"+fileName));
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	
}
