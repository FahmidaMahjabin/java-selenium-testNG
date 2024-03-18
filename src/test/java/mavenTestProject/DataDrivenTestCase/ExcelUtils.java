package mavenTestProject.DataDrivenTestCase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFRow row;
	public static XSSFCell col;
	
	public static String getCellData(String fileName, int rowNum , int colNum) throws IOException {
		fi = new FileInputStream(fileName);
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("sheet1");
		XSSFCell col = ws.getRow(rowNum).getCell(colNum);
		String cellData;
		try {
			cellData = col.toString();
		}
		catch(Exception e) {
			cellData = "";
			System.out.println(e);
			
		}
		wb.close();
		fi.close();
		return cellData;
		
		
	}
	
	public static int countRows(String file) throws IOException {
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("sheet1");
		int rowCount = ws.getLastRowNum();
		return rowCount;
		
	}
	
	public static int countCells(String file) throws IOException {
		fi = new FileInputStream(file);
		wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("sheet1");
		int cols = ws.getRow(0).getLastCellNum();
		return cols;
		
		
	}
	public static void setCellData(String xlfile,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("sheet1");
		row=ws.getRow(rownum);
		 col=row.createCell(colnum);
		col.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
				
	}
	

	public static void main(String[] args) {
//		make a function to read cell data . 
		

	}

}
