package seleniumTest;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTesting2 {

	public static void main(String[] args) throws Exception
	{
		
        System.setProperty("webdriver.chrome.driver", "./webDriverFiles/chromedriver.exe");
		
		ChromeDriver cd=new ChromeDriver();
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		cd.get(ApplicationUrl);
		cd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cd.manage().window().maximize();
		String actualTitle=cd.getTitle();
		System.out.println(actualTitle);
		highlight(cd,cd.findElement(By.id("txtUsername")));//.sendKeys("Praveen404")
		Thread.sleep(3000);
		highlight(cd, cd.findElement(By.id("txtPassword")));//.sendKeys("Praveen@404")
		Thread.sleep(3000);
		highlight(cd, cd.findElement(By.id("btnLogin")));
		cd.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		Thread.sleep(5000);
		cd.quit();
		
		
	}
	public static void highlight(ChromeDriver cd,WebElement elem) {
		JavascriptExecutor jse=(JavascriptExecutor)cd;
		jse.executeScript("arguments[0].setAttribute('style', 'border:2px solid red; background:yellow')", elem);
			
		
		
		
		
	}

}
