package mybank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddBeneficiaryPage {

	WebDriver driver;

	public AddBeneficiaryPage(WebDriver driver) {
		this.driver = driver;
	}

	By acc_number = By.id("acNo");
	By accHolderName = By.name("benname");
	By bankName = By.name("benbankname");
	By bankBranchName = By.name("benbankbranchname");
	By ifscCode = By.name("ifsc");
	public By addBeneficiaryBtn = By.name("addben");
	By statusMsg = By.className("mess"); 

	public void enterAccNumber(String acc_num) {
		driver.findElement(acc_number).sendKeys(acc_num);
		
	}

	public void enterBankName(String BankName) {
		driver.findElement(bankName).sendKeys(BankName);
	}

	public void enterAccHolderName(String holderName) {
		driver.findElement(accHolderName).sendKeys(holderName);
	}

	public void enterBranchName(String branchName) {
		driver.findElement(bankBranchName).sendKeys(branchName);
	}

	public void enterIfsc(String ifsc) {
		driver.findElement(ifscCode).sendKeys(ifsc);
	}

	public void clickAddBeneficiaryBtn() {
		driver.findElement(addBeneficiaryBtn).click();
	}

	public String getStatusMsg() {
		return driver.findElement(statusMsg).getText();
	}

	public boolean getSubmitBtnStatus(){
		return driver.findElement(addBeneficiaryBtn).isEnabled();
	}
	
	
}
