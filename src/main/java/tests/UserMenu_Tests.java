package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.HomePage;
import page.LoginPage;
import page.UserMenu;
import utils.FileUtils;

public class UserMenu_Tests extends BaseTest {
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
	public void userMenuDropDown_TC05() {
		
		UserMenu um = new UserMenu(driver);
		um.mouseover();
		um.usernameDropdown();
	}
	
	@Test
	public void developerConsole_TC08() throws InterruptedException {
		UserMenu um = new UserMenu(driver);
		um.mouseover();
		um.usernameDropdown();
		um.developerConsole();
		Thread.sleep(2000);
		um.WindowHandler();
		
	}
	
	@Test
	public void loginpageCheck_TC09() {
		UserMenu um = new UserMenu(driver);
		um.mouseover();
		um.usernameDropdown();
		um.logout();
		
	}
	
	
	
	
	
	

}
