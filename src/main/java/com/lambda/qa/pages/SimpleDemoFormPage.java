package com.lambda.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lambda.qa.base.TestBase;

public class SimpleDemoFormPage extends TestBase {
	
	@FindBy(id="user-message")
	WebElement txt_EnterMessage;
	
	@FindBy(id="showInput")
	WebElement btn_GetCheckedValue;
	
	@FindBy(id="message")
	WebElement txt_UpdatedMsg;
	
	public SimpleDemoFormPage() {
		PageFactory.initElements(driver, this);
	}

	public void enterMessagevalue(String str) {
		txt_EnterMessage.sendKeys(str);
	 }
		
	 
	 public void clickOnGetCheckedValue() {
		 btn_GetCheckedValue.click();
	 }
		
	public String  getYourTextMsg() {
		return txt_UpdatedMsg.getText();
	}
	
	public String validateUrl() {
		return driver.getCurrentUrl();
	}

}
