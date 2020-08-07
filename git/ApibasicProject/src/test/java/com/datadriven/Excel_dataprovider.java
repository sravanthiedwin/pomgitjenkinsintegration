package com.datadriven;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Excelutils;

public class Excel_dataprovider {
/*
How to get test data from excel

Step 1 -Create a function to get Row Count

Step 2 - Create a function to get Column Count

Step 3 - Create a function to get String cell data

Step 4 - Create a function to get Numerical cell data

How to create Excel Data Provider function

Step 1 - Create a new class ExcelDataProvider


Step 2 - Create a function and create object for ExcelUtils

ExcelUtils excel = new ExcelUtils(“excelpath”, “sheetname”);

Step 3 - Get row and column count

int rowCount = excel.getRowCount();
int colCount = excel.getColCount();

Step 4 - Run a loop to get all data in an Object Array


How to use testNG @DataProvider

Step 1
Create a function and provide testNG annotation

@DataProvider(name = “testData”)

Step 2
Call the excel data provider function with excel and sheet name

Step 3
Return the data object

How to get test data from excel

Step 1 Create a function and provide testNG annotation

@Test(dataProvider = “testData”)

Step 2 In the function arguments, get input parameters equal to the parameters in the excel file

Step 3 Use the values in your test*/
	
	
	
	Response response;
	@Test(dataProvider="set of data")
	public void postmethod(String title,String body,String author) {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	JSONObject js=new JSONObject();
	js.put("title",title);
	js.put("body",body);
	js.put("author",author);
	
	request.body(js.toJSONString());
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}
	@DataProvider(name="set of data")
	public Object[][] data2() throws IOException {
		
		Excelutils utils=new Excelutils();
		Object[][] data1=utils.getCellData("C:\\Users\\edwin\\Moneycontrolsworkspace\\phpApiBasicProject\\src\\test\\resources\\TestData\\postdata.xlsx", "Sheet1");
		
		return data1;
	}
		
	}


