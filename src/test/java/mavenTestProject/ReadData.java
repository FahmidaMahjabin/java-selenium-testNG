package mavenTestProject;


import java.io.FileInputStream;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ReadData {

	private XSSFSheet sheet;
	public ReadData(String filename)
	{
		try {
		String filepath=".//testdata//"+filename+".xlsx";
		FileInputStream instream = new FileInputStream(filepath);
		XSSFWorkbook workbook = new XSSFWorkbook(instream);
		 sheet=workbook.getSheet("Sheet1");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String getData(int rowNum,int colNum)
	{
		return sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	}
	
	
	public List<String> getData(int rowNum)
	{
		int cellsCount=sheet.getRow(rowNum).getLastCellNum();
		List<String> rowData= new ArrayList<String>();
		for(int i=0;i<cellsCount;i++)
		{
			rowData.add(sheet.getRow(rowNum).getCell(i).getStringCellValue());
		}
		return rowData;
	}
	
	public String[][] getData()
	{		
		int rowsCount=sheet.getLastRowNum();
		System.out.println(rowsCount);
		
		int cellsCount=sheet.getRow(0).getLastCellNum();
        String data[][] = new String[rowsCount][cellsCount];
        System.out.println(cellsCount);
        int l = 0;
        for(int i=1;i<=rowsCount;i++)
        {
        	
        	for(int j=0;j<cellsCount;j++)
        	{
        		String value =sheet.getRow(i).getCell(j).getStringCellValue();
        	       data[l][j]=value;
        	       
        	}
        	l++;
        	
        }
      return data;  
	}
	
	
	
	public static void main(String[] args) {
		   ReadData read = new ReadData("login2");
		   String data[][]=read.getData();
		   for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j]+"    ");
			}
			System.out.println();
		}
	}
	
	
	
}
