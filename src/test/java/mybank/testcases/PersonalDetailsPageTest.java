package mybank.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.opencsv.CSVReader;
import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;

import mybank.pages.PersonalDetailsPage;
import mybank.pages.SideNavBar;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class PersonalDetailsPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());
	CSVReader reader;

	@BeforeTest
	public void beforeTest() {

		logger.info("before suit log..");
		driver = utils.browserSetup();
		// test.log(Status.INFO, "Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test
	public void personalDetailsTest() throws IOException {

		// Reading User Credentials CSV FILE
		ArrayList<String[]> rows = utils.CSVReader("dtbase.csv");

		test = extent.createTest("Login Page Test", "Testing Login Feature ");
		test.log(Status.INFO, "Browser launched successfully");

		SoftAssert soft = new SoftAssert();		
		String decodePass = "";
		String firstName;
		String lastName;
		String acc_num;
		SideNavBar sideBar = new SideNavBar(driver);
		PersonalDetailsPage personalDataPage = new PersonalDetailsPage(driver);
		
		
		for(String[] row:rows){
			firstName = row[1];
			lastName = row[2];
			acc_num = row[8];
			try {
				decodePass = new String(Base64.decode(row[4]));
			} catch (Base64DecodingException e) {
				System.out.println("Error While Decoding Password!!");
				logger.error("Error While Decoding Password!!");
			}
			boolean logined = utils.userLogin(row[3], decodePass);

			if (logined) {
				sideBar.clickPersonalDetailsBtn().click();
				soft.assertEquals(firstName, personalDataPage.getFirstName(), "First Name Matches !!");
				soft.assertEquals(lastName, personalDataPage.getLastName(), "Last Name Matches !!");
				soft.assertEquals(acc_num, personalDataPage.getAccountNumber(), "Account Number Matches !!");
				logger.info("User Credintials Matches with Database !");
				test.pass("User Credintials Matches with Database !");
			}
			soft.assertAll();
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
		logger.info("All Done!");
		test.log(Status.INFO, "Browser Closed successfully");

	}
}
