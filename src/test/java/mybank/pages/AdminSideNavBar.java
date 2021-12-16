package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminSideNavBar {
	WebDriver driver = null;
	
	By homeBtn = By.linkText("Home");
	By RegisteredUserBtn  = By.linkText("Registered Users");
	By approveMoneyBtn = By.linkText("Approve Money to User Account");
	By approveWithdrawalBtn = By.linkText("Approve Withdrawal of Money");
	By approveTransferFunBtn  = By.linkText("Approve Transfer of Funds");
	By atmCardReqBtn = By.linkText("ATM Card Requests");
	
	// Initialize The Web Driver
	public AdminSideNavBar(WebDriver driver) {		
		this.driver = driver;
	}
	
	
	public void homeBtn() {
		driver.findElement(homeBtn ).click();
	}
	
	public void RegisteredUserBtn() {
		driver.findElement(RegisteredUserBtn).click();
	}
	
	public void approveMoneyBtn() {
		driver.findElement(approveMoneyBtn).click();
	}
	
	public void approveWithdrawalBtn() {
		driver.findElement(approveWithdrawalBtn).click();
	}
	
	public void approveTransferFunBtn() {
		driver.findElement(approveTransferFunBtn).click();
	}

	public void clickRegisteredUserBtn() {
		driver.findElement(atmCardReqBtn).click();
	}
}


