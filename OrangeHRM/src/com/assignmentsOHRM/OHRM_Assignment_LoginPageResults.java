package com.assignmentsOHRM;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_Assignment_LoginPageResults {

	WebDriver driver;
	String URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	String str;
	String loginPageActualText;
	String loginPageTextResult;
	String ohrmHomePageActualText;
	String actual_loginHomeTextResult;
	String errorMessage;
	

	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	public void loginText(String str) {
		
		By logInPanelHeading=By.id("logInPanelHeading");
	    WebElement loginPanel=driver.findElement(logInPanelHeading);
	    loginPageActualText=loginPanel.getText();
	    if(loginPageActualText.equals(str)) {
	    	
	         loginPageTextResult="PASS";
	    	
	    }
	    else {
	    	
	    	 loginPageTextResult="PASS";

	    }
	}
	
	public void loginTest_username(String userNameData) throws InterruptedException {
		By userNameElement=By.id("txtUsername");
	    WebElement ohrmUserName=driver.findElement(userNameElement);
	    ohrmUserName.sendKeys(userNameData);
	    Thread.sleep(1000);
	   

}
	public void loginTest_password(String passwordData) throws InterruptedException {
		 By passWordElement=By.id("txtPassword");
		    WebElement ohrmPassWord=driver.findElement(passWordElement);
		    ohrmPassWord.sendKeys(passwordData);
		    Thread.sleep(1000);
		    By logInButton=By.id("btnLogin");
		    WebElement ohrmLoginButton=driver.findElement(logInButton);
		    ohrmLoginButton.click();
		    
		   
		
	}
	public void loginHomeTextVerify(String Expected_loginHomeText) {
		String currentURL=driver.getCurrentUrl();
		if(currentURL.contains("dashboard")) {
			 By homePageWelcome=By.id("welcome");
			    WebElement welcomeAdmin=driver.findElement(homePageWelcome);     
			    String ohrmHomePageActualText1 = welcomeAdmin.getText();
			    if(ohrmHomePageActualText1.contains(Expected_loginHomeText)) {
			    	ohrmHomePageActualText=Expected_loginHomeText;
			    	actual_loginHomeTextResult="PASS";
			    }
			    //Test Welcome Admin
			    welcomeAdmin.click();
			    
			    
			    //Test LogOut
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
			    // Waits for some time to load the source code after 10 seconds it will search for element
			    By ohrmLogout=By.linkText("Logout");
			    WebElement logOutButton=driver.findElement(ohrmLogout);
			    logOutButton.click();
			    System.out.println(" LogOut from application");
		}
		else {
			actual_loginHomeTextResult="FAIL";
			By messageproperty=By.xpath("/html/body/div[1]/div/div[2]/form/div[5]/span");
			WebElement errormsg= driver.findElement(messageproperty);
			if(errormsg.isDisplayed()) {
				errorMessage=errormsg.getText();
				
			}
			else {
				errorMessage="Valid Credentials";
				System.out.println(errorMessage);
			}
			
		
		}
			
		
	}
	
	
	public void applicationClose() {
		driver.quit();
	}
}