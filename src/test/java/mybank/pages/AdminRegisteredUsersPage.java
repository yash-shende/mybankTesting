package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class AdminRegisteredUsersPage {
	
	WebDriver driver = null;

	//custom css selector for selecting code no. of customer
	By customerCodeNo = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(1)");
	
	//custom css selector for selecting  for selecting customer block/unblock status
	By customeStatus = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(9)");
	
	By changeUserStatus = By.xpath("//a[@id='change-status']");
	
	
	By enterCodeForBlock = By.xpath("//td[1]//div[1]//div[1]//form[1]//input[1]");
	By block = By.xpath("//input[@name='block']");
	
	By enterCodeForunblock = By.xpath("//td[2]//div[1]//div[1]//form[1]//input[1]");
	By unblock = By.xpath("//input[@name='unblock']");

	public AdminRegisteredUsersPage(WebDriver driver) {
		this.driver = driver;
	}

	
	public void clickchangeUserStatus() {
		driver.findElement(changeUserStatus).click();
	}
	
	
	
	
	
	//for clicking text field to give input for block
	public void clicktextFieldForBlock() {
		driver.findElement(enterCodeForBlock).click();
	}
		
	//entering customer code to block
	public void clickenterCodeForBlock(String code) {
		driver.findElement(customerCodeNo).sendKeys(code);
	}
	
	//clicking block button
	public void clickblock() {
		driver.findElement(block).click();
	}
	
	
	
	
		
	
	
	//clicking text field to give input for unblock
	public void clicktextFieldForunblock() {
		driver.findElement(enterCodeForunblock).click();
	}
	//entering customer code to unblock
	public void clickenterCodeForunblock(String code) {
		driver.findElement(customerCodeNo).sendKeys(code);
	}
		
	//clicking unblock button
	public void clickunblock() {
		driver.findElement(unblock).click();
	}
		
		
		
	public String getcustomeStatus() {
		return driver.findElement(customeStatus).getText();
	}
		
	public String getcustomerCodeNo() {
		return driver.findElement(customerCodeNo).getText();
	}
		
		
		

}
