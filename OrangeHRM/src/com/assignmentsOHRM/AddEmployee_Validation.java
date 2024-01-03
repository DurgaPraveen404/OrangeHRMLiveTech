package com.assignmentsOHRM;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AddEmployee_Validation extends OHRM_AddEmployee_LoginPage {
	List<Object>array2=new ArrayList<>();
	public void Expected_employeeDetails() throws IOException, InterruptedException {
		String firstName="Durga";
		String middleName="Praveen";
		String lastName="Reddy";
		driver.findElement(By.id("firstName")).sendKeys(firstName);
		Actions actions=new Actions(driver);
		actions
		.sendKeys(Keys.TAB)
		.sendKeys(middleName)
		.sendKeys(Keys.TAB)
		.sendKeys(lastName)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB)
		.sendKeys(Keys.ENTER)
		.build()
		.perform();
		Thread.sleep(10000);
		java.lang.Runtime.getRuntime().exec("C:\\Users\\durga\\OneDrive\\Desktop\\fileUpload.exe");
		Thread.sleep(10000);
		//driver.findElement(By.id("middleName")).sendKeys(middleName);
		//driver.findElement(By.id("lastName")).sendKeys(lastName);
		WebElement employeeid=driver.findElement(By.id("employeeId"));
		String expextedEmpId=employeeid.getAttribute("value");
		array1.add(0, firstName);
		array1.add(1,middleName);
		array1.add(2, lastName);
		array1.add(3,expextedEmpId);
		driver.findElement(By.id("btnSave")).click();
		driver.navigate().forward();
		
		
	}
	public void Actual_employeeDetails() {
		String expectedPageText="Personal Details";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By personaldetailsPageProperty=By.xpath("/html/body/div[1]/div[3]/div/div[2]/div[1]/h1");
	    //WebElement personalText=driver.findElement(personaldetailsPageProperty);
	    WebElement personalPageText=driver.findElement(personaldetailsPageProperty);
	    
	    String personalPageString=personalPageText.getText();
	    if(personalPageString.equals(expectedPageText)) {
	    	System.out.println("********Personal Details Page**********");
	    	System.out.println("The result page is Personal Details page :- PASS");
	    	System.out.println();
	    }
	    else {
	    	System.out.println("The result page is not Personal Details page :- FAIL");
	    	
	    }
	    WebElement pic= driver.findElement(By.id("empPic"));
	    boolean flag=pic.isDisplayed();
	    if(flag) {
	    	System.out.println("Photo uploaded successfully:- PASS");
	    }
	    else {
	    	System.out.println("Photo NOT uploaded successfully:- FAIL");
	    }
	    WebElement actual_firstNameField=driver.findElement(By.id("personal_txtEmpFirstName"));
	    String actualFirstName=actual_firstNameField.getAttribute("value");
	    
	    WebElement actual_middleName=driver.findElement(By.id("personal_txtEmpMiddleName"));
	    String actualMiddleName=actual_middleName.getAttribute("value");
	    WebElement actual_lastName=driver.findElement(By.id("personal_txtEmpLastName"));
	    String actualLastName=actual_lastName.getAttribute("value");
	    WebElement actual_empid=driver.findElement(By.id("personal_txtEmployeeId"));
	    String actualEmpId=actual_empid.getAttribute("value");
	    
	    array2.add(0, actualFirstName);
	    array2.add(1, actualMiddleName);
	    array2.add(2, actualLastName);
	    array2.add(3, actualEmpId);
	    
		
	}
	public void details_Validation() {
	
		if(array1.get(0).equals(array2.get(0))) {
				System.out.println(array1.get(0));
				System.out.println(array2.get(0));
				System.out.println("Actual FirstName and Expected FirstName are Matched:- PASS");
				System.out.println();
			
			if(array1.get(1).equals(array2.get(1))) {
				System.out.println(array1.get(1));
				System.out.println(array2.get(1));
				System.out.println("Actual MiddleName and Expected MiddleName are Matched:- PASS");
				System.out.println();
				
			    if(array1.get(2).equals(array2.get(2))) {
				System.out.println(array1.get(2));
				System.out.println(array2.get(2));
				System.out.println("Actual LastName and Expected LastName are Matched:- PASS");
				System.out.println();
			    
				if(array1.get(3).equals(array2.get(3))) {
				System.out.println(array1.get(3));
				System.out.println(array2.get(3));
				System.out.println("Actual EmployeeId and Expected EmployeeId are Matched:- PASS");
				System.out.println();
				}
			    }
			}
		}
		else {
			System.out.println("Not Matched:- FAIL");
		}
		}
	public void applicationClose() {
		//driver.quit();
	}
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
		
		AddEmployee_Validation addemployee=new AddEmployee_Validation();
		addemployee.browserLaunch();
		addemployee.logInTest();
		addemployee.logInHomePage();
		addemployee.AddEmployee();
		addemployee.Expected_employeeDetails();
		addemployee.Actual_employeeDetails();
		addemployee.details_Validation();
		addemployee.applicationClose();
		

	}

}
