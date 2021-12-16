package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequestAtmPage {
	WebDriver driver = null;

	By atmRequestBtn = By.name("atm");
	public By atmStatusMessage = By.xpath("/html[1]/body[1]/div[1]/h4[3]");

	public RequestAtmPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickReqAtmBtn() {
		driver.findElement(atmRequestBtn).click();
	}

	public String getStatusMesg() {
		return driver.findElement(atmStatusMessage).getText();
	}
}
