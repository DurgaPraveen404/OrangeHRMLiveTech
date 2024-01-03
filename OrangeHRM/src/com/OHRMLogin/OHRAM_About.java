package com.OHRMLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OHRAM_About {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./WebDriverFiles/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String URL="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		driver.get(URL);
		driver.manage().window().maximize();
		WebElement userName=driver.findElement(By.id("txtUsername"));
		userName.sendKeys("Praveen404");
		WebElement passWord=driver.findElement(By.id("txtPassword"));
		passWord.sendKeys("Praveen@404");
		WebElement logIn=driver.findElement(By.id("btnLogin"));
		logIn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement welcomeAdmin=driver.findElement(By.xpath("//a[@id='welcome']"));
		WebElement about=driver.findElement(By.xpath("//div[@id='welcome-menu']//ul/li/a[text()='About']"));
		WebElement close=driver.findElement(By.xpath("//div[@class='modal-header']/a[@class='close']"));
		Thread.sleep(3000);
		Actions actions=new Actions(driver);
		actions
		.moveToElement(welcomeAdmin)
		.click()
		.perform();
		Thread.sleep(3000);
		actions
		.moveToElement(about)
		.click()
		.perform();   //     //div[@class='modal-header']/a[@class='close']
		Thread.sleep(3000);
		actions
		.moveToElement(close)
		.click()
		.perform();
		Thread.sleep(3000);
		actions
		.moveToElement(welcomeAdmin)
		.click()
		.perform();
		Thread.sleep(3000);
		
		
				

	}

}
