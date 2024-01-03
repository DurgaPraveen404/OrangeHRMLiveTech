package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webTable_DateAndTime {
	
	WebDriver driver;
	String URL="https://www.timeanddate.com/worldclock/";

	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	public void get_TableData() throws IOException {
		FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("WebTable");
		int index;
		int cell;
		for(index=1;index<=36;index++) {
			Row newRow=sheet.createRow(index-1);
			//Row row=sheet.getRow(index-1);
			for(cell=1;cell<=8;cell++) {
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+index+"]/td["+cell+"]");
				WebElement cityNames=driver.findElement(cityNamesProperty);
				String cityNamesText=cityNames.getText();
				Cell newCell=newRow.createCell(cell-1);
			    newCell.setCellValue(cityNamesText);
				System.out.printf("%-10s",cityNamesText);
				System.out.print("\t");
				
			}
			System.out.println();
		
		}
		FileOutputStream fos=new FileOutputStream("./src/ExcelFile/LivetechExcel2.xlsx");
		workbook.write(fos);

		
	}
	public void getCityNames() throws IOException {
		FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel2.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("CityNames");
		int index;
		int cell;
		
		for(index=1;index<=36;index++) {
			Row newRow=sheet.createRow(index-1);
			//Row row=sheet.getRow(index-1);
			for(cell=1;cell<=8;cell=cell+2) {
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+index+"]/td["+cell+"]");
				WebElement cityNames=driver.findElement(cityNamesProperty);
				String cityNamesText=cityNames.getText();
				Cell newCell=newRow.createCell(cell-1);
			    newCell.setCellValue(cityNamesText);
				System.out.printf("%-10s",cityNamesText);
				System.out.print("\t");
				
			}
			System.out.println();
		
		}
		FileOutputStream fos=new FileOutputStream("./src/ExcelFile/WebTable_CityNames.xlsx");
		workbook.write(fos);
	}
	public void applicationClose() {
		driver.quit();
	}
	
	public static void main(String[] args) throws IOException {
		
		webTable_DateAndTime webtable=new webTable_DateAndTime();
		webtable.browserLaunch();
		webtable.get_TableData();
		webtable.getCityNames();
		webtable.applicationClose();
		
		
	}

}