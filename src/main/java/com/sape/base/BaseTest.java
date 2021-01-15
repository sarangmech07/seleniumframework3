package com.sape.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	String dataFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\data.properties";
	public FileInputStream fis;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		fis = new FileInputStream(dataFilePath);
		prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.equals("chrome")){
			//System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
		
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
	public void getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
		File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	}


}
