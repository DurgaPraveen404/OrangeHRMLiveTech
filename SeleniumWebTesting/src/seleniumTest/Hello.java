package seleniumTest;

public class Hello{
	//user defined method can be created in a java class
	//user defined method thought created in a java class-will not get executed by themself
	//a java class can have any number of user defined methods
	//to perform the operation related to user defined than an Object should be created in 
	//the main method for the class -and using the object created the User defined
	//method should be called
	//User defined method should never be created within the main method 
	//a java class can have any number of user defined methods even without a main method
	//user defined methods either can be created above the main method or below the main method
	//only the user defined methods called in the main method will be executed 
	//User defined method names should be always be unique
	
	public void addition()
	{
		int var1=20;
		int var2=30;
		int var3;
		
		var3=var1+var2;
		System.out.println("the value of the variable nar3 after Addition is :-"+var3);
	}
	public static void main1(String[]args) {
		
		Hello m2= new Hello();
		m2.addition();
		
		m2.subtraction();
	}
	public  void subtraction()
	{
		int var1=20;
		int var2=30;
		int var3;
		
		var3=var1-var2;
		System.out.println("the value of the variable nar3 after Subtraction is:-"+var3);
	}
			
		



	public static void main(String[] args) {
		
		
		
		/*FilelnPutStream multiple TestdataFile=new filelnputStream("./src/com/ExceTestFiles/multiple Testdata.xlsx");
		
		XXSSFworkbook workbook=new XSSFWork(multiple TestDataFile);
		
		XSSFSheet testdataSheet=workbook.getSheet("multiple Testdata");
		//IN the sheet identifying The number of active rows with the data
		int rowscount=testdataSheet.getLastRowsNum();
		//Should go automatically to every Active Row 
		for(int rowIndex=0;rowIndex<=RowsConnt;rowIndex++)
		{
			//Should go to an active Row
			Row row=testDataSheet,getRow(rowlndex);
			//Going to an active Row and identifying the number of number of active Cells
			int rowofCellCount=row,getLastcellNUM();
			//going to an active row to all its active cells
			for(int rowofCellIndex=0;rowOfcellIndex<rowOfcellcount;rowofcellIndex++);
			
			*/
					
			
			
		}
		
		// TODO Auto-generated method stub

	}


