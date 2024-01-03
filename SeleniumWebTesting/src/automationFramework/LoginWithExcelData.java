package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.seleniumhq.jetty9.server.Authentication.User;

public class LoginWithExcelData {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","./WebDriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		String ohrm_Url="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	    driver.get(ohrm_Url);
	    driver.manage().window().maximize();
	    
	    FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet2=workbook.getSheet("sheet1");
		int rowCount=sheet2.getLastRowNum();
		System.out.println(rowCount);
		
		int cellCount=sheet2.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		for(int currentRow=0;currentRow<=rowCount;currentRow++) {
			String UserName=sheet2.getRow(currentRow).getCell(0).toString();
			String PassWord=sheet2.getRow(currentRow).getCell(1).toString();
			try {
			By userNameElement=By.id("txtUsername");
		    WebElement ohrmUserName=driver.findElement(userNameElement);
		    ohrmUserName.sendKeys(UserName);
			
		    By passWordElement=By.id("txtPassword");
		    WebElement ohrmPassWord=driver.findElement(passWordElement);
		    ohrmPassWord.sendKeys(PassWord);
			
		    By logInButton=By.id("btnLogin");
		    WebElement ohrmLoginButton=driver.findElement(logInButton);
		    ohrmLoginButton.click();
			}
			catch(Exception e){
				System.out.println(e);
				
			}
		    Cell newCell=sheet2.getRow(currentRow).createCell(2);
		    newCell.setCellValue("Pass");
		    
		
		FileOutputStream fos=new FileOutputStream("./src/ExcelFile/LivetechExcel2.xlsx");
		FileOutputStream fos1=new FileOutputStream("./src/ExcelFile/LivetechExcel.xlsx");

		workbook.write(fos);
		workbook.write(fos1);
		
	
		

	}

}
}
