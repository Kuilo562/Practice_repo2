package dDt;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipledatawithExpectedConditon {
	public static void main(String[] args) throws IOException {
		String data1="";
		String data2="";
		String data3="";
//		String data="";
		boolean flag=false;
	
		
		String ExpectedTestCaseid="tc_02";
		FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Org.xlsx");
		Workbook Wb = WorkbookFactory.create(file);
		Sheet sheet = Wb.getSheet("org");
		
int rowcount = sheet.getLastRowNum();
		
		for(int i=0;i<=rowcount;i++) {
			String data="";
			
			try {                         //to handle the nullpointerException We have to use try catch block
			 data = sheet.getRow(i).getCell(0).getStringCellValue();
			 if(data.equals(ExpectedTestCaseid)) {
				 data1 = sheet.getRow(i).getCell(1).getStringCellValue();
				 data2 = sheet.getRow(i).getCell(2).getStringCellValue();
				 data3 = sheet.getRow(i).getCell(3).getStringCellValue();
			}
			}
		catch (Exception e) {}
		
}
//		System.out.println(data);
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		
		//To Check whether Your Test Case is present or not 
//		String ExpectedTestCaseid="tc_100";
//		FileInputStream file = new FileInputStream("C:\\Users\\ATUL SHARMA\\Desktop\\Org.xlsx");
//		Workbook Wb = WorkbookFactory.create(file);
//		Sheet sheet = Wb.getSheet("org");
//		
//int rowcount = sheet.getLastRowNum();
//		
//		for(int i=0;i<=rowcount;i++) {
//			String data="";
//			
//			try {                         //to handle the nullpointerException We have to use try catch block
//			 data = sheet.getRow(i).getCell(0).getStringCellValue();
//			 if(data.equals(ExpectedTestCaseid)) {
//				 flag=true;
//				 data1 = sheet.getRow(i).getCell(1).getStringCellValue();
//				 data2 = sheet.getRow(i).getCell(2).getStringCellValue();
//				 data3 = sheet.getRow(i).getCell(3).getStringCellValue();
//			 }
//			}catch (Exception e) {}
//		
//}
//		if(flag==true) {
//			System.out.println(data1);
//			System.out.println(data2);
//			System.out.println(data3);
//		}
//		else {
//			System.out.println(ExpectedTestCaseid+"data is not available");
//		}
//		
}
}
