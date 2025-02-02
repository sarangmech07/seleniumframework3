package com.sape.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.sape.base.BaseTest;

public class Listeners extends BaseTest implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver = null;
		String testMethodName = result.getMethod().getMethodName();
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			getScreenShotPath(testMethodName, driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub

}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub

}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub

}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub

}



}
