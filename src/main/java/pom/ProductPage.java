package pom;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.functions.Action;

public class ProductPage {
	@FindBy (xpath = "//div[@class='bm-burger-button']") 			private WebElement menuButton;
	@FindBy (xpath = "//div[@id='shopping_cart_container']")		private WebElement cartButton;
	@FindBy (xpath = "//select[@class='product_sort_container']")	private WebElement ProductSortButton;
	@FindBy (xpath = "//div[@class='inventory_item']") 				private List <WebElement> products;
	@FindBy (xpath = "//button[text()='Add to cart']")				private List <WebElement> AddToCartButton;
	@FindBy (xpath = "//button[text()='Remove']")					private WebElement removeProductButton;
	@FindBy (xpath = "(//div[@class='inventory_item_name'])[2]")	private WebElement productNames;
	
	public ProductPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void clickOnMenuButton() {
		menuButton.click();
	}
	public void clickOnCartButton() {
		cartButton.click();
	}
	public void clickOnProductSortButton() {
		ProductSortButton.click();
	}
	public int getNumberOfProductsFromProductList() {
		int result=products.size();
		System.out.println(result);
		return result;
	}
	public void ClickOnAddToCartButton(int i)	{
		AddToCartButton.get((i)).click();
	}
	public boolean UserIsAbleToSeeRemoveButton() {
		return removeProductButton.isDisplayed();
	}
	public void UserIsAbleToRemoveProductToCart() {
		removeProductButton.click();
	}
	public void getSizeOfaddToCartButton() {
		AddToCartButton.size();
	}
	public void moveToElementOnProduct(WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(productNames);
		act.perform();
		act.click();
		act.perform();
	}
}
