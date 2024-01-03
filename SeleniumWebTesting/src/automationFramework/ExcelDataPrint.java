package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataPrint {

	public static void main(String[] args) throws IOException {
		
		FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet2=workbook.getSheet("sheet1");
		int rowCount=sheet2.getLastRowNum()+1;
		System.out.println(rowCount);
		int cellCount=sheet2.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		for(int currentRow=0;currentRow<rowCount;currentRow++) {
			for(int currentCell=0;currentCell<cellCount;currentCell++) {
				
				System.out.print(sheet2.getRow(currentRow).getCell(currentCell).toString());
				System.out.print("\t");
			}
			System.out.println();
		}

	}

}
