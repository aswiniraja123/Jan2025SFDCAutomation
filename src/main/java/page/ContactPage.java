package page;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class ContactPage extends BasePage {
	public ContactPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(id = "fcf")
	public WebElement selectview;

	@FindBy(name = "go")
	public WebElement go;

	@FindBy(linkText = "Edit")
	public WebElement edit;

	@FindBy(linkText = "Create New View")
	public WebElement createNewView;

	@FindBy(name = "new")
	public WebElement newButton;

	@FindBy(xpath = "//*[@id='hotlist_mode']")
	public WebElement recentlyCreated;
	
	@FindBy(xpath = "//*[@id='bodyCell']/div[3]/div[1]/div/div[2]/table/tbody/tr[2]/th/a")
	public WebElement contactName;
	
	

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

	// new contactpage;
	@FindBy(name = "save")
	public WebElement saveButton;

	@FindBy(name = "save_new")
	public WebElement saveAndNewButton;

	@FindBy(id = "con4")
	public WebElement accountName;

	@FindBy(xpath = "//*[@id='name_lastcon2']")
	public WebElement lastName;

	public void saveButton() {
		this.saveButton.click();
	}

	public void saveAndNewButton() {
		this.saveAndNewButton.click();
	}

	public void accountName() throws FileNotFoundException, IOException {
		this.accountName.clear();
		this.accountName.sendKeys(FileUtils.readContactPagePropertiesFile("accountname.name"));

	}

	public void lastName() throws FileNotFoundException, IOException {
		this.lastName.clear();
		this.lastName.sendKeys(FileUtils.readContactPagePropertiesFile("lastName.name"));

	}

	// create newview page;

	@FindBy(id = "fname")
	public WebElement viewName;

	@FindBy(id = "devname")
	public WebElement viewUniqueName;

	@FindBy(name = "save")
	public WebElement save;

	public void EnterviewName() throws FileNotFoundException, IOException {
		this.viewName.clear();
		this.viewName.sendKeys(FileUtils.readContactPagePropertiesFile("viewname.name"));

	}

	public void EnterUniqueName() throws FileNotFoundException, IOException {

		this.viewUniqueName.click();
		this.viewUniqueName.sendKeys(FileUtils.readContactPagePropertiesFile("viewunique.name"));

	}

	public void ClickSave() {
		this.save.click();
	}

	@FindBy(name = "cancel")
	public WebElement cancle;
	
	@FindBy(xpath = "//*[@id='editPage']/div[2]/div[1]/div[2]/table/tbody/tr[1]/td[2]/div/div[2]")
	public WebElement errorMsg;

	public void contactpage() {
		String contactpage = driver.getTitle();
		assertTrue(contactpage.equals("Contacts: Home ~ Salesforce - Developer Edition"),
				"Contact page is not displayed");
	}

	public void createNewContact() throws FileNotFoundException, IOException {
		contactpage();
		newButton();
		String Newcontactpage = driver.getTitle();
		assertTrue(Newcontactpage.equals("Contact Edit: New Contact ~ Salesforce - Developer Edition"),
				"New Contact page is not displayed");
		this.lastName();
		this.accountName();
		saveButton();
		String newcontact = driver.getTitle();
		assertTrue(newcontact.equals("Contact: Raja ~ Salesforce - Developer Edition"), "New contact is not created");

	}

	public void createNewViewContact() throws FileNotFoundException, IOException {
		createNewView();
		String newviewPage = driver.getTitle();
		assertTrue(newviewPage.equals("Contacts: Create New View ~ Salesforce - Developer Edition"),"new view page not displayed");
		this.EnterviewName();
		this.EnterUniqueName();
		ClickSave();


	}
	
	public void checkDrpDown() {
		contactpage();
		this.recentlyCreated.click();
		Select viewdrpdown = new Select(this.recentlyCreated);
		viewdrpdown.selectByVisibleText("Recently Created");
		String RecentlycreatedContact = driver.getTitle();
		assertTrue(RecentlycreatedContact.equals("Contacts: Home ~ Salesforce - Developer Edition"),"Recently created contacts not displayed");
		
	}
	
	public void selectViewDrpDown() {
		contactpage();
		selectview();
		Select viewdropdown = new Select(this.selectview);
		viewdropdown.selectByVisibleText("My Contacts");
		String contact = driver.getTitle();
		assertTrue(contact.equals("Contacts ~ Salesforce - Developer Edition"),"My Contacts is not selected");
	}
	
	public void checkContactName() {
		contactpage();
		contactName.click();
		String contactName = driver.getTitle();
		assertTrue(contactName.equals("Contact: Raja ~ Salesforce - Developer Edition"),"contact name page not displayed");
		
		
	}
	
	public boolean validateErrorMessage(String expectedErrorMsg )  {
		String actualErrorMsg = errorMsg.getText();
		return actualErrorMsg.equals(expectedErrorMsg);
	}
	
	public void checkErrorMsg() throws FileNotFoundException, IOException {
		contactpage();
		createNewView();
		this.EnterUniqueName();
		ClickSave();


	}
	
	public void CancelButton() throws FileNotFoundException, IOException {
		contactpage();
		createNewView();
		this.EnterviewName();
		this.EnterUniqueName();
		cancle.click();
		
		
		
	}

}
