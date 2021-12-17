package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver = null;
	
	
	By mybankLogo = By.xpath("//a[contains(text(),'Home')]");
	By features = By.xpath("//a[contains(text(),'Features')]");
	By aboutFAQs = By.xpath("//a[contains(text(),'About-FAQs')]");
	By contactUs = By.xpath("//a[contains(text(),'Contact Us')]");
	By safetyBankingTips = By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'Safety Banking Tips')]");
	By adminLogin = By.xpath("//a[@class='fa fa-sign-in']");
	By login = By.xpath("//div[@id='myNavbar']//li[2]//a[1]");
	By signUp = By.xpath("//a[@class='fa fa-registered']");
	
	public By BranchTitle = By.xpath("//h3[contains(text(),'Kolkata Branch')]");
	public By bottomContactUsBtn = By.cssSelector("button#bottom-ContactUs-btn");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickbottomContactUsBtn() {
		driver.findElement(bottomContactUsBtn).click();
	}
	
	public String  getBranchTitle() {
		String title = driver.findElement(BranchTitle).getText();
		return title;
	}
}
