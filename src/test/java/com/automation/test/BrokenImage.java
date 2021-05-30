package com.automation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BrokenImage  extends BaseTest{
	@Test
	public void BrokenImageTest() {
		
		driver.get(configProperties.getProperty("BaseUrl")+"/broken_images");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		List<WebElement> elementList= driver.findElements(By.tagName("img"));
		for(int i=0;i<elementList.size();i++) {
			Response response= RestAssured.given().contentType("application/json")
	                .get(elementList.get(i).getAttribute("src"));
			System.out.println("printt the response code"+response.getStatusCode());
			if(elementList.get(i).getAttribute("naturalWidth").equals("0")) {
				System.out.println("the image is broken");
			}else {
				System.out.println("the image is  not broken");
			}
		}
		
	}

}
