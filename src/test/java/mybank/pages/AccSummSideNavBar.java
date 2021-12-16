package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccSummSideNavBar {
	WebDriver driver = null;
	
	By addMoneyToAccBtn = By.linkText("Add Money to your account");
	By withdrawMoneyBtn  = By.linkText("Withdraw Money from account");
	By addMoneyBtn = By.xpath("//input[@name='addmoney']");
	
	
	// Initialize The Web Driver
	public AccSummSideNavBar(WebDriver driver) {		
		this.driver = driver;
	}
	
	
	public void clickaddMoneyToAccBtn() {
		driver.findElement(addMoneyToAccBtn).click();
	}
	
	public void clickwithdrawMoneyBtn() {
		driver.findElement(withdrawMoneyBtn).click();
	}
	
	public void clickaddMoneyBtn() {
		driver.findElement(addMoneyBtn).click();
	}
		
		
		
}
