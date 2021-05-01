package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class IframePage {
	public static final By IFRAMEHEADER=By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']");
	public static final By TEXTAREA = By.xpath("//body[@id='tinymce']/p");
	public static final String IFRAME_ID="mce_0_ifr";
	public static final By CLOSE_BTN=By.xpath("//div[@aria-label=\"Close\"]");
	
	
	
	public static void validateIframeHeader(WebDriver driver) {
		WebElement element= driver.findElement(IFRAMEHEADER);
		Assert.assertTrue(element.isDisplayed(), "Iframe Header is not Displaying");
	}
	
	public static void swicthFrameAndType(WebDriver driver) {
		driver.findElement(CLOSE_BTN).click();
		driver.switchTo().frame(0);
		
		WebElement element =driver.findElement(TEXTAREA);
		
		element.clear();
		element.sendKeys("SomeText");
		driver.switchTo().defaultContent();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.switchTo().frame(0);
		WebElement element1 =driver.findElement(TEXTAREA);
		
		Assert.assertEquals(element1.getText(),"SomeText");
	}

}
