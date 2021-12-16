package mybank.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AdminAtmCardReqPage {
	WebDriver driver = null;

	By atmRequestBtn = By.name("approve");
	By adminAtmReqTable=By.cssSelector("table>tbody>tr");
	By reqIdUserOne=By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(1)");
	By reqCodeInput=By.name("id");
	By reqStatusMsg =By.tagName("h2");
	
	public AdminAtmCardReqPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public int findTableElements()	{
	List<WebElement> row=(List<WebElement>) driver.findElements(adminAtmReqTable);
	return row.size();
	 
	}
	public void clickAtmRequestBtn() {
		driver.findElement(atmRequestBtn).click();
	}
	public String getUserId() {
		return driver.findElement(reqIdUserOne).getText();
	}
	public void putUserId(String id) {
		 driver.findElement(reqCodeInput).sendKeys(id);
	}
	public String getStatusMsg() {
		 return driver.findElement(reqStatusMsg).getText();
	}
}
