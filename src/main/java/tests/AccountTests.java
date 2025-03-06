package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.AccountPage;
import page.HomePage;
import page.LoginPage;
import utils.FileUtils;

public class AccountTests extends BaseTest {
	WebDriver driver;
	@BeforeMethod
	public void precondition() throws FileNotFoundException, IOException {
		driver = getBrowserDriver("Chrome", false);
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.usename"),FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver);
	}
	@AfterMethod
	public void postcondition() {
		driver.quit();
	}
	
	@Test
	public void  CreateAccount_TC10() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.accounts();
		AccountPage acp = new AccountPage(driver);
		assertTrue(acp.accountwithUser().equals("ASWINI Raja"),"Account with correct username is not displayed");
//		AccountPage acp = new AccountPage(driver);
//		acp.accountpage();
		acp.newButton();
		acp.accountName(FileUtils.readAccountPagePropertiesFile("account.Name"));
		acp.saveButton();
	}
	
	@Test
	public void  Createnewview_TC11() throws FileNotFoundException, IOException {
		
		HomePage hm = new HomePage(driver);
		hm.accounts();
		AccountPage acp = new AccountPage(driver);
		assertTrue(acp.accountwithUser().equals("ASWINI Raja"),"Account with correct username is not displayed");
		acp.createNewView();
		acp.CreateViewName();
		acp.accountNewView();
		
	}
	
	@Test
	public void   Editview_TC12() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.accounts();
		AccountPage acp = new AccountPage(driver);
		assertTrue(acp.accountwithUser().equals("ASWINI Raja"),"Account with correct username is not displayed");
		acp.editTheView();
		
	}

}
