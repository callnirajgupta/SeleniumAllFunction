package com.automation.test;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.automation.pageobject.FileDownloadPage;
import com.automation.pageobject.FileUploadPage;

public class FileDownload extends BaseTest {
	@Test
	public void FileDownLoadTest() throws InterruptedException  {
		//driver.get("http://localhost:7080/login");
		driver.get(configProperties.getProperty("BaseUrl")+"/download");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FileDownloadPage.validateFileDownLoadHeader(driver);
		FileDownloadPage.fileDownLoad(driver);
		Thread.sleep(5000);
		String downloadFilepath = System.getProperty("user.dir")+"/download";
		 File directoryPath = new File(downloadFilepath);
		 for(File file:directoryPath.listFiles()) {
		  System.out.println("printt size"+file.getName());
		  if("sizesome-file.txt".equals(file.getName())) {
			  break;
		  }
	}
		 for(File file:directoryPath.listFiles()) {
			 file.delete();
		} 
	}

}
