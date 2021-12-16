package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class UserLoginPage {

	WebDriver driver = null; 

	By userName = By.name("email");
	By password = RelativeLocator.with(By.tagName("input")).below(userName); 
	By loginBtn = By.name("submit");
	

	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String username) {
		driver.findElement(userName).sendKeys(username);
	}
	
	//Using Selenium 4 - Relative Locator 
	public void enterPassword(String pass) {
		driver.findElement(password).sendKeys(pass);
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public String getPageTitle() {			
		return driver.getTitle();
	}
	
	

}
