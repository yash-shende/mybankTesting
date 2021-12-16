package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.*;

public class WithdrawMoneyPage {
	WebDriver driver = null;
	

	By enterAmount = By.xpath("//input[@placeholder='Enter Amount']");
	By withdrawMoney = By.xpath("//input[@name='withmoney']");
	By statusMesg = RelativeLocator.with(By.tagName("P")).below(withdrawMoney);
	

	public WithdrawMoneyPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickenterAmount() {
		driver.findElement(enterAmount).click();
	}
	
	public void clickenterAmount(String amount) {
		driver.findElement(enterAmount).sendKeys(amount);
	}
		
	public void clickwithdrawMoneyBtn() {
		driver.findElement(withdrawMoney).click();
	}

	
	//selenium 4 relative locator
	public String getStatusMesg() {
		return driver.findElement(statusMesg).getText();
	}
}

