package mybank.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import mybank.pages.HomePageNavBar;
import mybank.utility.*;

public class HomePageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	// Logger logger = utils.log4jSetup(this.getClass().getName());
	Logger logger = utils.log4jSetup(this.getClass().getName());

	@BeforeTest
	public void beforeSuite() {
		
		logger.info("before suit log..");
		driver = utils.browserSetup();		
		logger.warn("Browser just launched !");
	}

	@Test
	public void LoginTest() {
		test = extent.createTest("Home Page Test", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing the Home page UI elements ");
		
		driver.get("http://localhost/mybank/homepage.php"); // getting HomePage URL

		String actualTitle = driver.getTitle();
		String expectedTitle = "MyBank- Official Home Page";
		try {
			Assert.assertEquals(expectedTitle, actualTitle);
			logger.info("Homepage Load successful / Test Succssfull");
		} catch (AssertionError e) {
			System.out.println("Homepage loading failed");
			logger.error("Error occured with assert statement !");
			throw e;
		}

	}

	@Test(priority = 1)
	public void mybankLogoClickTest() {
		test = extent.createTest("Testing MyBank logo", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing the mybank logo");
		
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickmybankLogo();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/homepage.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("MyBank logo working properly !");
			logger.info("MyBank logo working properly!!");
		}

		catch (AssertionError e) {
			System.out.println("MyBank logo not working ");
			test.fail("MyBank Logo failed functionality ");
			logger.error("Error occured with MyBank logo!");
		}
		// back to homepage

	}

	@Test(priority = 2)
	public void homeClickTest() {
		test = extent.createTest("Testing Home Page button ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Home Page button");
		HomePageNavBar navBar = new HomePageNavBar(driver);
		// RequestAtmPage reqAtmPage = new RequestAtmPage(driver);

		navBar.clickhome();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/homepage.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Home btn working properly !");
			logger.info("Home btn working properly!!");
		}

		catch (AssertionError e) {
			System.out.println("Home btn not working ");
			test.fail("Home btn failed functionality ");
			logger.error("Error occured with Home btn!");
		}
		// driver.navigate().back(); //back to homepage

	}

	@Test(priority = 3)
	public void featuresClickTest() {
		test = extent.createTest("Testing Features Button NavBar ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Features Button NavBar");
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickFeaturesBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/features.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Features btn working properly !");
			logger.info("Features btn working properly!!");
		}

		catch (AssertionError e) {
			System.out.println("Features btn not working ");
			test.fail("Features btn failed functionality ");
			logger.error("Error occured with Features btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 4)
	public void aboutFAQsClickTest() {
		test = extent.createTest("Testing FAQ/About Button NavBar ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing FAQ/About Button NavBar");
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickAboutFAQsBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/about.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("AboutFAQs btn working properly !");
			logger.info("AboutFAQs btn working properly!!");
		}

		catch (AssertionError e) {
			System.out.println("AboutFAQs btn not working ");
			test.fail("AboutFAQs btn failed functionality ");
			logger.error("Error occured with AboutFAQs btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 5)
	public void contactUsClickTest() {
		test = extent.createTest("Testing Contact US button", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Contact US button");
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickContactUsBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/contact.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("ContactUs btn working properly !");
			logger.info("ContactUs btn working properly!!");
		}

		catch (AssertionError e) {
			test.fail("ContactUs btn failed functionality ");
			logger.error("Error occured with ContactUs btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 6)
	public void safetyBankingTipsClickTest() {
		test = extent.createTest("Testing SafetyBanking Tips Button", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Contact US button");
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickSafetyBankingTipsBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/safetytips.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("SafetyBankingTips btn working properly !");
			logger.info("SafetyBankingTips btn working properly!!");
		}

		catch (AssertionError e) {
			test.fail("SafetyBankingTips btn failed functionality ");
			logger.error("Error occured with SafetyBankingTips btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 7)
	public void adminLoginClickTest() {
		test = extent.createTest("Testing AdminLogin Button ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing AdminLogin Button ");
		HomePageNavBar navBar = new HomePageNavBar(driver);
		// RequestAtmPage reqAtmPage = new RequestAtmPage(driver);

		navBar.clickAdminLoginBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/adminLogin.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("AdminLogin btn working properly !");
			logger.info("AdminLogin btn working properly!!");
		}

		catch (AssertionError e) {
			test.fail("AdminLogin btn failed functionality ");
			logger.error("Error occured with AdminLogin btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 8)
	public void loginClickTest() {
		test = extent.createTest("Testing login Button ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing login Button ");
		HomePageNavBar navBar = new HomePageNavBar(driver);
		// RequestAtmPage reqAtmPage = new RequestAtmPage(driver);

		navBar.clickLoginBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/Login.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Login btn working properly !");
			logger.info("Login btn working properly!!");
		}

		catch (AssertionError e) {
			test.fail("Login btn failed functionality ");
			logger.error("Error occured with Login btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 9)
	public void signUpClickTest() {
		test = extent.createTest("Testing SignUp Button ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing SignUp Button ");
		HomePageNavBar navBar = new HomePageNavBar(driver);

		navBar.clickSignUpBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/Register.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("SignUp btn working properly !");
			logger.info("SignUp btn working properly!!");
		}

		catch (AssertionError e) {
			test.fail("SignUp btn failed functionality ");
			logger.error("Error occured with SignUp btn!");
		}
		driver.navigate().back(); // back to homepage

	}

	@Test(priority = 10)
	public void contactUsTest() {
		test = extent.createTest("Testing Contact Us Button ", "Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Contact Us Button ");

		driver.get("http://localhost/mybank/homepage.php");
		driver.manage().window().setSize(new Dimension(1295, 695));

		// used js executor to scroll down
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.id("bottom-ContactUs-btn")).click();
		driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) > h3")).click();
		String contact = driver.findElement(By.cssSelector(".col-sm-4:nth-child(1) > h3")).getText();
		String ex = "Kolkata Branch";
		if (contact.contains(ex)) {
			test.pass("ContactPage Visible ");
			logger.info("ContactPage Visible ");
		} else {
			test.fail("ContactPage not Visible ");
			logger.error("ContactPage not Visible ");
		}

	}

	@Test(priority = 11)
	public void redirectSafetyTips() {
		test = extent.createTest("Testing Safety tips Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Safety tips Button redirection");
		
		driver.get("http://localhost/mybank/homepage.php");
		driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.linkText("Safety Banking Tips")).click();
		String safetyUrl = driver.getCurrentUrl();
		String expSafetyTitle = "http://localhost/mybank/safetytips.php";

		try {
			assertEquals(safetyUrl, expSafetyTitle);
			test.pass("safety link working properly !");
			logger.info("safety linkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("safety linkfailed functionality ");
			logger.error("Error occured with safety link!");
		}
	}

	@Test(priority = 12)
	public void redirectFacebook() {
		test = extent.createTest("Testing Facebook Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Facebook Button redirection");
		driver.get("http://localhost/mybank/homepage.php");
		driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-facebook")).click();
		String safetyUrl = driver.getCurrentUrl();
		String expSafetyUrl = "https://www.facebook.com/";

		try {
			assertEquals(safetyUrl, expSafetyUrl);
			test.pass("redirect Facebook link working properly !");
			logger.info("redirect Facebooklinkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect Facebook link failed functionality ");
			logger.error("Error occured with redirect to Facebook!");
		}
	}

	@Test(priority = 13)
	public void redirectTwitter() {
		test = extent.createTest("Testing Twitter Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Twitter Button redirection");
		
		driver.get("http://localhost/mybank/homepage.php");
		driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-twitter")).click();
		String safetyUrl1 = driver.getCurrentUrl();
		String expSafetyTitle = "https://twitter.com/i/flow/login";

		try {
			assertEquals(safetyUrl1, expSafetyTitle);
			test.pass("redirect twitter link working properly !");
			logger.info("redirect twitter link working properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect twitter link failed functionality ");
			logger.error("Error occured with redirect to twitter!");
		}
	}

	@Test(priority = 14)
	public void redirectYoutube() {
		test = extent.createTest("Testing Youtube Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Youtube Button redirection");
		driver.get("http://localhost/mybank/homepage.php");
		// driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-youtube")).click();
		String safetyUrl = driver.getCurrentUrl();
		String expSafetyTitle = "https://www.youtube.com/";

		try {
			assertEquals(safetyUrl, expSafetyTitle);
			test.pass("redirect Youtube link working properly !");
			logger.info("redirect Youtube linkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect Youtube link failed functionality ");
			logger.error("Error occured with redirect to Youtube!");
		}
	}

	@Test(priority = 15)
	public void redirectGoogle() {
		test = extent.createTest("Testing Google Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Google Button redirection");
		driver.get("http://localhost/mybank/homepage.php");
		// driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-google")).click();
		String safetyUrl = driver.getCurrentUrl();
		String expSafetyTitle = "https://www.google.co.in/";

		try {
			assertEquals(safetyUrl, expSafetyTitle);
			test.pass("redirect Google link working properly !");
			logger.info("redirect Google linkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect Google link failed functionality ");
			logger.error("Error occured with redirect to Google!");
		}
	}

	@Test(priority = 16)
	public void redirectInstagram() {
		test = extent.createTest("Testing instagram Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing instagram Button redirection");

		driver.get("http://localhost/mybank/homepage.php");
		// driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-instagram")).click();
		String safetyUrl = driver.getCurrentUrl();
		System.out.println(safetyUrl);
		String expSafetyTitle = "https://www.instagram.com/?hl=en";

		try {
			assertEquals(safetyUrl, expSafetyTitle);
			test.pass("redirect Instagram link working properly !");
			logger.info("redirect Instagram linkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect Instagram link failed functionality ");
			logger.error("Error occured with redirect to Instagram!");
		}
	}

	@Test(priority = 17)
	public void redirectLinkedIn() {
		
		test = extent.createTest("Testing Linkedin Button redirection","Testing the Home page UI elements ");
		test.log(Status.INFO,"Testing Linkedin Button redirection");
		
		driver.get("http://localhost/mybank/homepage.php");
		driver.manage().window().setSize(new Dimension(1295, 695));
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		driver.findElement(By.cssSelector("body > div.footer > div > div:nth-child(2) > a.fa.fa-linkedin")).click();
		String safetyUrl = driver.getCurrentUrl();
		String expSafetyTitle = "https://www.linkedin.com/uas/login?_l=en";

		try {
			assertEquals(safetyUrl, expSafetyTitle);
			test.pass("redirect LinkedIn link working properly !");
			logger.info("redirect LinkedIn linkworking properly!!");
		}

		catch (AssertionError e) {
			test.fail("redirect LinkedIn link failed functionality ");
			logger.error("Error occured with redirect to LinkedIn!");
		}
	}
	@AfterMethod
	public void temp(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String ssPath = utils.getScreenshot();
			test.fail("Failed !!",MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
	}

	@AfterTest
	public void tear() {
		driver.close();
		driver.quit();
		logger.info("All Done!");

	}
}

