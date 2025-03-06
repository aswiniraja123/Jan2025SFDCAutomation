package page;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.FileUtils;

public class ForgotPassWordPage extends BasePage {
	
	public ForgotPassWordPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		String forgotPassWordPage = driver.getTitle();
		assertTrue(forgotPassWordPage.equals("Forgot Your Password | Salesforce"),"verified fotgot password page");
	}
	
	@FindBy(id="forgot_password_link")
	public WebElement forgotYourPassword;
	
	@FindBy(id="un")
	public WebElement username;
	
	@FindBy(name="Cancel")
	public WebElement cancel;
	
	@FindBy(id="continue")
	public WebElement continueButton;
	
	@FindBy(id="header")
	public WebElement title;
	
	@FindBy(xpath= "//*[@id='forgotPassForm']/div/p[1]")
	public WebElement tab;
	
	
	
	public void forgotPassWord() throws FileNotFoundException, IOException {
		this.username.sendKeys(FileUtils.readLoginPropertiesFile("valid.usename"));
		this.continueButton.click();
		String displayTab = tab.getText();
		assertTrue(displayTab.equals("We’ve sent you an email with a link to finish resetting your password."));
	}
	
	
	
	
	

}
