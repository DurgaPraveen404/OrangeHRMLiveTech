package automationFramework;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
			String linkName=tsrtc_HeaderPageLinks.get(index).getText();
			System.out.println(index+" "+linkName); 
			String ExpectedUrl=tsrtc_HeaderPageLinks.get(index).getAttribute("href");
			tsrtc_HeaderPageLinks.get(index).click();
			System.out.println(driver.getTitle());
			String ActualUrl=driver.getCurrentUrl();
			System.out.println(ActualUrl);
			if(ActualUrl.equals(ExpectedUrl)) {
				System.out.println("The Actual and Expected pages are same:- PASS");
			}
			else {
				System.out.println("The Actual and Expected pages are Not same:- FAIL");
			}

			driver.navigate().forward();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			HeaderBar=driver.findElement(By.className("menu-wrap"));
	        tsrtc_HeaderPageLinks=HeaderBar.findElements(HeaderLinksProperty);
	        
	        
		}
		driver.quit();
		
	}

}