package com.assignmentsOHRM;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRM_AddEmployee_LoginPage {
	WebDriver driver;
	//Navigating to OrangeHRM URL
	
	String ohrm_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	List<Object>array1=new ArrayList<>();
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ohrm_Url);
	    driver.manage().window().maximize();
	    
	}
	public void logInTest() throws InterruptedException {
		
		By userNameElement=By.id("txtUsername");
	    WebElement ohrmUserName=driver.findElement(userNameElement);
	    ohrmUserName.sendKeys("Praveen404");
	    Thread.sleep(1000);
	    By passWordElement=By.id("txtPassword");
	    WebElement ohrmPassWord=driver.findElement(passWordElement);
	    ohrmPassWord.sendKeys("Praveen@404");
	    Thread.sleep(1000);
	    By logInButton=By.id("btnLogin");
	    WebElement ohrmLoginButton=driver.findElement(logInButton);
	    ohrmLoginButton.click();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	public void logInHomePage() {
		System.out.println("********Home Page**********");
		String ohrmHomePageExpectedText="Welcome";
	    By homePageWelcome=By.id("welcome");
	    WebElement welcomeAdmin=driver.findElement(homePageWelcome);     
	    String ohrmHomePageActualText= welcomeAdmin.getText();
	    System.out.println(ohrmHomePageActualText);
	    if(ohrmHomePageActualText.contains(ohrmHomePageExpectedText)) {
	    	System.out.println("The Result  page is HomePage:- PASS");
	    }
	    else {
	    	System.out.println("The Result page is not HomePage:- FAIL");
	    }
	   
	  
	}
	public void AddEmployee() {
		String Expected_AddEmployeeText="Add Employee";
		
		 Actions actions=new Actions(driver);
			actions
			.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule")))
			.moveToElement(driver.findElement(By.id("menu_pim_Configuration")))
			.moveToElement(driver.findElement(By.id("menu_pim_viewEmployeeList")))
			.moveToElement(driver.findElement(By.id("menu_pim_addEmployee")))
			.click()
			.perform();
			
			By addEmployeeTextProperty=By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1");
		    WebElement addEmployeeText=driver.findElement(addEmployeeTextProperty);
		    String addEmployeePageText=addEmployeeText.getText();
		    if(addEmployeePageText.equals(Expected_AddEmployeeText)) {
		    	System.out.println("********Add Employee Page**********");
		    	System.out.println("The result page is Add Employee page :- PASS");
		    }
		    else {
		    	System.out.println("The result page is not an Add Employee page :- FAIL");
		    }
		    
		
		
		
	}
	

}
