package com.assignmentsOHRM;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_Assignment_4_TakingScreenshots {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "./webDriverFiles/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		String URL="https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Identify Links Block
		By HeaderProperty=By.className("menu-wrap");
		WebElement HeaderBar=driver.findElement(HeaderProperty);
		By HeaderLinksProperty=By.tagName("a");
		List<WebElement>tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
		int tsrtcHeaderLinksCount=tsrtc_HeaderPageLinks.size();
		System.out.println(tsrtcHeaderLinksCount);
		
		//For Loop to Click Each Link
		for(int index=0;index<tsrtcHeaderLinksCount;index++) {
			String linkName=tsrtc_HeaderPageLinks.get(index).getText();
			System.out.println(index+" "+linkName); 
			String ExpectedUrl=tsrtc_HeaderPageLinks.get(index).getAttribute("href");
			tsrtc_HeaderPageLinks.get(index).click();
			
		    //Verifying Landing Page
			System.out.println(driver.getTitle());
			String ActualUrl=driver.getCurrentUrl();
			System.out.println(ActualUrl);
			if(ActualUrl.equals(ExpectedUrl)) {
				System.out.println("The Actual and Expected pages are same:- PASS");
			}
			else {
				System.out.println("The Actual and Expected pages are Not same:- FAIL");
			}
			
			//Taking Screenshots of Every WebPage
			//////////////// MAIN CODE ////////////////////////
			///////////////////////////////////////////////////////
			File screenShotImg=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String filePath="./Screenshots/"+linkName+".png";
			FileUtils.copyFile(screenShotImg, new File(filePath));
			///////////////////////////////////////////////////////
			
			
			driver.navigate().forward();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			HeaderBar=driver.findElement(By.className("menu-wrap"));
	        tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
	        
	        
		}
		driver.quit();
		

	}

}
