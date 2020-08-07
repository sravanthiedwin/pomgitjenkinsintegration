package com.datadriven;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_dataprovider {
	
	@DataProvider(name="set of data")
	public Object[][] data2() {
		
		return new Object[][] {{"title","candy","auth"},
			{"body","taffy","auth2"},
			{"author","c","auth3"},
			{"title","b","auth4"}};
		
		
		
	}
	
	@DataProvider(name="datafordelete")
	public Object[] data3(){
		return new Object[] {"34","35","36"};
		
	}
	
	
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
