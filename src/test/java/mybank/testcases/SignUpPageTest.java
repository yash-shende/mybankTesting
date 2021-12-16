package mybank.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.SignUpPage;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class SignUpPageTest extends BaseTest {

	String[] newnline;
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());

	// Driver setup
	@BeforeTest
	public void setUp() {
		driver = utils.browserSetup();
		logger.info("before suit log..");
		logger.warn("Browser just launched !");
	}

	// sign up with correct data
	@Test(priority = 1)
	public void EnterData() throws IOException {
		test = extent.createTest("Data driven Testing on SignUp Page  ",
				"Testing SignUp page using user credentials from CSV FILE");
		test.info("Browser launched successfully");
		driver.get("http://localhost/mybank/Register.php");

		ArrayList<String[]> rows = utils.CSVReader("signUp.csv");

		Select drpGender;
		SignUpPage signup = new SignUpPage(driver);

		// String[] row= rows.get(index); //To Access Specific row of CSV file we can
		// use This Method using row index

		for (String[] row : rows) {  //ForEach loop to access all rows of the Sign CSV file 

			String CustomerFirstName = row[0];
			String CustomerLastName = row[1];
			String CustomerEmail = row[2];
			String CustomerBankAcc = row[3];
			String CustomerDOB = row[4];
			String Customergender = row[5];
			String CustomerPassword = row[6];
			String CustomerRePass = row[7];
			String CustomerCountry = row[8];

			logger.info("Successfully Fetched Data from Signup Details CSV file");
			test.info("Successfully Fetched Data of "+CustomerFirstName+" "+CustomerLastName+" From Signup Details CSV file");
			System.out.println(CustomerFirstName);

			signup.enterFirstName(CustomerFirstName);
			signup.enterLastName(CustomerLastName);
			signup.enterEmail(CustomerEmail);
			signup.enterBankAcc(CustomerBankAcc);

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

			logger.info("User Signed Up Successfully !");
			test.pass("User :"+CustomerFirstName+" "+CustomerLastName+" Signed Up Successfully !");


		}
		driver.switchTo().newWindow(WindowType.TAB); // selenium 4 navigate between TABS used
		
//		driver.switchTo().newWindow(WindowType.WINDOW);  selenium 4 navigate between WINDOWS used
		
		driver.navigate().to("http://localhost/mybank/Login.php");  

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
