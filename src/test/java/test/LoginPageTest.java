package test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.LoginPage;
import utility.Parametrization;

public class LoginPageTest extends BaseTest {
	@BeforeMethod
	public void openChrome() {
		driver=Browser.chrome();
	}
	@Test
	public void verifyUserIsAbleToLoginWithStanderdUser() throws InterruptedException  {			
		String url1=driver.getCurrentUrl();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameField("standard_user");
		loginPage.enterPasswordField("secret_sauce");
		Thread.sleep(1000);
		loginPage.clickOnLoginButton();								//Login Success
		String url2=driver.getCurrentUrl();
		Assert.assertNotEquals(url2, url1);
	}
	@Test(priority = 1)
	public void verifyUserIsAbleToLoginWith_locked_out_user() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameField("locked_out_user");
		loginPage.enterPasswordField("secret_sauce");
		loginPage.clickOnLoginButton();								
		boolean r1=loginPage.checkErrorMassage();					//user blocked  
		Assert.assertEquals(true,r1);
	}
	@Test (priority = 2)
	public void verifyUserIsAbleToLoginWith_problem_user() {
		String url1=driver.getCurrentUrl();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameField("problem_user");
		loginPage.enterPasswordField("secret_sauce");
		loginPage.clickOnLoginButton();								//Login Success
		String url2=driver.getCurrentUrl();
		Assert.assertNotEquals(url2, url1);
	}
	@Test (priority = 3)
	public void verifyUserIsAbleToLoginWith_performance_glitch_user() {
		String url1=driver.getCurrentUrl();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.enterUserNameField("performance_glitch_user");
		loginPage.enterPasswordField("secret_sauce");
		loginPage.clickOnLoginButton();								//Login Success
		String url2=driver.getCurrentUrl();
		Assert.assertNotEquals(url2, url1);
	}
}

