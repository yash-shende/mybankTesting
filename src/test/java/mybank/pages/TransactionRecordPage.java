package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionRecordPage
{
		WebDriver driver;
		By AccNumber = By.cssSelector("body>div>div:nth-child(1)>input");
		By AccHolderName = By.cssSelector("body:nth-child(2) div:nth-child(3) div.col-xs-3:nth-child(2) > input.form-control:nth-child(2)");
		
		public TransactionRecordPage(WebDriver driver) 
		{
			this.driver = driver;
		}
		
		public String getAccountNumber() 
		{
			return driver.findElement(AccNumber).getAttribute("value");
		}
		
		public String getAccHolderName() 
		{
			return driver.findElement(AccHolderName).getAttribute("value");
		}
		
	


}