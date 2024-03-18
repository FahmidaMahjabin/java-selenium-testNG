package mavenTestProject;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") +"\\testData\\login2.xlsx");
		System.out.printf(System.getProperty("user.dir"));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		int totalRows = sheet.getLastRowNum();
		int totalColumn = sheet.getRow(1).getLastCellNum();
		System.out.println("rows:" + totalRows + "cols:"+ totalColumn);
		for(int r = 1; r<= totalRows; r++) {
			XSSFRow rows = sheet.getRow(r);
			for(int c = 0; c< totalColumn; c++) {
				System.out.print(rows.getCell(c).toString() + "   "  );
			}
			System.out.println("");
		}
		workbook.close();
		file.close();

	}
	
	

}
