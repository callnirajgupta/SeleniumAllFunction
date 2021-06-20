package com.automation.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
	
	@Test
	public void test() {
	SoftAssert softAssert = new SoftAssert();
	System.out.println("*** test case two started ***");
	softAssert.assertEquals("Hello", "Hello", "First soft assert failed");
	System.out.println("hard assert success....");
	softAssert.assertTrue("Hello".equals("hello"), "Second soft assert failed");
	softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
	System.out.println("*** test case two executed successfully ***");
	softAssert.assertAll();
}

}
