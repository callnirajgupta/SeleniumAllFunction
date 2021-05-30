package com.automation.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	
	public static String reportName;
	public WebDriver driver;
	public static Properties configProperties;
	private static final String configFile = System.getProperty("user.dir")+ "/src/test/resources/config.properties";
	
	@BeforeSuite()
	public void beforeSuite() throws IOException {
		System.out.println("******************"+configFile);
		configProperties = new Properties();
		FileInputStream fisConfig = new FileInputStream(configFile);
		configProperties.load(fisConfig);
	}
	
	@BeforeMethod()
	public void  beforemethod(){
		WebDriverManager.chromedriver().setup();
		//String downloadFilepath = System.getProperty("user.dir")+"/download";
		
		File folder=new File("download");
	    folder.mkdir();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", folder.getAbsolutePath());
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		//WebDriver driver = new ChromeDriver(cap);
        driver= new ChromeDriver(cap);
		}
	
	@AfterMethod()
	public void logout(ITestResult testNgResult) throws IOException{
		driver.close();
		driver.quit();
		
	}
	
	

}
