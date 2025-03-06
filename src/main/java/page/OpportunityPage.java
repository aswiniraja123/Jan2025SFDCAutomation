package page;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class OpportunityPage extends BasePage {
	
	public OpportunityPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id= "fcf")
	public WebElement selectview;
	
	@FindBy(name= "go")
	public WebElement go;
	
	@FindBy(linkText= "Edit")
	public WebElement edit;
	
	@FindBy(linkText= "Create New View")
	public WebElement createNewView;
	
	@FindBy(name= "new")
	public WebElement newButton;
	
	@FindBy(linkText= "Opportunity Pipeline")
	public WebElement opportunity_pipeline;
	
	@FindBy(linkText= "Stuck Opportunities")
	public WebElement stuck_Opportunity;
	
	
	public void opportunity_pipeline() {
		this.opportunity_pipeline.click();
	}
	
	public void stuck_Opportunity() {
		this.stuck_Opportunity.click();
	}
	
	public void mouseover() {
		Actions action = new Actions(driver);
		action.moveToElement(selectview).click().perform();
	}
	
	
	
	
	public void selectview() {
		this.selectview.click();
	}
	
	public void go() {
		this.go.click();
	}
	
	public void edit() {
		this.edit.click();
	}
	
	public void createNewView() {
		this.createNewView.click();
	}
	
	public void newButton() {
		this.newButton.click();
	}
	public String opportunityPage() {
		String opportunityPage = driver.getTitle();
		return opportunityPage;
		
	}
	
	public void opportunityDropdown () {
		String expectedMenu[] = { "All Opportunities", "Closing Next Month", "Closing This Month", "My Opportunities","New Last Week", "New This Week","Opportunity Pipeline","Private", "Recently Viewed Opportunities","Won" };
		List<WebElement>elements = driver.findElements(By.xpath("//*[contains(@id,'fcf')]/option"));
		int i = 0;
		for(WebElement element:elements) {
			String menuItems = element.getText();
			assertTrue(menuItems.equals(expectedMenu[i]), "Invalid" + menuItems);
			i++;
		}
	}
	//newopportunitypagewebelements
	@FindBy(id= "opp3")
	public WebElement opportunityName;
	
	@FindBy(id= "opp4")
	public WebElement accountName;
	
	@FindBy(id= "opp6")
	public WebElement leadSource ;
	
	@FindBy(id= "opp9")
	public WebElement closeDate ;
	
	@FindBy(id= "opp11")
	public WebElement stage;
	
	@FindBy(id= "opp12")
	public WebElement probablity;
	
	@FindBy(id= "opp17")
	public WebElement primaryCampaignSource;
	
	@FindBy(name="save")
	public WebElement saveButton;
	
	@FindBy(name="save_new")
	public WebElement saveAndNewButton;

	public void enteropportunityName() throws FileNotFoundException, IOException {
		this.opportunityName.clear();
		this.opportunityName.sendKeys(FileUtils.readOpportunityPagePropertiesFile("opportunity.name"));
	}	
	
	public void ClickaccountName() throws FileNotFoundException, IOException {
		this.accountName.clear();
		this.accountName.sendKeys(FileUtils.readAccountPagePropertiesFile("account.Name"));
	}	
	
	public void ClickleadSource() throws FileNotFoundException, IOException{
		Select sl = new Select(this.leadSource);
		sl.selectByVisibleText(FileUtils.readOpportunityPagePropertiesFile("oppNewPage.leadsource"));
	}	
	
	public void ClickcloseDate() throws FileNotFoundException, IOException {
		this.closeDate.clear();
		this.closeDate.sendKeys(FileUtils.readOpportunityPagePropertiesFile("closedate.date"));
	}	
	
	public void Clickstage() throws FileNotFoundException, IOException {
		Select sl = new Select(this.stage);
		sl.selectByVisibleText(FileUtils.readOpportunityPagePropertiesFile("oppNewPage.stage"));
	}	
	
	public void Enterprobablity() throws FileNotFoundException, IOException {
		this.probablity.sendKeys(FileUtils.readOpportunityPagePropertiesFile("oppNewPage.probability"));
	}	
	
	public void EnterprimaryCampaignSource() throws FileNotFoundException, IOException {
		
		this.primaryCampaignSource.sendKeys(FileUtils.readOpportunityPagePropertiesFile("oppNewPage.primaryCampaignSource"));
	}	
	
	public void saveButton() {
		this.saveButton.click();
	}
	
	public void saveAndNewButton() {
		this.saveAndNewButton.click();
	}
	public void newOppPage() throws FileNotFoundException, IOException {
		this.newButton();
		this.enteropportunityName();
		this.ClickaccountName();
		this.ClickleadSource();
		this.ClickcloseDate();
		this.Clickstage();
		this.Enterprobablity();
		this.EnterprimaryCampaignSource();
		this.saveButton();
		String newOppPage = driver.findElement(By.linkText("Opportunity Detail")).getText();
		assertTrue(newOppPage.equals("Opportunity Detail"),"New opportunity page is not displayed");
		
	}
	
	public void PipelineReportopportunitypage() {
		opportunity_pipeline();
		
		String PipelineReportopportunitypage = driver.getTitle();
		assertTrue(PipelineReportopportunitypage.equals("Opportunity Pipeline ~ Salesforce - Developer Edition"),"Report with opportunity page is not displayed");
	}
	
	public void stuckopportunitypage() {
		stuck_Opportunity();
		String stuckopportunitypage = driver.getTitle();
		assertTrue(stuckopportunitypage.equals("Stuck Opportunities ~ Salesforce - Developer Edition"),"Stuck with opportunity page is not displayed");
	}
	

}
