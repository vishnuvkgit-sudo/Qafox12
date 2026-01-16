package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Test.xlsx"; //taking xl file from testData

		
		ExcelUtility xlutil = new ExcelUtility(path); //creating an object  for utility
		
		int totalRows = xlutil.getRowCount("Sheet2");	
	    int totalCells = xlutil.getCellCount("Sheet2",1);
	    
	    String loginData[][]=new String[totalRows][totalCells]; //created for 2-d array which can store
	    
	    for(int i=1;i<=totalRows;i++) //1 //read data from xl storing 2-d array
	    {
	    	for(int j=0;j<totalCells;j++) //0	i is rows j is cols
	    	{
	    		loginData[i-1][j] = xlutil.getCellData("Sheet2",i, j); //1,0
	    	}
	    }
	    return loginData;  //returning 2-d array
	}

}
