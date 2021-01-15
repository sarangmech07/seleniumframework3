package CreateCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sape.base.BaseTest;
import com.sape.pageObjects.HomePage;
import com.sape.pageObjects.LoginPage;

public class navigateToCase extends BaseTest{
				
	@Test
	public void loginToSalesforce() throws IOException {

		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.username().sendKeys(prop.getProperty("username"));
		loginPage.password().sendKeys("password");
		loginPage.loginBtn().isEnabled();
		loginPage.loginBtn().click();
	}
	
	/*@Test
	public void verifyHomepage() throws IOException {
		
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		HomePage homePage = new HomePage(driver);
		
		homePage.homePage().isDisplayed();
	}*/

}
