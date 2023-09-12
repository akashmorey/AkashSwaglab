package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ProductDetailPage;
import pom.ProductPage;

public class ProductDetailPageTest extends BaseTest{
	@BeforeMethod
	public void openChrome() {
		driver=Browser.chrome();
	}
	
	@Test
	public void verifyUserIsAbleAddProductInCartFromProductDetailPage() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		productDetailPage.clickOnAddToCartButton();
	
		Assert.assertEquals(productDetailPage.isDisplayedProductRemoveButton(),true);
	}
	@Test (priority = 1)
	public void getProductPrice() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		productDetailPage.getProductPrice();
	}
	@Test (priority = 2)
	public void getProductNameTitle() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		productDetailPage.getProductNameTitle();
	}
	@Test (priority = 3)
	public void verifyUserIsAbleToNavigateBackToProductPageFromProductDetailPage() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		productDetailPage.getProductNameTitle();
		
	}
}
