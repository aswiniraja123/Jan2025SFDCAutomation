package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import page.OpportunityPage;
import utils.FileUtils;

public class OpportunityTest extends BaseTest {
	
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
	public void opportunityDropDown_TC15() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.opportunites();
		OpportunityPage op = new OpportunityPage(driver);
		assertTrue(op.opportunityPage().equals(FileUtils.readOpportunityPagePropertiesFile("oppHomePage")),"Opportunity page not displayed");
		op.opportunityDropdown();
		
	}
	
	@Test
	public void CreateanewOpty_TC16() throws FileNotFoundException, IOException {
		HomePage hm = new HomePage(driver);
		hm.opportunites();
		OpportunityPage op = new OpportunityPage(driver);
		assertTrue(op.opportunityPage().equals(FileUtils.readOpportunityPagePropertiesFile("oppHomePage")),"Opportunity page not displayed");
		op.opportunityDropdown();
		op.newOppPage();
		
	}
	
	@Test
	public void  OpportunityPipelineReport_TC17() {
		HomePage hm = new HomePage(driver);
		hm.opportunites();
		OpportunityPage op = new OpportunityPage(driver);
		op.PipelineReportopportunitypage();
		
		
	}
	
	@Test
	public void StuckOpportunitiesReport_TC18() {
		HomePage hm = new HomePage(driver);
		hm.opportunites();
		OpportunityPage op = new OpportunityPage(driver);
		op.stuck_Opportunity();
		
	}
	
	
	
	
	
	

}
