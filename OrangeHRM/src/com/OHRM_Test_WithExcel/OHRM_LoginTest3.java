package com.OHRM_Test_WithExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class OHRM_LoginTest3 {
	public WebDriver driver;
	FileInputStream fis;
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	Properties property;
	String str;
	String loginPageActualText;
	String loginPageTextResult;
	String ohrmHomePageActualText;
	String actual_loginHomeTextResult;
	String errorMessage;
	String addEmployeePageText;
	String addEmployeePageResult;
	String expectedEmpId;
	String personalPageString;
	String personalPageTextResult;
	String actualFirstName;
	String actualMiddleName;
	String actualLastName;
	String actualEmpId;
	String Expected_FirstName;
	String Expected_MiddleName;
	String Expected_LastName;
	String firstNameResult;
	String middleNameResult;
	String lastNameResult;
	String empIdResult;
	
     @BeforeTest
	public void browserLaunch() {
    	
    	String URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
     
	
	public void loginText(String str) throws IOException {
		
		file=new FileInputStream("./src/com/Config/LogInWebElements.properties");
		property=new Properties();
		property.load(file);
		By logInPanelHeading=By.id(property.getProperty("LogInPanelPropertyId"));
	    WebElement loginPanel=driver.findElement(logInPanelHeading);
	    loginPageActualText=loginPanel.getText();
	    if(loginPageActualText.equals(str)) {
	    	
	         loginPageTextResult="PASS";
	    	
	    }
	    else {
	    	
	    	loginPageTextResult="FAIL"; 

	    }
	}
	
	public void loginTest_username(String userNameData) throws InterruptedException {
		By userNameElement=By.id(property.getProperty("UserPropertyId"));
	    WebElement ohrmUserName=driver.findElement(userNameElement);
	    ohrmUserName.sendKeys(userNameData);
	    Thread.sleep(1000);
	   }    
	
	public void loginTest_password(String passwordData) throws InterruptedException {
		 By passWordElement=By.id(property.getProperty("PasswordPropertyId"));
		    WebElement ohrmPassWord=driver.findElement(passWordElement);
		    ohrmPassWord.sendKeys(passwordData);
		    Thread.sleep(1000);
		    By logInButton=By.id(property.getProperty("LoginButtonPropertyId"));
		    WebElement ohrmLoginButton=driver.findElement(logInButton);
		    ohrmLoginButton.click();
	
	}
	
	public void loginHomeTextVerify(String Expected_loginHomeText) {
		String currentURL=driver.getCurrentUrl();
		if(currentURL.contains("dashboard")) {
			 By homePageWelcome=By.id(property.getProperty("WelcomeAdminPropertyId"));
			    WebElement welcomeAdmin=driver.findElement(homePageWelcome);     
			    String ohrmHomePageActualText1 = welcomeAdmin.getText();
			    if(ohrmHomePageActualText1.contains(Expected_loginHomeText)) {
			    	ohrmHomePageActualText=Expected_loginHomeText;
			    	actual_loginHomeTextResult="PASS";
			    }
			    else {
			    	actual_loginHomeTextResult="FAIL";
			    }
			    //Test Welcome Admin
			    
			   
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
	public void AddEmployee(String Expected_AddEmployeeText) {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Actions actions=new Actions(driver);
			actions
			.moveToElement(driver.findElement(By.id(property.getProperty("PimPropertyId"))))
			.moveToElement(driver.findElement(By.id(property.getProperty("PimConfigurationId"))))
			.moveToElement(driver.findElement(By.id(property.getProperty("ViewEmployeeListId"))))
			.moveToElement(driver.findElement(By.id(property.getProperty("AddEmployeeId"))))
			.click()
			.perform();

			By addEmployeeTextProperty=By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1");
		    WebElement addEmployeeText=driver.findElement(addEmployeeTextProperty);
		    addEmployeePageText=addEmployeeText.getText();
	    if(addEmployeePageText.equals(Expected_AddEmployeeText)) {
		    	System.out.println("********Add Employee Page**********");
		    	addEmployeePageResult="PASS";
		    }
		    else {
		    	addEmployeePageResult="FAIL";
		    }
		}
		
		
	
	public void emp_FirstName(String Expected_EmpFirstName) {
		Expected_FirstName=Expected_EmpFirstName;
		driver.findElement(By.id(property.getProperty("FirstNamePropertyId"))).sendKeys(Expected_EmpFirstName);
		
	}
	public void emp_MiddleName(String Expected_EmpMiddleName) {
		Expected_MiddleName=Expected_EmpMiddleName;
		driver.findElement(By.id(property.getProperty("MiddleNamePropertyId"))).sendKeys(Expected_EmpMiddleName);
		
	}
	public void emp_LastName(String Expected_EmpLastName) {
		Expected_LastName=Expected_EmpLastName;
		driver.findElement(By.id(property.getProperty("LastNamePropertyId"))).sendKeys(Expected_EmpLastName);
		WebElement employeeid=driver.findElement(By.id(property.getProperty("EmpPropertyId")));
		expectedEmpId=employeeid.getAttribute("value");
		driver.findElement(By.id(property.getProperty("SaveButtonPropertyId"))).click();
		driver.navigate().forward();
		
	}
	public void personal_DetailsPage(String Expected_PersonalDetailsPageText) {
		By personaldetailsPageProperty=By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1");
		WebElement personalPageText=driver.findElement(personaldetailsPageProperty);
	    personalPageString=personalPageText.getText();
	    
	    if(personalPageString.equals(Expected_PersonalDetailsPageText)) {
	    	System.out.println("********Personal Details Page**********");
	    	personalPageTextResult="PASS";
	    }
	    else {
	    	personalPageTextResult="FAIL";
	    	
	    }
	    WebElement actual_firstNameField=driver.findElement(By.id("personal_txtEmpFirstName"));
	    actualFirstName=actual_firstNameField.getAttribute("value");
	    
	    WebElement actual_middleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
	    actualMiddleName=actual_middleName.getAttribute("value");
	    WebElement actual_lastName=driver.findElement(By.id("personal_txtEmpLastName"));
	    actualLastName=actual_lastName.getAttribute("value");
	    WebElement actual_empid=driver.findElement(By.id("personal_txtEmployeeId"));
	    actualEmpId=actual_empid.getAttribute("value");
	    namesValidation();
	    By homePageWelcome=By.id(property.getProperty("WelcomePropertyId"));
	    WebElement welcomeAdmin=driver.findElement(homePageWelcome);
	    welcomeAdmin.click();
		  
	    //Test LogOut
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	    // Waits for some time to load the source code after 10 seconds it will search for element
	    By ohrmLogout=By.linkText(property.getProperty("LogOutPropertyId"));
	    WebElement logOutButton=driver.findElement(ohrmLogout);
	    logOutButton.click();
	    System.out.println(" LogOut from application");
	   
	}
	public void namesValidation() {
		 if(Expected_FirstName.equals(actualFirstName)) {
		    	firstNameResult="PASS";
		    }
		 else {
			 firstNameResult="FAIL";
		 }
		 if(Expected_MiddleName.equals(actualMiddleName)) {
			 middleNameResult="PASS";
		 }
		 else {
			 middleNameResult="FAIL";
		 }
		 if(Expected_LastName.equals(actualLastName)) {
			 lastNameResult="PASS";
		 }
		 else {
			 lastNameResult="FAIL";
		 }
		 if(expectedEmpId.equals(actualEmpId)) {
			 empIdResult="PASS";
		 }
		 else {
			 empIdResult="FAIL";
		 }
		   
			
	}
	
	@AfterTest
	public void applicationClose() {
		driver.quit();
	}

	

}
