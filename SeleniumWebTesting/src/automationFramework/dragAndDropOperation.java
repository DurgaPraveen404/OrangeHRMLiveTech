package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dragAndDropOperation {
	WebDriver driver;
	WebDriverWait wait;
	String URL="https://jqueryui.com/droppable/";
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		wait=new WebDriverWait(driver, 30);
		driver.get(URL);
		driver.manage().window().maximize();
	}
	public void dragAndDrop() {
		By frameProperty=By.className("demo-frame");
		WebElement frame=driver.findElement(frameProperty);
		driver.switchTo().frame(frame);
		By dragProperty=By.id("draggable");
		WebElement dragMeToTarget=driver.findElement(dragProperty);
		By dropProperty=By.id("droppable");
		WebElement dropHere=driver.findElement(dropProperty);
		Actions action=new Actions(driver);
		//action.dragAndDrop(dragMeToTarget, dropHere).build().perform();
		action.moveToElement(dragMeToTarget)
		.clickAndHold()
		.moveToElement(dropHere)
		.release()
		.build()
		.perform();
		driver.switchTo().defaultContent();
		By resizeProperty=By.linkText("Resizable");
		WebElement resizable=driver.findElement(resizeProperty);
		resizable.click();
	
	}
	public void applicationClose() {
		driver.quit();
	}

	public static void main(String[] args) {
		dragAndDropOperation draganddrop=new dragAndDropOperation();
		draganddrop.browserLaunch();
		draganddrop.dragAndDrop();
		draganddrop.applicationClose();
		

	}

}
