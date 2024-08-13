package dDt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultiplteDataFromEXcel {
	public static void main(String[] args) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Org.xlsx");
		Workbook Wb = WorkbookFactory.create(file);
		Sheet sheet = Wb.getSheet("Product");
//		Row row = sheet.getRow(1);
//		String column1Data = row.getCell(0).toString();
//		String column2Data = row.getCell(1).toString();
//		System.out.println(column1Data);
//		System.out.println(column2Data);
//		System.out.println(column1Data+"\t"+column2Data);
		
		
		
		//To read all the data present in excel
//		for(int i=1;i<50.;i++) {
//			Row row = sheet.getRow(i);
//			String column1Data = row.getCell(0).toString();
//			String column2Data = row.getCell(1).toString();
//			System.out.println(column1Data+"\t"+column2Data);
//		}
		//instead of hardcore the data we can use getlastRow()
		int rowcount = sheet.getLastRowNum();
		
		for(int i=1;i<=rowcount;i++) {
			Row row = sheet.getRow(i);
			String column1Data = row.getCell(0).toString();
			String column2Data = row.getCell(1).toString();
			System.out.println(column1Data+"\t"+column2Data);
		}
		
		Wb.close();
}

}