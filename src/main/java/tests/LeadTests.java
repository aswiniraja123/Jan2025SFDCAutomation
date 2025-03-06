package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.HomePage;
import page.LeadsPage;
import page.LoginPage;
import utils.FileUtils;

public class LeadTests extends BaseTest {
	
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
	public void checkLeadsTabLink_TC20() {
		HomePage hm = new HomePage(driver);
		hm.leads();
		
	}
	
	@Test
	public void leadsSelectView_TC21() throws FileNotFoundException, IOException {
		
		HomePage hm = new HomePage(driver);
		hm.leads();
		LeadsPage lp = new LeadsPage(driver);
		lp.leadsDropdown();
		
	}
	
	@Test
	public void defaultView_TC22() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.leads();
		LeadsPage lp = new LeadsPage(driver);
		lp.viewDropDown();
		
		
	}
	
	@Test
	public void ClickTodayView_TC023() {
		HomePage hm = new HomePage(driver);
		hm.leads();
		LeadsPage lp = new LeadsPage(driver);
		lp.SelectViewDrpDown();


	}
	
	@Test
	public void CheckNewButtonOnLead_TC024() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.leads();
		LeadsPage lp = new LeadsPage(driver);
		lp.enterValue();
		
	}
	
	
	
	
	
	
	
	

}
