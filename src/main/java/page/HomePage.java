package page;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utils.WaitUtils;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) {
		super(driver);
		WaitUtils.waitForElement(driver, home);
		String title = driver.getTitle();
		assertTrue(title.contains("Home Page ~ Salesforce - Developer Edition"));
		
		
		
	}
	
	@FindBy(xpath="//a[contains(@title, 'Home')]")
	public WebElement home;
	
	@FindBy(xpath="//*[@id='Chatter_Tab']/a")
	public WebElement chatter;
	
	@FindBy(xpath="//*[@id='Lead_Tab']/a")
	public WebElement leads;
	
	
	
	@FindBy(xpath="//*[@id='Account_Tab']/a")
	public WebElement accounts;
	
	@FindBy(xpath="//*[@id='Contact_Tab']/a")
	public WebElement contacts;
	
	@FindBy(xpath="//*[@id='Opportunity_Tab']/a")
	public WebElement opportunites;
	
	@FindBy(id= "tsid-arrow")
	public WebElement setDropdown;
	


	@FindBy(xpath="//*[@id='ptBody']/div/div[2]/span[1]/h1/a")
	public WebElement userProfile;
	
	@FindBy(xpath="//*[@id='publisherAttachTextPost']/span[1]")
	public WebElement postButton;
	
	@FindBy(xpath="//*[@id='ptBody']/div/div[2]/span[2]/a")
	public WebElement datelink;
	
	@FindBy(xpath="//*[@id='publisherAttachContentPost']")
	public WebElement file;
	
	@FindBy(id="publishersharebutton")
	public WebElement share;
	
	@FindBy(linkText="Upload a file from your computer")
	public WebElement uploadFileComp;
	
	@FindBy(id="chatterFile")
	public WebElement chooseFile;
	
	public void accounts() {
		this.accounts.click();
	}
	
	public void home() {
		this.home.click();
	}
	
	public void chatter() {
		this.chatter.click();
	}
	
	public void leads() {
		this.leads.click();
	}
	
	public void contacts() {
		this.contacts.click();
	}
	
	public void opportunites() {
		this.opportunites.click();
	}
	
	
	
	public void userProfile(String username) {
		this.userProfile.click();
	}
	
	public void datelink(String username) {
		this.datelink.click();
	}
	
	public void file() {
		this.file.click();
	}
	
	public void share() {
		this.share.click();
	}
	
	public void uploadFileComp() {
		this.uploadFileComp.click();
	}
	
	public void chooseFile() {
		this.chooseFile.click();
	}
	
	
	
	
//	public void validateHomePageTitle(String username) {
//		String title = driver.getTitle();
//		assertTrue(title.contains("Home Page ~ Salesforce - Developer Edition"));
//		
//}
}
