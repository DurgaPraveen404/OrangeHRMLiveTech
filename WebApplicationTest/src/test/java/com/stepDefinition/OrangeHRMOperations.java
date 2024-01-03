package com.stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Utility.Log;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHRMOperations {
	
	WebDriver driver;
	String URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	public  OrangeHRMOperations(Hooks hook) {
		
	    driver=hook.cd;
	}
	@When("^user should be navigated to logIn page$")
	public void user_should_be_navigated_to_logIn_page()  {
		driver.get(URL);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^user should validate the login page$")
	public void user_should_validate_the_login_page() {
		By logInPanelHeading=By.id("logInPanelHeading");
	    WebElement loginPanel=driver.findElement(logInPanelHeading);
	    String loginPageActualText=loginPanel.getText();
	    if(loginPageActualText.equals("LOGIN Panel")) {
	    	
	         Log.info("Login Page PASS");
	    	
	    }
	    else {
	    	
	    	Log.info("Login Page FAIL");

	    }
	    
	}

	@Then("^user should enters the \"([^\"]*)\" and \"([^\"]*)\" and click on Login$")
	public void user_should_enters_the_and_and_click_on_Login(String Username, String Password)  {
		By userNameElement=By.id("txtUsername");
	    WebElement ohrmUserName=driver.findElement(userNameElement);
	    ohrmUserName.sendKeys(Username);
	    By passWordElement=By.id("txtPassword");
	    WebElement ohrmPassWord=driver.findElement(passWordElement);
	    ohrmPassWord.sendKeys(Password);
	    By logInButton=By.id("btnLogin");
	    WebElement ohrmLoginButton=driver.findElement(logInButton);
	    ohrmLoginButton.click();
	    
	}
	By welComeAdminProperty;
	WebElement welComeAdmin;

	@Then("^user should navigate to Home Page$")
	public void user_should_navigate_to_Home_Page() {
		String expected_OrangeHRMApplicationHomePageText="Welcome";
		welComeAdminProperty=By.id("welcome");
		welComeAdmin=driver.findElement(welComeAdminProperty);
		String actual_OrangeHRMApplicationHomePageText=welComeAdmin.getText();
		Log.info(" The Actual Text of the OrangeHRM Application HomePage is :- "+actual_OrangeHRMApplicationHomePageText);

		if(actual_OrangeHRMApplicationHomePageText.contains(expected_OrangeHRMApplicationHomePageText))
		{
			Log.info(" Successfully Navigated to OrangeHRM Application HomePage - PASS");
		}
		else
		{
			Log.info(" Failed to Navigate to OrangeHRM Application HomePage - FAIL");
		}
	   
	}

	@Then("^user should click on welcome Admin$")
	public void user_should_click_on_welcome_Admin() {
	   welComeAdmin.click();
	}

	@Then("^user should click on Logout button$")
	public void user_should_click_on_Logout_button() {
			By ohrmLogout=By.linkText("Logout");
		    WebElement logOutButton=driver.findElement(ohrmLogout);
		    logOutButton.click();
		    Log.info(" LogOut from application");
	    
	}
	

}
