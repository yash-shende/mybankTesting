package mybank.testcases;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import java.io.IOException;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;
import mybank.utility.XLUtility;


public class DDUserLoginPageTest extends BaseTest{

	
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getName());
	boolean logined;
	//SoftAssert soft = new SoftAssert();
	
	// Driver setup
	@BeforeTest
	public void setUp() {
		//driver=utils.browserSetup();

		test = extent.createTest("Data driven for user login ", "Testing user login feature");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
		
	}
	
	
	//data driven test user login test correct inputs
	@Test(priority=1, dataProvider="LoginData")
	public void userLoginTestWithcorrectData(String user,String pwd)
	{
		// user login through Utilities class
		
		utils.userLogin(user, pwd);
		
//		test.pass("User login using DD successful!");
	
	
	}
	
	@Test(priority=2,dataProvider="LoginWithWrongData")
	public void userLoginTestWithcWrongData(String user,String pwd)
	{
		// user login through Utilities class
		logined = utils.userLogin(user, pwd);
		//System.out.println(user+ ""+pwd);
		//test.pass("User login using DD with wrong data successful!");
		if(logined) {
			System.out.println("Admin Login Successful !!");
			
		}
		else {
			System.out.println("Admin Login Failed! !!");
			Assert.assertTrue(logined);
		}
		
	}

	@Test(priority=3,dataProvider="LoginWithWrongEmail")
	public void userLoginTestWithcWrongEmail(String user,String pwd)
	{
		// user login through Utilities class
		logined=utils.userLogin(user, pwd);
		//test.pass("User login using DD with wrong data successful!");
		if(logined) {
			System.out.println("Admin Login Successful !!");
			
		}
		else {
			System.out.println("Admin Login Failed! !!");
			Assert.assertTrue(logined);
		}
		
	}
	
	@Test(priority=4,dataProvider="LoginWithWrongPass")
	public void userLoginTestWithcWrongPass(String user,String pwd)
	{
		// user login through Utilities class
		logined = utils.userLogin(user, pwd);
		//test.pass("User login using DD with wrong data successful!");
		if(logined) {
			System.out.println("Admin Login Successful !!");
			
		}
		else {
			System.out.println("Admin Login Failed! !!");
			Assert.assertTrue(logined);
		}
		
	}
	@Test(priority=5,dataProvider="LoginWithWrongSensitive")
	public void userLoginTestSensitive(String user,String pwd)
	{
		// user login through Utilities class
		logined =utils.userLogin(user, pwd);
		//test.pass("User login using DD with wrong data successful!");
		if(logined) {
			System.out.println("Admin Login Successful !!");
			
		}
		else {
			System.out.println("Admin Login Failed! !!");
			Assert.assertTrue(logined);
		}
		
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		
		//get the data from excel
		String path=".\\Files\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("correctdata");
		int totalcols=xlutil.getCellCount("correctdata",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("correctdata", i, j);
			}
				
		}
		
		return loginData;
	}
	
	@DataProvider(name="LoginWithWrongData")
	public String [][] getData1() throws IOException
	{
		
		//get the data from excel
		String path=".\\Files\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("wrongdata");
		int totalcols=xlutil.getCellCount("wrongdata",1);	
		
		
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("wrongdata", i, j);
			}
				
		}
		
		return loginData;
	}
	@DataProvider(name="LoginWithWrongEmail")
	public String [][] getData2() throws IOException
	{
		
		//get the data from excel
		String path=".\\Files\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("wrongemail");
		int totalcols=xlutil.getCellCount("wrongemail",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("wrongemail", i, j);
			}
				
		}
		
		return loginData;
	}
	
	@DataProvider(name="LoginWithWrongPass")
	public String [][] getData3() throws IOException
	{
		
		//get the data from excel
		String path=".\\Files\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("wrongpass");
		int totalcols=xlutil.getCellCount("wrongpass",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("wrongpass", i, j);
			}
				
		}
		
		return loginData;
	}
	
	@DataProvider(name="LoginWithWrongSensitive")
	public String [][] getData4() throws IOException
	{
		
		//get the data from excel
		String path=".\\Files\\UserData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("caseSensitive");
		int totalcols=xlutil.getCellCount("caseSensitive",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("caseSensitive", i, j);
			}
				
		}
		
		return loginData;
	}
	@AfterMethod
	public void temp(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String ssPath = utils.getScreenshot();
			test.fail("Failed !!",MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
	}
	@AfterTest
	public void close() {
		driver.close();
		driver.quit();
	}
	
	
	
	
}

