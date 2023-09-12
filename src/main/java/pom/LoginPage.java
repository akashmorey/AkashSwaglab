package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath = "//input[@id='user-name']") private WebElement userName;
	@FindBy (xpath = "//input[@id='password']") private WebElement password;
	@FindBy (xpath = "//input[@type='submit']") private WebElement loginButton;
	@FindBy (xpath = "//h3[@data-test='error']") private WebElement error;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserNameField(String username) {
		userName.sendKeys(username);
	}
	public void enterPasswordField(String pass) {
		password.sendKeys(pass);
	}
	public void clickOnLoginButton() {
		loginButton.click();
	}
	public boolean checkErrorMassage() {
		boolean result=error.isDisplayed();
		return result;
	}
}
