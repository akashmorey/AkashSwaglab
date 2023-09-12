package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutInformationPage {
	@FindBy (xpath = "//input[@id='first-name']")	private WebElement firstNameField;
	@FindBy (xpath = "//input[@id='last-name']")	private WebElement lastNameField ;
	@FindBy (xpath = "//input[@id='postal-code']")	private WebElement postalCodeField;
	@FindBy (xpath = "//button[@id='cancel']")		private WebElement cancelButton;
	@FindBy (xpath = "//input[@id='continue']")		private WebElement continewButton;
	
	public CheckoutInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void enterFirstNameField(String name) {
		firstNameField.sendKeys(name);
	}
	
	public void clickOnCancelButton() {
		cancelButton.click();
	}
	public void clickOnContinewButton() {
		continewButton.click();
	}

}
