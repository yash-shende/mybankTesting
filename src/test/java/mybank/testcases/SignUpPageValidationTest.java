package mybank.testcases;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.opencsv.CSVReader;

import mybank.pages.SignUpPage;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class SignUpPageValidationTest extends BaseTest  {

	String[] row;
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());
	ArrayList<String[]> rows;
	String CustomerFirstName, CustomerLastName, CustomerEmail, CustomerBankAcc, CustomerDOB, Customergender,
			CustomerPassword, CustomerRePass, CustomerCountry;

	// Driver setup
	@BeforeTest
	public void setUp() {
		driver = utils.browserSetup();
		logger.info("before suit log..");
		logger.warn("Browser just launched !");
	}

	@Test(priority = 1)
	public void SignUpWithInvalidEmailId() throws IOException {
		test = extent.createTest("Data driven Testing on SignUp Page with invalid Email id ",
				"Testing SignUp page using Invalid user credentials from CSV FILE");
		test.info("Browser launched successfully");
		driver.get("http://localhost/mybank/Register.php");
		
		SignUpPage signup = new SignUpPage(driver);
		Select drpGender;
		
		rows = utils.CSVReader("signUpInvalidEmails.csv");
		
		for (String[] row : rows) {

			CustomerFirstName = row[0];
			CustomerLastName = row[1];
			CustomerEmail = row[2];
			CustomerBankAcc = row[3];
			CustomerDOB = row[4];
			Customergender = row[5];
			CustomerPassword = row[6];
			CustomerRePass = row[7];
			CustomerCountry = row[8];

			logger.info("Successfully Fetched Data from Signup Details CSV file");
			test.info("Successfully Fetched Data from Signup Details CSV file");
			System.out.println(CustomerFirstName);
			signup.enterFirstName(CustomerFirstName);
			signup.enterLastName(CustomerLastName);
			signup.enterEmail(CustomerEmail);
			signup.enterBankAcc(CustomerBankAcc);

			driver.findElement(By.xpath("//body")).click();
			driver.switchTo().alert().accept();
 
			drpGender = signup.enterGender();
			if (Customergender.equalsIgnoreCase("Female")) {
				drpGender.selectByVisibleText("Female");
			} else {
				drpGender.selectByVisibleText("Male");
			}

			signup.enterPassword(CustomerPassword);
			signup.enterRePass(CustomerRePass);
			signup.enterCountry(CustomerCountry);

			signup.enterDOB(CustomerDOB); // Format for Date should be "1998-10-07"

			signup.clickSignUpBtn();

			String actualURL = driver.getCurrentUrl();
			String expectedURL = "http://localhost/mybank/Register.php";

			if (actualURL.equalsIgnoreCase(expectedURL)) {
				logger.info("Invalid Email id = " + CustomerEmail);
				test.warning("Invalid Email id = " + CustomerEmail);

			}
		}
	}

	@Test(priority = 2)
	public void signWithInvalidAccNumber() throws IOException {
		test = extent.createTest("Data driven Testing on SignUp Page with invalid Account Number ",
				"Testing SignUp page using Invalid user credentials from CSV FILE");
		test.info("Browser launched successfully");
		
		SignUpPage signup = new SignUpPage(driver);
		
		rows = utils.CSVReader("signUpInvalidAccNums.csv");
		
		for (String[] row : rows) {

			CustomerFirstName = row[0];
			CustomerLastName = row[1];
			CustomerEmail = row[2];
			CustomerBankAcc = row[3];
			CustomerDOB = row[4];
			Customergender = row[5];
			CustomerPassword = row[6];
			CustomerRePass = row[7];
			CustomerCountry = row[8];

		
		signup.enterFirstName(CustomerFirstName);
		signup.enterLastName(CustomerLastName);
//		signup.enterEmail(CustomerEmail);
		signup.enterBankAcc(CustomerBankAcc);

		driver.findElement(By.xpath("//body")).click();
		driver.switchTo().alert().accept();

		boolean isEnaable = signup.submitDisabled();
		if (isEnaable) {
			logger.warn("Submit button is not disabled!");
			test.warning("Submit button is not disabled");

		}
		else {
			String path = utils.getScreenShotOfElement(signup.Submit);
			System.out.println("Submit Button is disabled");
			logger.info("Submit button is disabled successfully !");
			test.warning("Submit button is disabled successfully!",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}

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
