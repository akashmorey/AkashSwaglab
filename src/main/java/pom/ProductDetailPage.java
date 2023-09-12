package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {
	@FindBy (xpath = "//button[text()='Add to cart']") 						private WebElement addToCartButton;
	@FindBy (xpath = "//button[@name='back-to-products']") 					private WebElement backToProduct;
	@FindBy (xpath = "//div[@class='inventory_details_name large_size']") 	private WebElement ProductNameTitle;
	@FindBy (xpath = "//div[@class='inventory_details_price']") 			private WebElement productPrice;
	@FindBy (xpath = "//a[@class='shopping_cart_link']") 					private WebElement cartButton;
	@FindBy (xpath = "//button[text()='Remove']")							private WebElement removeProductButton;
	@FindBy (xpath = "/html/body/div/div/div/div[2]/div/div/div[2]/div[3]/text()[2]") private WebElement pr;
	
	public ProductDetailPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnAddToCartButton() {
		addToCartButton.click();
	}
	public void clickOnCartButton() {
		cartButton.click();
	}
	public void clickOnBackToProduct() {
		backToProduct.click();
	}
	public void getProductNameTitle() {
		String productName=ProductNameTitle.getText();
		System.out.println(productName);
	}
	public double getProductPrice() {
		String s=productPrice.getText().toString().substring(1);
		double t=Double.parseDouble(s);
		return t;
	}
	public void clickOnProductRemoveButton() {
		removeProductButton.click();
	}
	public boolean isDisplayedProductRemoveButton() {
		return removeProductButton.isDisplayed();
	}
	public boolean isDisplayedAddToCartButton() {
		return addToCartButton.isDisplayed();
	}
	
	

	

}
