package mavenTestProject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//1.create file 
//2. create workbook 
//3. create sheet 
//4. create row 
//5. create cell and set value 
//6. add the workbook in file 
public class WriteInExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+ "\\testData\\newFile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		/*XSSFRow  row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("name");
		row1.createCell(1).setCellValue("age");
		row1.createCell(2).setCellValue("occupation");
		
		XSSFRow  row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("eva");
		row2.createCell(1).setCellValue(28);
		row2.createCell(2).setCellValue("developer");
		*/
		
//		using loop and taking the data from user: 
		
		Scanner scan = new Scanner(System.in);
		
		for(int r = 0; r <=3; r++) {
			XSSFRow row = sheet.createRow(r);
			System.out.println("enter value for row"+ r);
			for(int c = 0; c<2; c++) {
				
				row.createCell(c).setCellValue(scan.next());
				
				
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();


	}

}
