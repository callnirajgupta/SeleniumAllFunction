package com.automation.pageobject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;

public class DragandDropPage {
	public static final By DRAGANDDROPHEADER=By.xpath("//h3[text()='Drag and Drop']");
	public static final By SOURCE=By.id("column-a");
	public static final By SOURCE_TEXT=By.xpath("//div[@id='column-a']/header");
	public static final By TARGET=By.id("column-b");
	public static final By TARGET_TEXT=By.xpath("//div[@id='column-b']/header");
	public static void validateDragAndDropHeader(WebDriver driver) {
		WebElement element= driver.findElement(DRAGANDDROPHEADER);
		Assert.assertTrue(element.isDisplayed(), "Drag and Drop header is not Displaying");

	}
	
	public static void DragAndDropAction(WebDriver driver) throws AWTException, InterruptedException {
		WebElement source=driver.findElement(SOURCE);			
        WebElement target=driver.findElement(TARGET);
        
        
        
        final String java_script =
                "var src=arguments[0],tgt=arguments[1];var dataTransfer={dropEffe" +
                "ct:'',effectAllowed:'all',files:[],items:{},types:[],setData:fun" +
                "ction(format,data){this.items[format]=data;this.types.append(for" +
                "mat);},getData:function(format){return this.items[format];},clea" +
                "rData:function(format){}};var emit=function(event,target){var ev" +
                "t=document.createEvent('Event');evt.initEvent(event,true,false);" +
                "evt.dataTransfer=dataTransfer;target.dispatchEvent(evt);};emit('" +
                "dragstart',src);emit('dragenter',tgt);emit('dragover',tgt);emit(" +
                "'drop',tgt);emit('dragend',src);";

        ((JavascriptExecutor)driver).executeScript(java_script, source, target);
        String sourceText_Before=driver.findElement(SOURCE_TEXT).getText();			
        String targetText_Before=driver.findElement(TARGET_TEXT).getText();
        Thread.sleep(5000);
        Assert.assertEquals(targetText_Before, "A", "Source is not exchanged");
        Assert.assertEquals(sourceText_Before, "B", "Target is not exchanged");
        
        
	}
	

}
