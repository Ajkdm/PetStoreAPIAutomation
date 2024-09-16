package api.utilities;

import org.testng.annotations.DataProvider;

public class DataProviders
{
	@DataProvider(name="AllData")
	public String[][] getAllData()
	{
		String path=System.getProperty("user.dir")+"//Test Data//TestData1.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		
		int rowCount=xl.getRowCount("Sheet1");
		int colCount=xl.getColCount("Sheet1",1);
		
		String[][] data=new String[rowCount][colCount];
	
		for(int i=0;i<=rowCount;i++) 
		{
			for(int j=0;j<colCount;j++) 
			{
				data[i-1][j]=xl.getCellData("Sheet",i,j);
			}
		}
		return data;
	}
	
	@DataProvider(name="UserName")
	public String[] getUserName()
	{
		String path=System.getProperty("user.dir")+"//Test Data//TestData1.xlsx";
		ExcelUtility xl=new ExcelUtility(path);
		
		int rowNum=xl.getRowCount("Sheet1");
		
		String[] data=new String[rowNum];
	
		for(int i=0;i<=rowNum;i++) 
		{
			data[i-1]=xl.getCellData("Sheet",i,1);
		}
		return data;
	}
}
