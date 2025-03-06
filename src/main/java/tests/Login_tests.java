package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import constants.FileConstants;
import listerns.TestListeners;
import page.ForgotPassWordPage;
import page.LoginPage;
import page.UserMenu;
import utils.FileUtils;
import utils.WaitUtils;
@Listeners(TestListeners.class)
public class Login_tests extends BaseTest {
	
	//WebDriver driver;
//	@BeforeMethod
//	public void precondition() throws FileNotFoundException, IOException {
//		driver = getBrowserDriver("Chrome", false);
//		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
//		//test.log(Status.INFO, "Chorme browser lunched with sdfc app");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	}
//	@AfterMethod
//	public void postcondition() {
//		driver.quit();
//	}
	@Test(priority=1)
	public void loginErrorMsg_TC01(Method name) throws FileNotFoundException, IOException {
		//test = report.createTest(name.getName());
		//test.log(Status.INFO, "Chorme browser lunched with sdfc app");
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		test.log(Status.INFO, "Chorme browser lunched with sdfc app");
		LoginPage lp = new LoginPage(driver);
		lp.loginWithInvalidUser("User@gmail.com", "");
		WaitUtils.waitForElement(driver, lp.errorMsg);
		assertTrue(lp.validateErrorMessage(FileUtils.readLoginPropertiesFile("error.text")),"Verify password erroe message");
		
	}
	
	@Test(priority=2)
	public void login_TC02() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(FileUtils.readLoginPropertiesFile("valid.usename"),FileUtils.readLoginPropertiesFile("valid.password"));
		test.log(Status.INFO, "Chorme browser lunched with sdfc app");
	}
	
	@Test(priority=3)
	public void CheckRemeberMe_TC03() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.loginToAppRemember(FileUtils.readLoginPropertiesFile("valid.usename"), FileUtils.readLoginPropertiesFile("valid.password"));
		UserMenu um = new UserMenu(driver);
		um.mouseover();
		um.logout();
		assertTrue(lp.validateUsername(),"Rember the username is verified");
		
		
	}
	
	@Test(priority=4)
	public void forgotPassword_TC04A() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.forgotYourPassword();
		ForgotPassWordPage fp = new ForgotPassWordPage(driver);
		fp.forgotPassWord();
		
	}
	
	@Test(priority=5)
	public void ForgotPassword4B_TC04B() throws FileNotFoundException, IOException {
		ExtentTest test = threadLocalTest.get();
		WebDriver driver = BaseTest.getBrowser();
		driver.get(FileUtils.readLoginPropertiesFile("prod.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		LoginPage lp = new LoginPage(driver);
		lp.loginWithInvalidUser(FileUtils.readLoginPropertiesFile("invalid.username"),FileUtils.readLoginPropertiesFile("invalid.password"));
		assertTrue(lp.validateErrorMessage(FileUtils.readLoginPropertiesFile("error.invaliduserpassword")),"verify invalid username error message");
	}
	
	
	
	

}
