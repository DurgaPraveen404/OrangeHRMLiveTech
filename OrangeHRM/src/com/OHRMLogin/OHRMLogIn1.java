package com.OHRMLogin;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRMLogIn1 {

	public static void main(String[] args) throws Exception {
		
		    System.setProperty("webdriver.chrome.driver", "./webDriverFiles/chromedriver.exe");
		    ChromeDriver cd=new ChromeDriver();
			String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
			cd.get(ApplicationUrl);
			cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cd.manage().window().maximize();
			String actualTitle=cd.getTitle();
			System.out.println(actualTitle);
			cd.findElement(By.id("txtUsername")).sendKeys("Praveen404");
			Thread.sleep(1000);
		    cd.findElement(By.id("txtPassword")).sendKeys("Praveen@404");//
			Thread.sleep(1000);
		    cd.findElement(By.id("btnLogin")).click();
			cd.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			Thread.sleep(1000);
			
			Actions actions=new Actions(cd);
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_viewAdminModule")))
			.moveToElement(cd.findElement(By.id("menu_admin_UserManagement")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewSystemUsers")))
			.click()
			.perform();
			Thread.sleep(2000);
			//cd.navigate().back();
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_Job")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewJobTitleList")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewPayGrades")))
			.moveToElement(cd.findElement(By.id("menu_admin_employmentStatus")))
			.moveToElement(cd.findElement(By.id("menu_admin_jobCategory")))
			.moveToElement(cd.findElement(By.id("menu_admin_workShift")))
			.click()
			.perform();
			Thread.sleep(2000);
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_Organization")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewOrganizationGeneralInformation")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewLocations")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewCompanyStructure")))
			.click()
			.perform();
			Thread.sleep(2000);
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_Qualifications")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewSkills")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewEducation")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewLicenses")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewLanguages")))
			.moveToElement(cd.findElement(By.id("menu_admin_membership")))
			.click()
			.perform();
			Thread.sleep(2000);
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_nationality")))
			.click()
			.perform();
			Thread.sleep(2000);
			actions
			.moveToElement(cd.findElement(By.id("menu_admin_Configuration")))
			.moveToElement(cd.findElement(By.id("menu_admin_listMailConfiguration")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewEmailNotification")))
			.moveToElement(cd.findElement(By.id("menu_admin_localization")))
			.moveToElement(cd.findElement(By.id("menu_admin_viewModules")))
			.moveToElement(cd.findElement(By.id("menu_admin_openIdProvider")))
			.moveToElement(cd.findElement(By.id("menu_admin_registerOAuthClient")))
			.click()
			.perform();
			Thread.sleep(2000);
			/*
			cd.findElement(By.id("menu_admin_nationality")).click();
			cd.findElement(By.id("btnAdd")).click();
			cd.findElement(By.id("nationality_name")).sendKeys("Indian404");
			cd.findElement(By.id("btnSave")).click();
			*/
			
			//nationality_name
			//menu_admin_UserManagement
			//menu_admin_viewSystemUsers
			
			//cd.quit();
			
			
		}
		public static void highlight(ChromeDriver cd,WebElement elem) {
			JavascriptExecutor jse=(JavascriptExecutor)cd;
			jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", elem);
				
			
			
			
		}

		 
		 
		 
		

	}


