package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CheckOutOverviewPage;

public class CheckOutOverviewPageTest extends BaseTest {
	@BeforeMethod
	public void openChrome() {
		driver=Browser.chrome();
	}
	@Test
	public void verifyProductPriceFromCheckOutOverViewPage() {
		CheckoutInformationPageTest checkoutInformationPageTest =new CheckoutInformationPageTest();
		checkoutInformationPageTest.VerifyUserIsAbleToProceedToCheckout();
		
		CheckOutOverviewPage checkOutOverviewPage=new CheckOutOverviewPage(driver);
		
		checkOutOverviewPage.getSubtotalPriceOfProduct();
		
		double calculation=checkOutOverviewPage.getProductQuantity()*checkOutOverviewPage.getProductPrice()+checkOutOverviewPage.getTaxCharge();
		String s=Double.toString(calculation);
		String t=s.substring(0, 5);

		double d=Double.parseDouble(t);
		Assert.assertEquals(checkOutOverviewPage.getSubtotalPriceOfProduct(),d);
	}
	
	@Test
	public void verifyUserIsAbleTofinishOrder() {
		CheckOutOverviewPageTest checkOutOverviewPageTest=new CheckOutOverviewPageTest();
		checkOutOverviewPageTest.verifyProductPriceFromCheckOutOverViewPage();
		
		CheckOutOverviewPage checkOutOverviewPage=new CheckOutOverviewPage(driver);
		String url=driver.getCurrentUrl();
		
		checkOutOverviewPage.clickOnFinishutton();
		String url2=driver.getCurrentUrl();
		Assert.assertNotEquals(url2, url);
	}

}
