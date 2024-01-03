package com.OHRMLogin;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Datepickerloop {

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
		String mydate="02/Feb/2002";
		SimpleDateFormat dateformat=new SimpleDateFormat("dd/MMM/yyyy");
		dateformat.setLenient(false);
		Date formatteddate=dateformat.parse(mydate);
		System.out.println(formatteddate);
		int targetmonth=formatteddate.getMonth();
		int targetyear=formatteddate.getYear();
		String currentDate=cd.findElement(By.className("ui-datepicker-title")).getText(); //class="ui-datepicker-title"
		System.out.println(currentDate);
		
		
		
		

	}

}
