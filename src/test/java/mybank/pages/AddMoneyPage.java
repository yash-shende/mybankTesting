package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;


public class AddMoneyPage {
	WebDriver driver = null;
	

	By enterAmount = By.className("form-control");
	By addMoney = By.xpath("//input[@name='addmoney']");
	
	public By statusMesg = RelativeLocator.with(By.tagName("P")).below(addMoney);
	

	public AddMoneyPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickenterAmount() {
		driver.findElement(enterAmount).click();
	}
	
	public void clickenterAmount(String amount) {
		driver.findElement(enterAmount).sendKeys(amount);
	}
		
	public void clickaddMoneyBtn() {
		driver.findElement(addMoney).click();
	}

	
	//selenium 4 relative locator
	public String getStatusMesg() {
		return driver.findElement(statusMesg).getText();
	}
}
