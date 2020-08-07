package com.datadriven;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_using_dataprovider {
	@DataProvider(name="Dataforpost")
	public Object[][] data() {
		Object[][] data1=new Object[2][3];//This is when we specify the no of elements we want to pass 
		data1[0][0]="a1";
		data1[0][1]="b1";
		data1[0][2]="c1";
		
		data1[1][0]="a2";
		data1[1][1]="b2";
		data1[1][2]="c2";
		
		return data1;
		}
	
	Response response;
	@Test(dataProvider="Dataforpost")
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


	@DataProvider(name="datafordelete")
	public Object[] data3(){
		return new Object[] {"34","35","36"};
		
	}

	@Test(dataProvider="datafordelete")
	public void deletemethod(String s) {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");

		JSONObject js=new JSONObject();
	js.put("id", s);
	request.body(js.toJSONString());
	
response=request.delete("https://www.change2testautomation.com/api/delete.php");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);

		
		
	}
	
}
