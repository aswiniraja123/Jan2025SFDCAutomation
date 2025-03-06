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

public class LeadsPage extends BasePage{
	

	public LeadsPage(WebDriver driver) {
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
	
	@FindBy(name= "hotlist_mode")
	public WebElement recentlyviewed;
	
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
	
	public void leadPage() {
		String leadPage = driver.getTitle();
		assertTrue(leadPage.equals("Leads: Home ~ Salesforce - Developer Edition"),"Lead page is not displayed");
		
	}
	
	public void leadsDropdown () throws FileNotFoundException, IOException {
		selectview();
		String expectedMenu [] = {"All Open Leads", "My Unread Leads", "Recently Viewed Leads", "Today's Leads","View - Custom 1","View - Custom 2"};
		List<WebElement>elements = driver.findElements(By.xpath("//*[contains(@id,'fcf')]/option"));
		int i = 0;
		for(WebElement element:elements) {
			String menuItems = element.getText();
			assertTrue(menuItems.equals(expectedMenu[i]), "Invalid" + menuItems);
			i++;
		}
		
	}
	
	//new leadpage;
	@FindBy(id= "name_firstlea2")
	public WebElement firstName ;
	
	@FindBy(id= "name_lastlea2")
	public WebElement lastName ;
	
	@FindBy(id= "lea3")
	public WebElement companyName ;
	
	@FindBy(name= "save")
	public WebElement saveButton ;
	
	@FindBy(name= "Save & New")
	public WebElement saveAndNewButton ;
	
	@FindBy(id= "cancel")
	public WebElement cancel ;
	
	public void saveButton() {
		this.saveButton.click();
	}
	
	public void saveAndNewButton() {
		this.saveAndNewButton.click();
	}
	public void lastName() throws FileNotFoundException, IOException {
		this.lastName.clear();
		this.lastName.sendKeys(FileUtils.readLeadsPagePropertiesFile("lastName.name"));
	}	
	
	public void firstName(String firstName) {
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
	}	
	
	public void companyName() throws FileNotFoundException, IOException {
		this.companyName.clear();
		this.companyName.sendKeys(FileUtils.readLeadsPagePropertiesFile("companyName.name"));
	}	
	public void cancel() {
		this.cancel.click();
	}
	public void newleadPage() {
		String leadPage = driver.getTitle();
		assertTrue(leadPage.equals("Lead: ABCD ~ Salesforce - Developer Edition"),"New Lead page is not displayed");
	}
	
	public void viewDropDown() throws FileNotFoundException, IOException {
		Select viewdropdown = new Select(this.selectview);
		viewdropdown.selectByVisibleText("Today's Leads");
		UserMenu um = new UserMenu(driver);
		um.mouseover();
		um.logout();
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.usename"),FileUtils.readLoginPropertiesFile("valid.password"));
		HomePage hm = new HomePage(driver);
		hm.leads();
		LeadsPage lp1 = new LeadsPage(driver);
		lp1.go();
		String leadsGoPage = driver.getTitle();
		assertTrue(leadsGoPage.equals("Leads ~ Salesforce - Developer Edition"),"Lead Go page is not displayed");
	}
	
	public void SelectViewDrpDown() {
		selectview();
		Select viewdropdown = new Select(this.selectview);
		viewdropdown.selectByVisibleText("Today's Leads");
		assertTrue(viewdropdown.getFirstSelectedOption().getText().equals("Today's Leads"),"Today's Leads is not selected");


	}
	public void enterValue() throws FileNotFoundException, IOException {
		newButton();
		String NewleadEditPage = driver.getTitle();
		assertTrue(NewleadEditPage.equals("Lead Edit: New Lead ~ Salesforce - Developer Edition"),"New Lead edit page is not opened");
		this.lastName();
		this.companyName();
		saveButton();
		newleadPage();
		
	}
		

}
