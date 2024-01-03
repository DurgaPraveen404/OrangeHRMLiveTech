package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_WebTable {

	public static void main(String[] args) throws IOException {
		
	{
		FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("CityNames");
		WebDriver driver;
		String URL="https://www.timeanddate.com/worldclock/";
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
		List<WebElement> rowNum=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		int rowCount=rowNum.size();
		List<WebElement> cellNum=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td"));
		int cellCount=cellNum.size();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
			for(int cellIndex=1;cellIndex<=cellCount;cellIndex++) {
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+cellIndex+"]");
				WebElement cityNames=driver.findElement(cityNamesProperty);
				String cityNamesText=cityNames.getText();
				System.out.printf("%-10s",cityNamesText);
				System.out.print("\t");
			}
			System.out.println();
		}
		

	}
	}
}


