package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SideNavBar {
	
	WebDriver driver = null;
	
	By homeBtn = By.linkText("Home");
	By personalDetailsBtn  = By.cssSelector("#sidenav>li:nth-child(2)");
	By reqAtmBtn = By.linkText("Request ATM Card");
	By addBeneficiary = By.xpath("//a[contains(text(),'Add Beneficiary')]");
	By accSummaryBtn = By.linkText("Account Summary");
	By atmCardReq=By.linkText("ATM Card Requests");
	By transactionBtn = By.xpath("//a[contains(text(),'Transaction Record')]");
	// Initialize The Web Driver
	public SideNavBar(WebDriver driver) {		
		this.driver = driver;
	}
	
	public void clickRequestAtmBtn() {
		driver.findElement(reqAtmBtn).click();
	}
	
	public WebElement clickPersonalDetailsBtn() {
		return driver.findElement(personalDetailsBtn);
	}
	
	public void clickAddBeneficiary() {
		driver.findElement(addBeneficiary).click();
	}
	
	public void clickaccSummaryBtn() {
		driver.findElement(accSummaryBtn).click();
	}
	
	public void clickAdminAtmCardReq() {
		driver.findElement(atmCardReq).click();
	}
	
	public void clickTransactionBtn() {
		driver.findElement(transactionBtn).click();
	}
	
	
}
