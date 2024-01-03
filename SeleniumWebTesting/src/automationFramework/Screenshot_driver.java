package automationFramework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot_driver {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		
		//Navigating to OrangeHRM URL
		
		String ohrm_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	    driver.get(ohrm_Url);
	    driver.manage().window().maximize();
	    File driverScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(driverScreenshot, new File("./Screenshots/1.png"));
		

	}

}
