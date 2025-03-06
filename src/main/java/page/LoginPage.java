package page;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import utils.FileUtils;

public class LoginPage extends BasePage {
	WebDriver driver;
	ExtentTest test;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id = "username")
	public WebElement username;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(id = "Login")
	public WebElement loginButton;
	
	@FindBy(id = "hint_back_chooser")
	public WebElement savedUsername ;
	
	@FindBy(id = "error")
	public WebElement errorMsg;
	
	@FindBy(name = "rememberUn")
	public WebElement remberMe;
	
	@FindBy(linkText = "Forgot Your Password?")
	public WebElement forgotYourPassword;
	
	@FindBy(id = "signup_link")
	public WebElement tryForFree;
	
	public void enterUsername(String username) {
		this.username.clear();
		this.username.sendKeys(username);
	}
	public void enterPassword(String pass) {
		this.password.clear();
		this.password.sendKeys(pass);
	}
	public void clickLogin() {
		this.loginButton.click();
	}
	
	public void forgotYourPassword() {
		this.forgotYourPassword.click();
	}
	public void selectRememberMeCheckbox() {
		if(this.remberMe.isSelected()) {
			System.out.println("checkbox is already selected");
		} else {
			this.remberMe.click();
		}
	}
	public HomePage loginToApp(String username, String pass) {
		this.enterUsername(username);
		this.enterPassword(pass);
		this.clickLogin();
		return new HomePage(driver) ;
	}
	
	public HomePage loginToAppRemember(String username, String pass) {
		this.enterUsername(username);
		this.enterPassword(pass);
		selectRememberMeCheckbox();
		this.clickLogin();
		return new HomePage(driver) ;
	}
	
	
	
	public LoginPage loginWithInvalidUser(String username, String pass) {
		this.enterUsername(username);
		this.enterPassword(pass);
		this.clickLogin();
		return new LoginPage(driver) ;
	}
	
	public boolean validateUsername() throws FileNotFoundException, IOException {
		String username = driver.findElement(By.id("idcard-identity")).getText();
		return username.equals(FileUtils.readLoginPropertiesFile("valid.usename"));
	}
	
	public boolean validateErrorMessage(String expectedErrorMsg )  {
		String actualErrorMsg = errorMsg.getText();
		return actualErrorMsg.equals(expectedErrorMsg);
	}
	
	
	

}
