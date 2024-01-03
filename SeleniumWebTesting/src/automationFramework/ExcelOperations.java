package automationFramework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("./src/ExcelFile/LivetechExcel.xlsx");
		// TODO Auto-generated method stub
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet2=workbook.createSheet("LiveTech1");
		Row secondRow=sheet2.createRow(2);
		Cell secondCell=secondRow.createCell(2);
		secondCell.setCellValue("LiveTech1");
		FileOutputStream fos=new FileOutputStream("./src/ExcelFile/LivetechExcel.xlsx");
		workbook.write(fos);
		/*XSSFSheet sheet1=workbook.getSheet("sheet1");
		Row sheet1Row=sheet1.getRow(0);
		Cell RowOfCell=sheet1Row.getCell(0);
		
		System.out.println(RowOfCell);
		*/

	}

}
