package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.internal.operators.single.SingleFromUnsafeSource;

public class CartPage {
	@FindBy (xpath = "//div[@class='cart_item']") 			private List <WebElement> cartProducts;
	@FindBy (xpath = "//div[@class='cart_item']") 			private List <WebElement> removeProducts;
	@FindBy (xpath = "//div[@class='cart_item']") 			private List <WebElement> cartProductsNames;
	@FindBy (xpath = "//div[@class='cart_item']") 			private List <WebElement> cartProductsPrice;
	@FindBy (xpath = "//div[@class='cart_item']") 			private List <WebElement> cartProductsQuantity;
	@FindBy (xpath = "//button[@id='continue-shopping']") 	private WebElement continewShopingButton;
	@FindBy (xpath = "//button[@data-test='checkout']")		private WebElement checkoutButton;
	public CartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinewShoppingButton() {
		continewShopingButton.click();
	}
	
	public int getNumberOfProductsFromCartProductsList() {
		int result=cartProducts.size();
		System.out.println(result);
		return result;
	}
	
	public void removeProductFromCartList(int i) {
		removeProducts.get((i)).click();
	}
	
	public void getCartProductName(int i) {
		String s=cartProductsNames.get(i).getText().toString();
	}
	public double getProductPriceFromCartList(int i) {
		String s=cartProductsPrice.get(i).getText().toString();
		double d=Double.parseDouble(s);
		return d;
	}
	public void getCartProductQuantity(int i) {
		cartProductsNames.get(i).getText().toString();
	}
	public void clickOnCheckoutButton() {
		checkoutButton.click();
	}
	
	
	
	

}
