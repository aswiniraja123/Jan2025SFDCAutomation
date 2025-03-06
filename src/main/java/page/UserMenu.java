package page;

import static org.testng.Assert.assertTrue;

import java.sql.Driver;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserMenu extends BasePage {
	
	public UserMenu(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(id= "userNavLabel")
	public WebElement username;
	
	@FindBy(id= "userNav-arrow")
	public WebElement usernameDropdown;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[1]")
	public WebElement myProfile;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[2]")
	public WebElement mySettings;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[3]")
	public WebElement developerConsole;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[4]")
	public WebElement switchToLightingExprerience;
	
	@FindBy(xpath="//*[@id='userNav-menuItems']/a[5]")
	public WebElement logout;
	
	public void mouseover() {
		Actions action = new Actions(driver);
		action.moveToElement(username).click().perform();
	}
	
	public void Clicklogout() {
		//mouseover();
		this.logout.click();
		
	}
	
	public LoginPage logout() {
		//mouseover();
		Clicklogout();
		return new LoginPage(driver);
	}
	
	public void myProfile() {
		mouseover();
		this.myProfile.click();
	}
	
	public void mySetting() {
		mouseover();
		this.mySettings.click();
	}
	
	public void developerConsole() {
		//mouseover();
		this.developerConsole.click();
	}
	
	public void usernameDropdown () {
		String expectedMenu[] = {"My Profile","My Settings","Developer Console","Switch to Lightning Experience","Logout"};
		List<WebElement>elements = driver.findElements(By.xpath("//*[contains(@id,'userNav-menuItems')]/a"));
		int i = 0;
		for(WebElement element:elements) {
			String menuItems = element.getText();
			
			assertTrue(menuItems.equals(expectedMenu[i]), "Invalid" + menuItems); 
//				System.out.println("Valid" + menuItems);
//			} else {
//				System.out.println("Invalid");
//			}
			
			i++;
		}
			
		}
	
	public void validationlogout() {
		String loginpagecheck = driver.getTitle();
		assertTrue(loginpagecheck.equals("Login | Salesforce"),"LoginPage is not displayed");
//		if(loginpagecheck.equals("Login | Salesforce")) {
//			System.out.println("loginpage page is displayed");
//		}
//		else {
//			System.out.println("loginpage page is not displayed");
//		}
	}
	
	public HomePage WindowHandler() throws InterruptedException {
		String oldwindowID1 = driver.getWindowHandle();
		Set<String>windowIDs = driver.getWindowHandles();
		String[]getwindow =windowIDs.toArray(new String [windowIDs.size()]);
		Thread.sleep(2000);
		driver.switchTo().window(getwindow[1]);
		String checkwindow = driver.getTitle();
		assertTrue(checkwindow.equals("Developer Console"),"New developer window is not opened");
		driver.close();
		driver.switchTo().window(oldwindowID1);
		Thread.sleep(2000);
		return new HomePage(driver);
	}

}
