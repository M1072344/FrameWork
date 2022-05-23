package com.lambda.qa.pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.lambda.qa.base.TestBase;

public class DragAndDropPage extends TestBase {
	
	@FindBy(xpath="//h4[contains(text(),' Default value 15')]/following::div[1]")
	WebElement btn_Slider;
	
	@FindBy(xpath="//h4[contains(text(),' Default value 15')]/following::output[1]")
	WebElement txt_OutputValue;
	
	
	
	public DragAndDropPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	

	public String  dragAndGetValue()  {
		
		Actions ac= new Actions(driver);
		ac.dragAndDropBy(btn_Slider, 100, 0).build().perform();
		return txt_OutputValue.getText();
		 
		
	
	 }
		


}
