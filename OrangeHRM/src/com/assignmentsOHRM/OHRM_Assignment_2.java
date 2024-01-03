package com.assignmentsOHRM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRM_Assignment_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./WebDriverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String URL="https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
		driver.get(URL);
		driver.manage().window().maximize();
		By HeaderProperty=By.className("menu");
		WebElement HeaderBar=driver.findElement(HeaderProperty);
		By HeaderLinksProperty=By.tagName("a");
		List<WebElement>tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
		int tsrtcHeaderLinksCount=tsrtc_HeaderPageLinks.size();
		System.out.println(tsrtcHeaderLinksCount);
		for(int index=0;index<tsrtcHeaderLinksCount;index++) {
			System.out.println(index+" "+tsrtc_HeaderPageLinks.get(index).getText());                  
			
		}
		
		
		

	}

}