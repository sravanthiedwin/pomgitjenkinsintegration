package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExeclReader {
	
	public void getdata(String excelpath,String Sheetname) throws IOException {
		
	
	
	FileInputStream fis=new FileInputStream(excelpath);//its aclass in java ability to read data from excel
	
	XSSFWorkbook workbook=new XSSFWorkbook(fis);//XSSFWorkbook is a class and we are creating an object
	int sheets=workbook.getNumberOfSheets();
	for(int i=0;i<sheets;i++) {
		if(workbook.getSheetName(i).equalsIgnoreCase(Sheetname)) {
			XSSFSheet sheet=workbook.getSheetAt(i);
	Iterator<Row>rows=sheet.iterator();//every sheet is collection of rows
	
	Row firstrow=rows.next();//first row (headers)
	
	Iterator<Cell> ce=firstrow.cellIterator();//every row is collection of cells
	int k=0;
	int column=0;
	while(ce.hasNext()) {
		Cell value=ce.next();
		if(ce.next().getStringCellValue().equalsIgnoreCase("column name")) {
			
			column=k;
		}
		k++;
	}
	
		}
	}
	

}}
