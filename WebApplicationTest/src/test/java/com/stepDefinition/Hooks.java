package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Utility.Log;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static WebDriver cd;
	@Before
	public static void setUp()
	{

		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		cd = new ChromeDriver();
		Log.info(" *** Chrome Browser Launched Successfully ********");

	}
	@After
	public static void tearDown()
	{
		cd.quit();
		Log.info(" *****  Successfully Close the Browser along with OrangeHRM Application ");

	}

}