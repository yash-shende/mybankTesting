package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApproveMoneyToUserAccountPage {
	WebDriver driver = null;

	By approveMoneyToUserAcBtn = By.xpath("//body[1]/div[1]/div[1]/form[1]/input[2]");
	// custom css selector for selecting code no. of customer
	By customerCodeNo = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(1)");
	By enterCodeNo = By.xpath("//body[1]/div[1]/div[1]/form[1]/input[1]");
	By approveMnyStatusMessage = By.xpath("//h2");
	By noReqstatus = approveMnyStatusMessage;
	By reqTable = By.cssSelector("table>tbody>tr");

	public ApproveMoneyToUserAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickenterCodeNo() {
		driver.findElement(enterCodeNo).click();
	}

	public void clickaapproveMoneyToUserAcBtn() {
		driver.findElement(approveMoneyToUserAcBtn).click();
	}

	public String getcustomerCodeNo() {
		return driver.findElement(customerCodeNo).getText();
	}

	public String getapproveMnyStatusMessage() {
		return driver.findElement(approveMnyStatusMessage).getText();
	}

	public String getnoReqstatus() {
		return driver.findElement(noReqstatus).getText();
	}
	
	public int findTableElements() {
		return driver.findElements(reqTable).size();
	}
	
}