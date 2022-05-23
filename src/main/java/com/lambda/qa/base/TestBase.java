package com.lambda.qa.base;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lambda.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	public static JavascriptExecutor executor;
	public static Robot robo;
	public static Actions ac;
	
	public TestBase() {
		try {
			prop = new Properties();
		System.out.println("Inside base constructor");
		
	      FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\lambda\\qa\\config\\config.properties");
		
		
		prop.load(fis);
		
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} 
		
	}
	
	public static void intialization() {
	String browserName=	prop.getProperty("browser");
	System.out.println(browserName);
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\com\\lambda\\qa\\drivers\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TimeOut, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implict_LOAD_TimeOut, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}
		
	}

	public void waitForElementPresent(WebElement ele) {
		wait	=new WebDriverWait(driver, TestUtil.Explict_LOAD_TimeOut);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
		
	}
	
	
	public void javaScriptExecutorClick(WebElement element)
	{
         executor= (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	
	}
	public void switchToFrameHasElement(WebElement element) {
		driver.switchTo().frame(element);
	}
 
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scollDown() throws InterruptedException {
		try {
			 robo=new Robot();
			robo.keyPress(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
			robo.keyRelease(KeyEvent.VK_PAGE_DOWN);
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TimeOut, TimeUnit.SECONDS);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static WebElement switchingToFramesUsingElement(WebElement element) {
		try {
		driver.switchTo().defaultContent();
		element.isDisplayed();
		}catch(Exception continueFlow) {
			WebDriverWait wait=new  WebDriverWait(driver, 30);
			List<WebElement> iframes=driver.findElements(By.tagName("iframe"));
			int noOfFrames=iframes.size();
			System.out.println("Total number of Frames"+noOfFrames);
			for(WebElement frame:iframes) {
				driver.switchTo().defaultContent();
				try {
					wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
					if(element.isDisplayed()) {
						
						break;
					}
				}catch(NoSuchElementException | StaleElementReferenceException|ElementNotInteractableException ignored) {
					
				}
			}
		}
		return element;
		
		
		
	}

}
