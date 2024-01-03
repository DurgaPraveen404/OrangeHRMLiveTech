package com.assignmentsOHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class assignment_RadioButtons {
	WebDriver driver;
	@BeforeTest
	public void browserLaunch() {
    	
    	String URL="https://echoecho.com/htmlforms10.htm";
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	@Test
	public void radioButtonValidation() {
		By radioTableProperty=By.name("group1");
		List<WebElement>radioGroup1= driver.findElements(radioTableProperty);
		By radioTableProperty2=By.name("group2");
		List<WebElement>radioGroup2= driver.findElements(radioTableProperty2);
		for(int index=0;index<radioGroup1.size();index++) {
			
				radioGroup1.get(index).click();
				System.out.println(radioGroup1.get(index).isSelected());
			}
			
		for(int index=0;index<radioGroup2.size();index++) {
			
			radioGroup2.get(index).click();
			System.out.println(radioGroup2.get(index).isSelected());
		}
			
		}
		
		
		
	}


