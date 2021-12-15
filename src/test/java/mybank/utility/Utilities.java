
package mybank.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import com.opencsv.CSVReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import mybank.pages.AdminLoginPage;
import mybank.pages.UserLoginPage;

public class Utilities extends BaseTest {

	WebDriver driver;
	static Logger logger;
	SoftAssert soft = new SoftAssert();
	String ssPath;
	String userDir = System.getProperty("user.dir");

	@SuppressWarnings("deprecation")
	public WebDriver browserSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		return driver;
	}

	public static Logger log4jSetup(String className) {
		logger = Logger.getLogger(className);
		PropertyConfigurator.configure("log4j2.properties");
		return logger;
	}

	public boolean userLogin(String uName, String Pass) {
		UserLoginPage userLoginPage = new UserLoginPage(driver);

		driver.get("http://localhost/mybank/Login.php");

		userLoginPage.enterUserName(uName);
		userLoginPage.enterPassword(Pass);
		userLoginPage.clickLoginBtn();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Welcome, User";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Logined");
			logger.info("login successful / Test Succssfull");
			test.pass(" Login Successful for.. " + uName);
		} else {
			System.out.println("Login Failed");
			logger.error("Login Failed, invalid credientials or Your account could be blocked ");
			test.fail("Login Failed, invalid credientials or Your account could be blocked - " + uName);
			return false;
		}
		return true;
	}

	public boolean AdminLogin(String uName, String Pass) {
		AdminLoginPage adminloginpage = new AdminLoginPage(driver);

		driver.get("http://localhost/mybank/adminLogin.php");

		adminloginpage.enterAdminUserName(uName);
		adminloginpage.enterAdminPassword(Pass);
		adminloginpage.clickAdminLoginBtn();

		String actualTitle = driver.getTitle();
		String expectedTitle = "Admin";

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Logined");
			logger.info("Admin login successful / Test Succssfull");
			test.pass("Admin Login Successful !");
		} else {
			System.out.println("Login Failed");
			logger.error("Error occured with assert statement !");
			test.fail("Admin Login Failed, invalid credientials !");
			return false;
		}
		return true;

	}

	// Utility Method for Reading CSV FILE
	public ArrayList<String[]> CSVReader(String path) throws IOException {
		ArrayList<String[]> rows = new ArrayList<String[]>();
		String file = userDir + "\\files\\" + path;
		String[] newline;
		CSVReader reader = null;

		try {
			reader = new CSVReader(new FileReader(file));
		} catch (Exception e) {
			System.out.println("Unable To read Csv file " + " " + path);
		}
		while ((newline = reader.readNext()) != null) {
			rows.add(newline);
		}
		reader.close();
		return rows;
	}

	public ArrayList<String[]> buffredCsvReader(String path) {
		String line = "";
		String splitBy = ",";
		ArrayList<String[]> rows = new ArrayList<String[]>();
		System.out.println(userDir);
		try {
			// parsing a CSV file into BufferedReader class constructor
			BufferedReader br = new BufferedReader(new FileReader(userDir + "\\files\\" + path));
			while ((line = br.readLine()) != null)
			// returns a Boolean value
			{
				rows.add(line.split(splitBy));
				// use comma as separator
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rows;
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} // try
		catch (NoAlertPresentException e) {
			return false;
		} // catch
	} // isAlertPresent()

	public String getScreenshot() {
		Date currentdate = new Date();
		String screenshotefilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			ssPath = System.getProperty("user.dir") + "\\screenshot\\" + screenshotefilename + ".png";
			FileUtils.copyFile(screenshotFile, new File(ssPath));
		} catch (IOException e) {
			System.out.println("IO Exception occured while storing Screen Shot!");
		}
		return ssPath;
	}

	public String getScreenShotOfElement(By element) {
		Date currentdate = new Date();
		WebElement Element = driver.findElement(element);
	      // capture screenshot with getScreenshotAs() of the dropdown
	    File f = Element.getScreenshotAs(OutputType.FILE);
		String screenshotefilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		String path = System.getProperty("user.dir") + "\\screenshot\\ElementScreenShots\\" + screenshotefilename + ".png";
	    try {
			FileUtils.copyFile(f, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	    return path;
	}

}
