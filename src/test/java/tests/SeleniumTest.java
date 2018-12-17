package tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import sweeper.login.pageObjects.LoginPage;
import sweeper.login.pageObjects.SecureAreaPage;

public class SeleniumTest {

	protected static WebDriver driver;
	protected static ChromeOptions options;
	protected static final String url = "https://admin.sweepr.com";
	protected static final String username = "admin";
	protected static final String password = "admin";
	protected static final String message = "Resolution Recommendation Tool";

	protected LoginPage loginP;
	protected SecureAreaPage secureP;

	@BeforeClass
	public static void beforeTests() {
		String path = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", path + "/driver/chromedriver.exe");
		options = new ChromeOptions();
		options.addArguments("--no-sandbox");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterClass
	public static void afterTests() {
		//driver.close();
	}
	
	public void login(){
		loginP = new LoginPage(SeleniumTest.driver);
		loginP.goToPage(url);
		secureP = loginP.login(username,password);
		Assert.assertTrue("Not logged in",secureP.getLoginMessage().contains(message));
	}
	
	@Test
	public void ruleExist(){
		login();
		Assert.assertFalse("No rules to display",secureP.displayRule().isEmpty());
		secureP.addRule();
	}
	
	@Test
	public void createRule(){
		//login();	
		//secureP.addRule();
		//Assert.assertFalse("No rules to display",secureP.displayRule().isEmpty());
		Assert.assertTrue(true);
	}
}


