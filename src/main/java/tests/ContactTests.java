package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import listerns.TestListeners;
import page.ContactPage;
import page.HomePage;
import page.LoginPage;
import utils.FileUtils;

//@Listeners(TestListeners.class)

public class ContactTests extends BaseTest {
	
	WebDriver driver;
	@BeforeMethod
	public void precondition() throws FileNotFoundException, IOException {
		driver = getBrowserDriver("Chrome", false);
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.usename"),FileUtils.readLoginPropertiesFile("valid.password"));
		
	}
	
	@AfterMethod
	public void postcondition() {
		driver.quit();
	}
	
	@Test
	public void CreateNewContact_TC25() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		cp.createNewContact();
	}
	
	@Test
	public void CreateNewViewContactPage_TC26() throws FileNotFoundException, IOException {
		
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		cp.createNewViewContact();
		
	}
	
	@Test
	public void CheckRecentlyCreatedContact_TC27() {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		cp.checkDrpDown();
		
	}
	
	@Test
	public void CheckMyContacts_TC28() {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		cp.selectViewDrpDown();
		
	}
	
	@Test
	public void ViewContactNameDetalis_TC29() {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		//test.log(Status.INFO, "Contact page displayed in SDFC");
		ContactPage cp = new ContactPage(driver);
		cp.checkContactName();
		
	}
	
	@Test
	public void checkErrorMsg_TC30() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		cp.checkErrorMsg();
		//test.log(Status.INFO, "Create New View page is opened");
		assertTrue(cp.validateErrorMessage(FileUtils.readContactPagePropertiesFile("error.InvalidUniqueName")),"verify invalid uniquename error message");
		
		
	}
	
	@Test
	public void checkCancelButton_TC31() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.contacts();
		ContactPage cp = new ContactPage(driver);
		//test.log(Status.INFO, "Contact page displayed in SDFC");
		cp.CancelButton();
		//test.log(Status.INFO, "View new name page not created");
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
