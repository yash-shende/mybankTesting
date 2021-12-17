package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

public class SignUpPage {
	
	WebDriver driver = null;
	
	
	public By FirstName = By.name("firstname");
	public By LastName = RelativeLocator.with(By.tagName("input")).below(FirstName);
	public By BankAcc = By.name("acNo");
	public By Email =  RelativeLocator.with(By.tagName("input")).above(BankAcc);
	public By Password = By.name("pwd");
	public By RePass = By.name("repwd"); 
	By DateOB = By.name("DOB");
	By Gender = RelativeLocator.with(By.tagName("select")).above(DateOB);
	public By Country = RelativeLocator.with(By.tagName("input")).below(DateOB);
	public By Submit = By.name("submit");
	By loginBtn = By.partialLinkText("Login");
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void enterFirstName(String firstname) {
		driver.findElement(FirstName).sendKeys(firstname);
	}

	public void enterLastName(String lastname) {
		driver.findElement(LastName).sendKeys(lastname);
	}
	

	public void enterEmail(String email) {
		driver.findElement(Email).sendKeys(email);
	}
	
	public void enterBankAcc(String bankAcc) {
		driver.findElement(BankAcc).sendKeys(bankAcc);
	}
	
	public void enterPassword(String password) {
		driver.findElement(Password).sendKeys(password);
	}
	
	
	public void enterRePass(String rePass) {
		driver.findElement(RePass).sendKeys(rePass);
	}
	
	public Select enterGender() {
		Select drpGender = new Select(driver.findElement(Gender));
		return drpGender;
	}
	
	public void enterCountry(String country) {
		driver.findElement(Country).sendKeys(country);
	}
	public void enterDOB(String dob) {
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String script = "document.forms[\"RegisterForm\"][\"DOB\"].value = " +dob+";";   //'1998-10-07'"
		js.executeScript(script);
	}

	public void clickSignUpBtn() {
		driver.findElement(Submit).click();
	}

	public String getSignPageTitle() {
		return driver.getTitle();
	}
	
	public void clickLoginBtn() {
		driver.findElement(loginBtn).click();
	}
	
	public boolean submitDisabled() {
		return driver.findElement(Submit).isEnabled();
	}
}
