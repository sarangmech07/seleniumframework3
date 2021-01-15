package com.sape.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By username = By.xpath("//input[@id='username']");
	By password = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='Login']");
	
	public WebElement username() {
		
		return driver.findElement(username);
	}
	
	public WebElement password() {
		
		return driver.findElement(password);
	}
	
	public WebElement loginBtn() {
		
		return driver.findElement(loginBtn);
	}

	
}
