package test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CheckoutInformationPage;

public class CheckoutInformationPageTest extends BaseTest {
	@BeforeMethod
	public void openChrome() {
		driver=Browser.chrome();
	}
	@Test 
	public void enterCheckOutInformation() {
		CartPageTest cartPageTest=new CartPageTest();
		cartPageTest.verifyUserIsAbleToClickOnProceedToCheckout();
		Actions act=new Actions(driver);
		CheckoutInformationPage checkoutInformationPage=new CheckoutInformationPage(driver);
		checkoutInformationPage.enterFirstNameField("Akash");
		act.sendKeys(Keys.TAB);
		act.perform();
		act.sendKeys("Morey").perform();
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("443302").perform();
	}
	@Test (priority = 1)
	public void VerifyUserIsAbleToProceedToCheckout() {
		CheckoutInformationPageTest checkoutInformationPageTest=new CheckoutInformationPageTest();
		checkoutInformationPageTest.enterCheckOutInformation();
		CheckoutInformationPage checkoutInformationPage =new CheckoutInformationPage(driver);
		checkoutInformationPage.clickOnContinewButton();
		
	}
	@Test (priority = 2)
	public void VerifyUserIsAbleToCancelProceedToCheckout() {
		CheckoutInformationPageTest checkoutInformationPageTest=new CheckoutInformationPageTest();
		checkoutInformationPageTest.enterCheckOutInformation();
		CheckoutInformationPage checkoutInformationPage =new CheckoutInformationPage(driver);
		checkoutInformationPage.clickOnCancelButton();
	}
	
}
