package com.automation.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FileDownloadPage {
	public static final By FILEDOWNLOADHEADER=By.xpath("//h3[text()='File Downloader']");
	public static final By FILE=By.xpath("//a[text()='some-file.txt']");
	
	public static void validateFileDownLoadHeader(WebDriver driver) {
		WebElement element= driver.findElement(FILEDOWNLOADHEADER);
		Assert.assertTrue(element.isDisplayed(), "FileDownLoad Header is not Displaying");

	}
	
	public static void fileDownLoad(WebDriver driver) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(FILE).click();
	}
	
	
}
