package com.assignmentsOHRM;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageLinksVerificationAndValidation {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./webDriverFiles/chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		String URL="https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		By HeaderProperty=By.className("menu-wrap");
		WebElement HeaderBar=driver.findElement(HeaderProperty);
		By HeaderLinksProperty=By.tagName("a");
		List<WebElement>tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
		int tsrtcHeaderLinksCount=tsrtc_HeaderPageLinks.size();
		System.out.println(tsrtcHeaderLinksCount);
		for(int index=0;index<tsrtcHeaderLinksCount;index++) {
			System.out.println(index+" "+tsrtc_HeaderPageLinks.get(index).getText()); 
			String ExpectedUrl=tsrtc_HeaderPageLinks.get(index).getAttribute("href");
			tsrtc_HeaderPageLinks.get(index).click();
			System.out.println(driver.getTitle());
			String ActualUrl=driver.getCurrentUrl();
			System.out.println(ExpectedUrl);
			System.out.println(ActualUrl);
			if(ActualUrl.equals(ExpectedUrl)) {
				
				System.out.println("The Actual and Expected pages are same:- PASS");
				
			}
			else {
				
				System.out.println("The Actual and Expected pages are Not same:- FAIL");
			}
			driver.navigate().back();
		  
			HeaderBar=driver.findElement(HeaderProperty);
	        tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
	        System.out.println(tsrtcHeaderLinksCount);
	        
		}
		driver.quit();

		
	}

}
