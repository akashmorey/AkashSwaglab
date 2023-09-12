package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutOverviewPage {
	@FindBy (xpath = "//div[@class='cart_quantity']") 							private WebElement productQuantity;
	@FindBy (xpath = "//div[@class='inventory_item_name']") 					private WebElement productName;
	@FindBy (xpath = "//div[@class='summary_subtotal_label']") 					private WebElement productPrice;
	@FindBy (xpath = "//div[@class='summary_tax_label']") 						private WebElement taxCharge;
	@FindBy (xpath = "//div[@class='summary_info_label summary_total_label']") 	private WebElement subtotalPrice;
	@FindBy (xpath = "//button[@id='cancel']") 									private WebElement cancelButton;
	@FindBy (xpath = "//button[@id='finish']") 									private WebElement finishButton;
	
	public CheckOutOverviewPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public double getProductQuantity() {
		String a=productQuantity.getText().toString();
		double d=Double.parseDouble(a);
		return d;
	}
	
	public double  getProductPrice() {
		String a=productPrice.getText();
		String b=a.substring(13);
		double d=Double.parseDouble(b);
		return d;
	}
	
	public double getTaxCharge() {
	String a=taxCharge.getText();
	String b=a.substring(6);
	double d=Double.parseDouble(b);
	return d;
	}
	
	public double getSubtotalPriceOfProduct() {
		String a=subtotalPrice.getText().substring(8);
		double d=Double.parseDouble(a);
		return d;
	}
	
	public void clickOnFinishutton() {
		finishButton.click();
	}
}
