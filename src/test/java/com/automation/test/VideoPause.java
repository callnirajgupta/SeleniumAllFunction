package com.automation.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class VideoPause extends BaseTest {
	
	@Test
	public void videoTest() throws InterruptedException {
		
		driver.get("https://www.thespruceeats.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-display jw-button-color jw-reset']")).click();
		Thread.sleep(1000);
	    WebElement element=	driver.findElement(By.xpath("//div[@class='jw-icon jw-icon-tooltip jw-icon-volume jw-button-color jw-reset jw-full']"));
		
		Actions action =new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//video[@class='jw-video jw-reset']"))).build().perform();
		
		Thread.sleep(1000);
		element.click();
		Thread.sleep(5000);
		driver.close();
	}
}
