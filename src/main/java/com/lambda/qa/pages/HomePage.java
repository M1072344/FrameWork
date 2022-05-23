package com.lambda.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.lambda.qa.base.TestBase;
import com.lambda.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	

	@FindBy(xpath="//a[contains(text(),'Simple Form Demo')]")
	WebElement link_SimpleDemoLink;
	
	@FindBy(xpath="//a[contains(text(),'Drag & Drop Sliders')]")
	WebElement link_DragAndDropoLink;
	
	@FindBy(xpath="//a[contains(text(),'Input Form Submit')]")
	WebElement link_InputFormSubmitLink;
	
	@FindBy(xpath="//h1[contains(text(),'Dropdown Demo')]")
	WebElement header_DropDownDemo;
	
	TestUtil tu=new TestUtil();
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
public boolean clickOnSimpleDemoLink() {
		
		link_SimpleDemoLink.click();
		
		return true;
		
	}

public boolean clickOnDragAndDropLink() {
	
	link_DragAndDropoLink.click();
	return true;
	
}

public boolean clickOnInputFormSubmitLink() {
	waitForElementPresent(link_InputFormSubmitLink);
	link_InputFormSubmitLink.click();
		return true;
	
}
}
