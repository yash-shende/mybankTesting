package mybank.testcases;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import bsh.This;
import mybank.pages.AdminSideNavBar;
import mybank.pages.ApproveMoneyToUserAccountPage;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class ApproveMoneyToUserAccountPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	
	Logger logger = Utilities.log4jSetup(this.getClass().getSimpleName());

	@BeforeTest
	public void beforeTest() {

		test = extent.createTest("Approve Money To User Account Page Test", "Testing Approve Money To User Account Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
	}
			
    @Test()
	public void approveMoneyToUserAccountPageAvabilityTest() {
		
		AdminSideNavBar adminsideBar = new AdminSideNavBar(driver);
		ApproveMoneyToUserAccountPage approveMoneyToUserAccountPage = new ApproveMoneyToUserAccountPage(driver);
         
		boolean logined = utils.AdminLogin("admin@gmail.com", "admin123");
		
		if(logined) {
		
		adminsideBar.approveMoneyBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/adminAddMoney.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Approve Money to User account page Avialable !");
			logger.info("Approve Money to User account page Avialable !!");
		}

		catch (AssertionError e) {
			System.out.println("Approve Money to User account page is not Avialable ");
			test.fail("Approve Money to User account page is not Avialable ... ");
			logger.error("Error occured with assert statement !");
		}
		
		
		String str1 = "";
        try {

		str1 = approveMoneyToUserAccountPage.getnoReqstatus();

		}
		catch(Exception e)
		{

		System.out.println("exception is : "+ e);
		}
        
        if (str1.equals("No requests yet!!")) {

        	test.pass("No approve money req yet ");
        	logger.info("No approve money req yet ");

        	}


        	else
        	{
		// text area 
	            String customerCode = 	approveMoneyToUserAccountPage.getcustomerCodeNo();
				approveMoneyToUserAccountPage.clickenterCodeNo();
				
				WebElement amount = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/form[1]/input[1]"));
				
				//input[@placeholder='Enter Amount']
				amount.sendKeys(customerCode);
				
		     	// click the approve button
				approveMoneyToUserAccountPage.clickaapproveMoneyToUserAcBtn();
				test.pass("Approve Money to User account!");
				logger.info("Approve Money to User account!");
				driver.switchTo().alert().accept();
				System.out.println("alert");
				
                if (approveMoneyToUserAccountPage.getapproveMnyStatusMessage() == "")
					System.out.println("You Clicked on cancle");
				else {
					logger.info("Alert Message is Clicked OK !");
					test.pass("Approve Money to User account is Successfull !");
					logger.info("Approve Money to User account is Successfull!!");			
				}
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
	public void ShutDown() {
		driver.close();
		driver.quit();
		logger.info("All Done!");
	}
}
