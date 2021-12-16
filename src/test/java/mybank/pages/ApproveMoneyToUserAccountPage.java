package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ApproveMoneyToUserAccountPage {
	WebDriver driver = null;

	By approveMoneyToUserAcBtn= By.xpath("//body[1]/div[1]/div[1]/form[1]/input[2]");
    //custom css selector for selecting code no. of customer
    By customerCodeNo = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(1)");
	By enterCodeNo = By.xpath("//body[1]/div[1]/div[1]/form[1]/input[1]");
	By approveMnyStatusMessage = By.cssSelector("body:nth-child(2) div:nth-child(3) > h2:nth-child(3)");
	By noReqstatus = By.cssSelector("body:nth-child(2) div:nth-child(3) > h2:nth-child(3)");
	
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
	}