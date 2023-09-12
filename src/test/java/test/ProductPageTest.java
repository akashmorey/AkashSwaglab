package test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.ProductDetailPage;
import pom.ProductPage;

public class ProductPageTest extends BaseTest {
	@BeforeMethod
	public void openChrome() {
		driver=Browser.chrome();
	}
	@Test ()
	public void verifyUserIsAbleToSeeMultipleProductsInProductPage() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		ProductPage productPage= new ProductPage(driver);
		int result=productPage.getNumberOfProductsFromProductList();
		Assert.assertNotEquals(result,0);
		
//		boolean r=false;
//		if (result>0) {
//			r=true;
//		}
//		Assert.assertEquals(r, true);
		
	}
	@Test (priority = 1)
	public void verifyUserIsAbleToAddProductInCartFromProductPage() {
		ProductPageTest productPageTest=new ProductPageTest();
		productPageTest.verifyUserIsAbleToSeeMultipleProductsInProductPage();
		
		ProductPage productPage =new ProductPage(driver);
		productPage.ClickOnAddToCartButton(1);
		Assert.assertEquals(productPage.UserIsAbleToSeeRemoveButton(), true);
	}
	
	@Test (priority = 2)
	public void verifyUserIsAbleToRemoveProductIntoCart() throws InterruptedException {
		ProductPageTest productPageTest=new ProductPageTest();
		productPageTest.verifyUserIsAbleToAddProductInCartFromProductPage();
		Thread.sleep(1000);
		ProductPage productPage=new ProductPage(driver);
		productPage.UserIsAbleToRemoveProductToCart();
			
	}
	@Test (priority = 3)
	public void verifyUserIsAbleToAddMoltipleProductInCartFromProductPage() {
		ProductPageTest productPageTest=new ProductPageTest();
		productPageTest.verifyUserIsAbleToSeeMultipleProductsInProductPage();
		
			ProductPage productPage =new ProductPage(driver);
			
			for (int a=0;a<=3;a++) {
				productPage.ClickOnAddToCartButton(a);
			}
		}
	
	@Test (priority = 4)
	public void verifyUserIsAbleToNavigateProductDescriptionPage(){
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
	}
	
	
	@Test (priority = 5)
	public void verifyUserIsAbleToAddProductInCartFromProductDiscriptionPagePage() {
		LoginPageTest loginPageTest=new LoginPageTest();
		loginPageTest.verifyUserIsAbleToLoginWithStanderdUser();
		
		ProductPage productPage=new ProductPage(driver);
		productPage.moveToElementOnProduct(driver);
		
		ProductDetailPage productDetailPage=new ProductDetailPage(driver);
		boolean result=productDetailPage.isDisplayedAddToCartButton();
		Assert.assertEquals(result, true);
	}
}
