package mybank.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApproveWithdrawalOfMoneyPage {
	WebDriver driver = null;

	By approveWithdrawalMoneyBtn = By.xpath("//body[1]/div[1]/div[1]/form[1]/input[2]");
	By customerCodeNo = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(1)");
	By enterCodeNo = By.xpath("//body[1]/div[1]/div[1]/form[1]/input[1]");
	By noReqstatus = By.cssSelector("body:nth-child(2) div:nth-child(3) > h2:nth-child(3)");
	By withdrawMoneyReqTable = By.cssSelector("table>tbody>tr");

	public ApproveWithdrawalOfMoneyPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickenterCodeNo() {
		driver.findElement(enterCodeNo).click();
	}

	public void clickapproveWithdrawalMoneyBtn() {
		driver.findElement(approveWithdrawalMoneyBtn).click();
	}

	public String getcustomerCodeNo() {
		return driver.findElement(customerCodeNo).getText();
	}

	public String getnoReqstatus() {
		return driver.findElement(noReqstatus).getText();
	}
	
	public void putUserId(String id) {
		 driver.findElement(enterCodeNo).sendKeys(id);
	}

	public int findTableElements() {
		List<WebElement> row = (List<WebElement>) driver.findElements(withdrawMoneyReqTable);
		return row.size();

	}

}
