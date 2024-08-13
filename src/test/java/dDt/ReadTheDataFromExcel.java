package dDt;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadTheDataFromExcel {
public static void main(String[] args) throws IOException {
	FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Org.xlsx");
	Workbook Wb = WorkbookFactory.create(file);
	Sheet sheet = Wb.getSheet("org");
	Row Row = sheet.getRow(1);
//	Cell cell = Row.getCell(2);
//	String data = cell.getStringCellValue();
//	double data1 =Row.getCell(3).getNumericCellValue();
	//other way to get numeric value through stringcellvalue we have to store the numeric value like-'200 in excel
	String data2 =Row.getCell(3).getStringCellValue();
	System.out.println(data2);
	
}
}
