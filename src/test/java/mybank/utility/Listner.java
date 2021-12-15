package mybank.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listner implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test Started In Listner !!!");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Successfully completed In Listner !!!");
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Test Finished In Listner !!!");
	}
	

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failed In Listner !!!");
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	
	
}
