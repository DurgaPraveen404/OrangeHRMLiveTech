package com.OHRMLogin;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class DatePicker {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter year:- ");
		String Year=scan.next();
		System.out.println("Enter Month:- ");
		int Month=scan.nextInt();
		System.out.println("Enter Day:- ");
		String Days=scan.next();
	//	Thread.sleep(10000);
		System.out.println("Your DOB is:-"+Year+" "+Month+" "+Days+" ");
	//	Thread.sleep(10000);
		

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
		    Thread.sleep(2000);
		    //String msg=cd.findElement(By.id("spanMessage")).getText();
		    //System.out.println(msg);
			cd.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
			Thread.sleep(1000);
			Actions actions=new Actions(cd);
			actions
			.moveToElement(cd.findElement(By.id("menu_recruitment_viewRecruitmentModule")))
			.moveToElement(cd.findElement(By.id("menu_recruitment_viewCandidates")))
			.click()
			.perform();
			Thread.sleep(2000);
			/*WebElement status=cd.findElement(By.id("candidateSearch_status"));
			Select select=new Select(status);
			select.selectByIndex(4);
			Thread.sleep(2000);
			select.selectByValue("SHORTLISTED");
			Thread.sleep(2000);
			select.selectByVisibleText("Interview Passed");	
			Thread.sleep(4000);
			*/
			actions
			.moveToElement(cd.findElement(By.className("ui-datepicker-trigger")))
		    .click()
		    .perform();
			Thread.sleep(2000);
			WebElement date=cd.findElement(By.className("ui-datepicker-month"));
			Select se=new Select(date);
			actions
			.moveToElement(date)
		    .click()
		    .perform();
			Thread.sleep(2000);
			se.selectByIndex(Month);
			
			Thread.sleep(2000);
			WebElement year=cd.findElement(By.className("ui-datepicker-year"));
			Select sel=new Select(year);
			actions
			.moveToElement(year)
		    .click()
		    .perform();
			Thread.sleep(2000);
			sel.selectByValue(Year);
			Thread.sleep(2000);
			
			/*WebElement calender=cd.findElement(By.className("ui-datepicker-calender"));
			Select sele=new Select(calender);
			actions
			.moveToElement(calender)                //td[@onClick="DP_jQuery_1701530408259.datepicker._selectDay('#candidateSearch_fromDate',5,1999, this);return false;"
		    .click()
		    .perform();
		   */

			Thread.sleep(5000);
			actions
			.moveToElement(cd.findElement(By.linkText(Days)))

			//.moveToElement(cd.findElementByXPath("//td[@onclick=\"DP_jQuery_1701530408259.datepicker._selectDay('#candidateSearch_fromDate',0,1999, this);return false;\"]/a[text()='28']"))
			.click()
			.perform();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			
			cd.quit();
			

	}

}
