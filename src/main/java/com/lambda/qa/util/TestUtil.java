package com.lambda.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lambda.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	public static long PAGE_LOAD_TimeOut=20;
	public static long Implict_LOAD_TimeOut=15;
	public static long Explict_LOAD_TimeOut=30;
	public static WebDriverWait wait;
	public static Actions ac;
	
	public void actionsDrag(WebElement source,int xOffset,int yOffset) {
		 ac =new Actions(driver);
		ac.dragAndDropBy(source, xOffset, yOffset);
	}
	
	public void selectDropDownByValue(WebElement element,String str) {
		Select s=new Select(element);
		s.selectByValue(str);
	}
	
	
	
	public void waitForElementClickable(WebElement element) {
		 wait=new WebDriverWait(driver, Explict_LOAD_TimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementVisibility(WebElement element) {
		 wait=new WebDriverWait(driver, Explict_LOAD_TimeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	
	
	
	
	public void actionClick(WebElement target) {
		ac.moveToElement(target).click().build().perform();
	}
	}
