package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class PersonalDetailsPage {
	
	WebDriver driver;
	By firstName = By.cssSelector("table>tbody>tr:nth-child(1)>td:nth-child(2)");
	By lastName = By.cssSelector("table>tbody>tr:nth-child(2)>td:nth-child(2)");
	By acc_num =  By.cssSelector("table>tbody>tr:nth-child(3)>td:nth-child(2)");
	//table>tbody>tr:nth-child(1)>td:nth-child(2)
	
	public PersonalDetailsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getFirstName() {
		return driver.findElement(firstName).getText();
	}
	public String getLastName() {
		return driver.findElement(lastName).getText();
	}
	public String getAccountNumber() {
		return driver.findElement(acc_num).getText();
	}
	

	
}
