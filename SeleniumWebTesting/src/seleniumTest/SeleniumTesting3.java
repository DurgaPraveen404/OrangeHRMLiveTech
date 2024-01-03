package seleniumTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTesting3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 System.setProperty("webdriver.chrome.driver", "./webDriverFiles/chromedriver.exe");
			
			ChromeDriver cd=new ChromeDriver();
			cd.get("https:Facebook.com");
			cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			cd.manage().window().maximize();
			cd.findElement(By.name("email")).sendKeys("8639100172");
			cd.findElement(By.name("pass")).sendKeys("praveencse");
			cd.findElement(By.name("login")).click();
	}

}
