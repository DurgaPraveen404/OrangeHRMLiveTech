package com.assignmentsOHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Dynamic_WebTable {
	
	WebDriver driver;
	String URL="https://www.timeanddate.com/worldclock/";
   @Test (priority = 1)
	public void browserLaunch() {
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
   @Test (priority = 2)
	public void dynamic_Table() throws IOException {
	   FileInputStream fis=new FileInputStream("./src/OrangeHRM_MultipleSetData/WebTable_CityNames.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("CityNames");
		List<WebElement> rowNum=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr"));
		int rowCount=rowNum.size();
		List<WebElement> cellNum=driver.findElements(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td"));
		int cellCount=cellNum.size();
		for(int rowIndex=1;rowIndex<=rowCount;rowIndex++) {
			Row newRow=sheet.createRow(rowIndex-1);
			for(int cellIndex=1;cellIndex<=cellCount;cellIndex++) {
				By cityNamesProperty=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+rowIndex+"]/td["+cellIndex+"]");
				WebElement cityNames=driver.findElement(cityNamesProperty);
				String cityNamesText=cityNames.getText();
				Cell newCell=newRow.createCell(cellIndex-1);
			    newCell.setCellValue(cityNamesText);
				System.out.printf("%-10s",cityNamesText);
				System.out.print("\t");
			}
			System.out.println();
		}
		FileOutputStream fos=new FileOutputStream("./src/OrangeHRM_MultipleSetData/WebTable_CityNames.xlsx");
		workbook.write(fos);
		
	}
   @Test (priority = 3)
   public void applicationClose() {
	   driver.quit();
   }

}
