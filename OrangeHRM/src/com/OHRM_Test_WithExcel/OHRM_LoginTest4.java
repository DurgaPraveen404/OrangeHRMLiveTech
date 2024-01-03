package com.OHRM_Test_WithExcel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class OHRM_LoginTest4 extends OHRM_LoginTest3{
	@Test
	public void excelOperations() throws IOException, InterruptedException {
		FileInputStream fis=new FileInputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestDataTestNg.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Sheet2"); 
		int rowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		for(int index=1;index<=rowCount;index++) {
			Row currentRow=sheet.getRow(index); 
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
					String userNameData=currentRow.getCell(cell).getStringCellValue().toString();
					loginTest_username(userNameData);
					break;
				case 4:
					currentRow.getCell(cell).toString();
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
					String Expected_AddEmployeeText =currentRow.getCell(cell).getStringCellValue();
					AddEmployee(Expected_AddEmployeeText);
					break;
				case 9:
					currentRow.createCell(cell).setCellValue(addEmployeePageText);
				    break;
				case 10:
					currentRow.createCell(cell).setCellValue(addEmployeePageResult);
				    break;
				case 11:
					String Expected_EmpFirstName =currentRow.getCell(cell).getStringCellValue();
					emp_FirstName(Expected_EmpFirstName);
					break;
				case 12:
					String Expected_EmpMiddleName =currentRow.getCell(cell).getStringCellValue();
					emp_MiddleName(Expected_EmpMiddleName);
					break;
				case 13:
					String Expected_EmpLastName =currentRow.getCell(cell).getStringCellValue();
					emp_LastName(Expected_EmpLastName);
					break;
				case 14:
					currentRow.createCell(cell).setCellValue(expectedEmpId);
					break;
				case 15:
					String Expected_PersonalPageText=currentRow.getCell(cell).getStringCellValue();
					personal_DetailsPage(Expected_PersonalPageText);
					break;
				case 16:
					currentRow.createCell(cell).setCellValue(personalPageString);
				    break;
				case 17:
					currentRow.createCell(cell).setCellValue(personalPageTextResult);
				    break;
				case 18:
					currentRow.createCell(cell).setCellValue(actualFirstName);
				    break;
				case 19:
					currentRow.createCell(cell).setCellValue(firstNameResult);
				    break;
				case 20:
					currentRow.createCell(cell).setCellValue(actualMiddleName);
				    break;
				case 21:
					currentRow.createCell(cell).setCellValue(middleNameResult);
				    break;
				case 22:
					currentRow.createCell(cell).setCellValue(actualLastName);
				    break;
				case 23:
					currentRow.createCell(cell).setCellValue(lastNameResult);
				    break;
				case 24:
					currentRow.createCell(cell).setCellValue(actualEmpId);
				    break;
				case 25:
					currentRow.createCell(cell).setCellValue(empIdResult);
				    break;
				case 26:
					String str1=currentRow.getCell(cell).getStringCellValue();
				    loginText(str1);
				    break;
				case 27:
					currentRow.createCell(cell).setCellValue(loginPageActualText);
				    break;
				case 28:
					currentRow.createCell(cell).setCellValue(loginPageTextResult);
					
				    break;
				 
				 }
				}
			}
		
		FileOutputStream fos=new FileOutputStream("./src/OrangeHRM_MultipleSetData/OHRM_LogInTestDataTestNg.xlsx");
		workbook.write(fos);
	
}	

}
