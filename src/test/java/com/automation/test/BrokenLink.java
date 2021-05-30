package com.automation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenLink  extends BaseTest{
	
	@Test
	public void brokenlink() {
		
		driver.get("http://www.zlti.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> webelementList=driver.findElements(By.tagName("a"));
		for (int i=0;i<webelementList.size();i++) {
			try {
			Response response= RestAssured.given().contentType("application/json")
	                .get(webelementList.get(i).getAttribute("href"));
			System.out.println("printt the response code"+response.getStatusCode());
			if(response.getStatusCode()!=200) {
				System.out.println("the status is not 200 print the url"+webelementList.get(i).getAttribute("href"));
			}
			}catch(Exception e) {
				
				e.getStackTrace();
			}
			
		}
		
		Verify.verify(false, reportName, 0);
	}

	
}
