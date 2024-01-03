package com.assignmentsOHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class loginHomePageResults extends OHRM_Assignment_LoginPageResults {
	public void excelOperations() throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("sheet1");
		int rowCount=sheet.getLastRowNum();
		
		for(int index=1;index<=rowCount;index++) {
			Row currentRow=sheet.getRow(index); 
			int cellCount=currentRow.getLastCellNum();
			for(int cell=0;cell<=cellCount;cell++) {
				if(currentRow.getCell(cell)==null) {
					Cell currentCell=currentRow.createCell(cell);
					currentCell.toString();
				}
				int columnindex=currentRow.getCell(cell).getColumnIndex();
				switch(columnindex) {
				case 0: 
					String str=currentRow.getCell(cell).getStringCellValue();
					loginText(str);
					break;
				case 1: 
					currentRow.createCell(cell).setCellValue(loginPageActualText);
					break;
				case 2:
					currentRow.createCell(cell).setCellValue(loginPageTextResult);
					break;
				case 3: 
					String userNameData=currentRow.getCell(cell).getStringCellValue();
					loginTest_username(userNameData);
					break;
				case 4:
					String passwordData=currentRow.getCell(cell).getStringCellValue();
					loginTest_password(passwordData);
					break;
				case 5:
					String expected_loginHomeText=currentRow.getCell(cell).getStringCellValue();
					loginHomeTextVerify(expected_loginHomeText);
					break;
				case 6:
					currentRow.createCell(cell).setCellValue(ohrmHomePageActualText);
				    break;
				case 7:
					currentRow.createCell(cell).setCellValue(actual_loginHomeTextResult);
				    break;
				case 8:
					String str1=currentRow.getCell(cell).getStringCellValue();
				    loginText(str1);
				    break;
				case 9:
					currentRow.createCell(cell).setCellValue(loginPageActualText);
				    break;
				case 10:
					currentRow.createCell(cell).setCellValue(loginPageTextResult);
				    break;
				default: 
					System.out.println("END");
					break;
				
				}
					
				}	
			}
		FileOutputStream fos=new FileOutputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestData.xlsx");
		workbook.write(fos);
			
		}

	public static void main(String[] args) throws IOException, InterruptedException {
		loginHomePageResults loginHomePage=new loginHomePageResults();
		loginHomePage.browserLaunch();
		loginHomePage.excelOperations();
		loginHomePage.applicationClose();

	}

}
