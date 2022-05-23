package com.lambda.qa.testcases;


import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lambda.qa.base.TestBase;
import com.lambda.qa.pages.DragAndDropPage;
import com.lambda.qa.pages.HomePage;
import com.lambda.qa.pages.InputFormSubmitPage;
import com.lambda.qa.pages.SimpleDemoFormPage;
import com.lambda.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase {
	HomePage homepage;
	SimpleDemoFormPage simpleDemoPage;
	DragAndDropPage drag;
	InputFormSubmitPage inputForm;
	TestUtil testutil;
	
	private RemoteWebDriver driver;
    private String Status = "failed";
	
	String stringToEnter="Welcome to LambdaTest";
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setup(Method m,ITestContext ctx) throws MalformedURLException {
		intialization();String username = System.getenv("LT_USERNAME") == null ? "naveen.mudirajg" : System.getenv("LT_USERNAME");
        String authkey = System.getenv("LT_ACCESS_KEY") == null ? "JO78Ryg4WNJDCcO47Xgt9KwhkIyHPX0kCAraPUGjcoAXRI3HRq" : System.getenv("LT_ACCESS_KEY");
        String hub = "@hub.lambdatest.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        // Configure your capabilities here
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("browserName", "Chrome");
        caps.setCapability("version", "92.0");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("build", "TestNG With Java");
        caps.setCapability("name", m.getName() + this.getClass().getName());
        caps.setCapability("plugin", "git-testng");

        String[] Tags = new String[] { "Feature", "Magicleap", "Severe" };
        caps.setCapability("tags", Tags);

        driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
		homepage =new HomePage();
		simpleDemoPage=new SimpleDemoFormPage();
		drag=new DragAndDropPage();
		inputForm=new InputFormSubmitPage();
		testutil =new TestUtil();
	}
	
	@Test
	public  void validateEnteredValue() throws InterruptedException {
		homepage.clickOnSimpleDemoLink();
		String actualTitle=simpleDemoPage.validateUrl();
		System.out.println(actualTitle);
		Assert.assertTrue(simpleDemoPage.validateUrl().contains("simple-form-demo"));
		simpleDemoPage.enterMessagevalue(stringToEnter);
		simpleDemoPage.clickOnGetCheckedValue();
		String actualtext=simpleDemoPage.getYourTextMsg();
		Assert.assertEquals(stringToEnter, actualtext);
		Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");
		
	}
	
	@Test
	public void dragSlider() throws InterruptedException {
		homepage.clickOnDragAndDropLink();
		String str=drag.dragAndGetValue();
		int actualvalue=Integer.parseInt(str);
		Assert.assertEquals(95, actualvalue);
		Status = "passed";
        Thread.sleep(150);

        System.out.println("TestFinished");
		
		
		
	}
	
	@Test
	public void fillTheform() throws InterruptedException {
		homepage.clickOnInputFormSubmitLink();
		inputForm.clickOnSubmit();
		String validationMessage=inputForm.readValidationMsg();
		Assert.assertEquals("Please fill out this field.", validationMessage);
	   inputForm.fillForm();
	   inputForm.clickOnSubmit();
	   String thankyouMessage=inputForm.validateThankyouMsg();
	   Assert.assertEquals("Thanks for contacting us, we will get back to you shortly.", thankyouMessage);
	   Status = "passed";
       Thread.sleep(150);

       System.out.println("TestFinished");
	}
	
	@AfterMethod
	public void teardown() {
		driver.executeScript("lambda-status=" + Status);
		driver.quit();
	}
	
}
