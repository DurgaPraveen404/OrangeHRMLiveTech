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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.OHRM_Test_WithExcel.OHRM_LoginTest1;

import io.github.bonigarcia.wdm.WebDriverManager;
public class employeeList_Excel extends OHRM_LoginTest1{
	
	@Test 
	public void employeeList() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		By logInPanelHeading=By.id("logInPanelHeading");
	    WebElement loginPanel=driver.findElement(logInPanelHeading);
	    String loginPageActualText2=loginPanel.getText();
	    if(loginPageActualText2.equals("LOGIN Panel")) {
	    	
	         System.out.println(" ***********LogIn Page PASS***************");
	    	
	    }
	    else {
	    	
	    	System.out.println(" ***********LogIn Page  FAIL***************");

	    }
	    By userNameElement2=By.id("txtUsername");
	    WebElement ohrmUserName2=driver.findElement(userNameElement2);
	    ohrmUserName2.sendKeys("Praveen404");
	    Thread.sleep(1000);
	    By passWordElement=By.id("txtPassword");
	    WebElement ohrmPassWord2=driver.findElement(passWordElement);
	    ohrmPassWord2.sendKeys("Praveen@404");
	    Thread.sleep(1000);
	    By logInButton=By.id("btnLogin");
	    WebElement ohrmLoginButton2=driver.findElement(logInButton);
	    ohrmLoginButton2.click();
	    Actions actions=new Actions(driver);
		actions
		.moveToElement(driver.findElement(By.id("menu_pim_viewPimModule")))
		.moveToElement(driver.findElement(By.id("menu_pim_Configuration")))
		.moveToElement(driver.findElement(By.id("menu_pim_viewEmployeeList")))
		.click()
		.build()
		.perform();
		FileInputStream fis=new FileInputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestDataTestNg.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet3"); 
		WebElement table=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table"));
		List<WebElement> empList_Rows=driver.findElements(By.tagName("tr"));
		int rowCount=empList_Rows.size();
		System.out.println("**************Employee List**************");
		 System.out.println();
		for(int index=0;index<rowCount;index++) {
			Row excelrow=sheet.createRow(index);
			WebElement row=empList_Rows.get(index);
			List<WebElement> rowOfCells=row.findElements(By.tagName("td"));
			int cellCount=rowOfCells.size();
			for(int cell=0;cell<cellCount;cell++) {
				Cell cellofrow=excelrow.createCell(cell);
				 WebElement rowOfCell=rowOfCells.get(cell);
				 String cellText=rowOfCell.getText();
				 cellofrow.setCellValue(cellText);
				 System.out.print(cellText);
				 System.out.print("\t");
			}
			System.out.println();
		}
		FileOutputStream fos=new FileOutputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestDataTestNgEmpList.xlsx");
		workbook.write(fos);
		
	}
	

	
}
