package com.OHRMLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tsrtc_HomePageLinks {

	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.chrome.driver", "./WebDriverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String URL="https://www.tsrtconline.in/oprs-web/guest/home.do?h=1";
		driver.get(URL);
		driver.manage().window().maximize();
		By LinksProperty=By.tagName("a");
		List<WebElement>tsrtc_HomePageLinks=driver.findElements(LinksProperty);
		int tsrtcLinksCount=tsrtc_HomePageLinks.size();
		System.out.println(tsrtcLinksCount);
		for(int i=0;i<tsrtcLinksCount;i++) {
			System.out.println(i+" "+tsrtc_HomePageLinks.get(i).getText());                  
			
		}
		// TODO Auto-generated method stub

	}

}