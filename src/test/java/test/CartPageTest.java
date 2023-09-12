package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.ProductDetailPage;
import pom.ProductPage;

public class CartPageTest extends BaseTest{
	@BeforeMethod
	public void OpernChrome() {
		driver=Browser.chrome();
	}
	@Test
	public void verifyUserIsAbleNavigateToCartPageFromProductDetailPage() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		productDetailPage.clickOnAddToCartButton();
		
		String url=driver.getCurrentUrl();
		productDetailPage.clickOnCartButton();
		String newUrl=driver.getCurrentUrl();
		Assert.assertNotEquals(newUrl, url);
		
	}
	@Test
	public void verifyUserIsAbleToClickOnContinewShopping() {
		CartPageTest cartPageTest=new CartPageTest();
		cartPageTest.verifyUserIsAbleNavigateToCartPageFromProductDetailPage();
		String url=driver.getCurrentUrl();
		
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnContinewShoppingButton();
		String url1=driver.getCurrentUrl();
		Assert.assertNotEquals(url, url1);
	}
	@Test
	public void verifyUserIsAbleToClickOnProceedToCheckout() {
		CartPageTest cartPageTest=new CartPageTest();
		cartPageTest.verifyUserIsAbleNavigateToCartPageFromProductDetailPage();
		String url=driver.getCurrentUrl();
		
		CartPage cartPage=new CartPage(driver);
		cartPage.clickOnCheckoutButton();
		String url2=driver.getCurrentUrl();
		Assert.assertNotEquals(url, url2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@Test
//	public void verifyUserIsAbleToSeeCorrectCartPriceFromProductDetailPage() {
//		CartPageTest cartPageTest=new CartPageTest();
//		cartPageTest.verifyUserIsAbleNavigateToCartPageFromProductDetailPage();
//		
//		CartPage cartPage=new CartPage(driver);
//		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
//		cartPage.getProductPriceFromCartList();
//		
//		//Assert.assertNotEquals(cartPage.getProductPriceFromCartList(0),productDetailPage.getProductPrice());
//		
//	}
	
	
	

}
