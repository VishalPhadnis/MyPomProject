package com.onepoint.utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.onepoint.config.TestData;
import com.onepoint.pages.homepage.Homepage;
import com.onepoint.pages.login.LoginPage;

public class InitDriver {
	protected WebDriver driver;
	/*String browserType = "firefox";
	String appURL = "https://www.flipkart.com/";*/
	static String chromeDriverPath = "C:\\Users\\22723\\workspace\\Flipkart\\jars\\";
	public WebDriver getDriver() {
		return driver;
	}

	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType
					+ " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
		//initializeTestBaseSetup(browserType, appURL);
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching Chrome browser..");
		System.setProperty("webdriver.chrome.driver", chromeDriverPath
				+ "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		/*FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
		profile.setPreference("network.proxy.http", "10.6.13.87");
		profile.setPreference("network.proxy.http_port", 8080);
		WebDriver driver = new FirefoxDriver(profile);*/
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;
	}

	
	@BeforeClass
	@Parameters({ "browserType", "appURL" })
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);
			login();
		} catch (Exception e) {
			System.out.println("Error....." + e.getMessage());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void login(){
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setUsername(TestData.USER_NAME);
		loginPage.setPassword(TestData.PASSWORD);
		loginPage.clickSignInButton();		
	}
	
	/*@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
	    if (testResult.getStatus() == ITestResult.FAILURE) {
	    	String failedTestName = testResult.getTestName();
	        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        FileUtils.copyFile(scrFile, new File(".\\screenshots\\"+failedTestName+".jpg"));
	   }        
	}*/
}
