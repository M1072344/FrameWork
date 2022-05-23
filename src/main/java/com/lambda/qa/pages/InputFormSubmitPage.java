package com.lambda.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.lambda.qa.base.TestBase;
import com.lambda.qa.util.TestUtil;

public class InputFormSubmitPage extends TestBase {
	
	public InputFormSubmitPage() {
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//label[@for='inputZip']/following::button")
	WebElement btn_Submit;
	
	@FindBy(id="zsiq_float")
	WebElement btn_Chat;
	
	@FindBy(id="name")
	WebElement txt_Name;
	
	@FindBy(name="email")
	WebElement txt_Email;
	
	@FindBy(name="password")
	WebElement txt_Password;
	
	@FindBy(id="company")
	WebElement txt_Company;
	
	@FindBy(id="websitename")
	WebElement txt_WebSite;
	
	@FindBy(name="country")
	WebElement select_Country;
	
	@FindBy(id="inputCity")
	WebElement txt_City;
	
	@FindBy(id="inputAddress1")
	WebElement txt_Address;
	
	@FindBy(id="inputAddress2")
	WebElement txt_Address2;
	
	@FindBy(id="inputState")
	WebElement txt_State;
	
	@FindBy(id="inputZip")
	WebElement txt_ZipCode;
	
	@FindBy(xpath="//p[@class='success-msg hidden']")
	WebElement txt_ThankYouMsg;
	
	TestUtil tu=new TestUtil();
	
	
	public void clickOnSubmit() throws InterruptedException {
	waitForElementPresent(btn_Submit);
	btn_Submit.click();
		
	}
	

	
	public String  readValidationMsg() throws InterruptedException {
	Thread.sleep(4000);
		String message=driver.findElement(By.name("name")).getAttribute("validationMessage");
	System.out.println("message"+message);
		return  message;
	}
	
public void fillForm() {
	txt_Name.sendKeys("Max");
	txt_Email.sendKeys("123nn@gmail.com");
	txt_Password.sendKeys("1234");
	txt_Company.sendKeys("xyx");
	txt_WebSite.sendKeys("xyz.com");
	tu.selectDropDownByValue(select_Country, "US");
	txt_City.sendKeys("NN");
	txt_State.sendKeys("nigeria");
	txt_Address.sendKeys("1234");
	txt_Address2.sendKeys("456");
	txt_ZipCode.sendKeys("5555");
	
	
}

public String validateThankyouMsg() {
	waitForElementPresent(txt_ThankYouMsg);
	String message=txt_ThankYouMsg.getText();
	return message;
	
}
}
