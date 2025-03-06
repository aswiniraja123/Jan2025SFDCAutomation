package page;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import utils.FileUtils;

public class AccountPage extends BasePage{
	
	public AccountPage(WebDriver driver) {
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
	
	public String accountwithUser() {
		String accountwithuser = driver.findElement(By.id("userNavLabel")).getText();
//		assertTrue(accountwithuser.equals("ASWINI Raja"),"Account with correct username is not displayed");
		return accountwithuser;
		
	}
	@FindBy(name="save")
	public WebElement saveButton;
	
	@FindBy(name="save_new")
	public WebElement saveAndNewButton;


	@FindBy(id="acc2")
	public WebElement accountName;
	
	public void saveButton() {
		this.saveButton.click();
	}
	
	public void saveAndNewButton() {
		this.saveAndNewButton.click();
	}
	
	public void accountName(String accountName) {
		this.accountName.clear();
		this.accountName.sendKeys(accountName);
	}
	
	@FindBy(id="fname")
	public WebElement viewName;
	
	@FindBy(id="devname")
	public WebElement viewUniqueName;
	
	@FindBy(id="fcol1")
	public WebElement additional_field ;
	
	@FindBy(id="fop1")
	public WebElement additonal_operator ;
	
	@FindBy(id="fval1")
	public WebElement additional_value ;
	
	@FindBy(id="colselector_select_0")
	public WebElement avilable_field  ;
	
	@FindBy(id="colselector_select_1")
	public WebElement select_field ;
	
	@FindBy(name="save")
	public WebElement save ;
	
	@FindBy(xpath="//*[@id='colselector_select_0_right']/img")
	public WebElement add ;
	
	@FindBy(linkText = "Accounts with last activity > 30 days")
	public WebElement lastActivity30days ;


	public void EnterviewName() throws FileNotFoundException, IOException {
		this.viewName.clear();
		this.viewName.sendKeys(FileUtils.readAccountPagePropertiesFile("view.name"));
	
	}
	
	public void EnterUniqueName() throws FileNotFoundException, IOException {
		
		this.viewUniqueName.click();
		this.viewUniqueName.sendKeys(FileUtils.readAccountPagePropertiesFile("view.uniquename"));
	
	}
	
	public void ClickSave() {
		this.save.click();
	}
	
	public void CreateViewName() throws FileNotFoundException, IOException {
		EnterviewName();
		EnterUniqueName();
		ClickSave();
	}
	
//	public boolean newaccountpage() {
//		String newaccountpage = driver.getTitle();
//		boolean flag = false;
//		if(newaccountpage.equals("Account Edit: New Account ~ Salesforce - Developer Edition")) {
//			System.out.println("New view Account page is diplayed");
//			flag = true;
//		}
//		else {
//			System.out.println("New view Account page is not displayed");
//			
//		}
//		return flag;
//	
//	}
	
	public void accountNewView() {
		String accountnewview = driver.findElement(By.name("new")).getText();
		assertTrue(accountnewview.equals(accountnewview),"account new name is not displayed");
	}
	
	public void selectViewDropDown() throws FileNotFoundException, IOException {
		Select viewdrpdown = new Select(this.selectview);
		viewdrpdown.selectByVisibleText("All Accounts");
		edit();
		EnterviewName();
		
	}
	
	
	
	public void additionalField() {
		Select fieldrpdown = new Select(this.additional_field);
		fieldrpdown.selectByVisibleText("Account Name");
		Select operatordrpdown = new Select(this.additonal_operator);
		operatordrpdown.selectByVisibleText("contains");
		additional_value.sendKeys("a");


	}
	public void selectfieldDisolay() {
		Select availablefieldrpdown = new Select(this.avilable_field);
		availablefieldrpdown.selectByVisibleText("Last Activity");
		add.click();
		
		
		
	}
	public void editTheView() throws FileNotFoundException, IOException {
		selectViewDropDown();
		additionalField();
		selectfieldDisolay();
		saveButton();
		
		
	}
	
	

}
