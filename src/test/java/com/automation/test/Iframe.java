package com.automation.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.FloatingMenuPage;
import com.automation.pageobject.IframePage;

public class Iframe extends BaseTest{
	
	@Test
	public void IframeTest() throws InterruptedException  {
	
		driver.get(configProperties.getProperty("BaseUrl")+"/iframe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		IframePage.validateIframeHeader(driver);
		IframePage.swicthFrameAndType(driver);
		
		
		
	}
}
