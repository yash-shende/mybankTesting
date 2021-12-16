package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageNavBar {

	WebDriver driver = null;
	
	//homw page top navbar
	By mybankLogo = By.xpath("//a[contains(text(),'Home')]");
	By home = By.xpath("//a[@class='right carousel-control']");
	By features = By.xpath("//a[contains(text(),'Features')]");
	By aboutFAQs = By.xpath("//a[contains(text(),'About-FAQs')]");
	By contactUs = By.xpath("//a[contains(text(),'Contact Us')]");
	By safetyBankingTips = By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Safety Banking Tips')]");
	By adminLogin = By.xpath("//a[@class='fa fa-sign-in']");
	By login = By.xpath("//div[@id='myNavbar']//li[2]//a[1]");
	By signUp = By.xpath("//a[@class='fa fa-registered']");
	
	
	// Initialize The Web Driver
	public HomePageNavBar(WebDriver driver) {		
		this.driver = driver;
	}
	
	public void clickmybankLogo() {
		driver.findElement(mybankLogo).click();
	}
	public void clickhome() {
		driver.findElement(home).click();
	}
	public void clickFeaturesBtn() {
		driver.findElement(features).click();
	}
	public void clickAboutFAQsBtn() {
		driver.findElement(aboutFAQs).click();
	}
	public void clickContactUsBtn() {
		driver.findElement(contactUs).click();
	}
	public void clickSafetyBankingTipsBtn() {
		driver.findElement(safetyBankingTips).click();
	}
	public void clickAdminLoginBtn() {
		driver.findElement(adminLogin).click();
	}
	public void clickLoginBtn() {
		driver.findElement(login).click();
	}
	public void clickSignUpBtn() {
		driver.findElement(signUp).click();
	}
}
