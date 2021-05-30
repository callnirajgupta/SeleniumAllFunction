package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.testng.Assert;

public class JavaScriptErrorPage {

	
	public static void captureJavaScript(WebDriver driver) throws InterruptedException {
		
		LogEntries jsErrors = driver.manage().logs().get(LogType.BROWSER);
		System.out.println("Print all Log"+jsErrors.getAll());
	     System.out.println("Print index0 Log"+jsErrors.getAll().get(0));
	     System.out.println("Print index1 Log"+jsErrors.getAll().get(1));
	     
		Assert.assertTrue(jsErrors.getAll().get(0).toString().contains("Cannot read property 'xyz' of undefined"));
		                                              
	}
	
}
