package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelutils {
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet;
	
	
	
	
	
	public static Object[][] getCellData(String excelpath,String sheetname) throws IOException {
	
		
		
			workbook = new XSSFWorkbook(excelpath);
			//String projectdirectory=System.getProperty(user.dir);
			//String excelpath=projectdirectory+"/TestData/postdata.xlsx";
			//String excelpath="./TestData/postdata.xlsx";
			sheet=workbook.getSheet(sheetname);
			
		
			//String cellvalue=sheet.getRow(1).getCell(0).toString();//it works fine if it is string type data
			
			
		int rowcount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(0).getLastCellNum();
		Object[][] data= new Object[rowcount][cellCount];
		
		for(int i=1;i<=rowcount;i++) {
			for (int j=0;j<cellCount;j++) {
			
				//This is for any type of data
			DataFormatter formatter=new DataFormatter();
			 data[i-1][j]=formatter.formatCellValue(sheet.getRow(i).getCell(j));
			
			}	
		}
		return data;
		
	}}
	


	

