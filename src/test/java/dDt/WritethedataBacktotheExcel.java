package dDt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritethedataBacktotheExcel {
	public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Tek3.xlsx");
	Workbook Wb = WorkbookFactory.create(file);
	Sheet sheet = Wb.getSheet("sheet1");
	Row row = sheet.getRow(1);
//	String vlue = row.getCell(2).getStringCellValue();
//	System.out.println(vlue);
	Cell cel = row.createCell(4);
	cel.setCellType(CellType.STRING);
	cel.setCellValue("hulk");
	FileOutputStream fos = new FileOutputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Tek3.xlsx");
	Wb.write(fos);
	Wb.close(); 
	
}
}
