package com.sape.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	By appLauncher = By.xpath("//div[@class='slds-icon-waffle']");
	
	public WebElement homePage() {
		
		return driver.findElement(appLauncher);
	}

}
