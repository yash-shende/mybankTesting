package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLoginPage {
	WebDriver driver = null;
	
	By AdminUserName = By.name("email");
	By AdminPassword = By.name("pwd");
	By AdminLoginBtn = By.name("submit");
	

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterAdminUserName(String username) {
		driver.findElement(AdminUserName).sendKeys(username);
	}

	public void enterAdminPassword(String pass) {
		driver.findElement(AdminPassword).sendKeys(pass);
	}
	
	public void clickAdminLoginBtn() {
		driver.findElement(AdminLoginBtn).click();
	}
	
	public String getPageTitle() {			
		return driver.getTitle();
	}
	

}
