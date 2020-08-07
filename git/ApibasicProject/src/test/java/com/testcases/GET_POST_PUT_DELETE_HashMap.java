package com.testcases;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_POST_PUT_DELETE_HashMap {
	Response response;
	@Test(priority=1)
	public void postmethod() {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	HashMap<String,Object >map=new HashMap<String,Object>();
	map.put("title", "a23");
	map.put("body", "56");
	map.put("author", "p3");
	request.body(map);
	 /*Gson is a Java library that can be used to convert Java Objects into their JSON representation. 
	 It can also be used to convert a JSON string to an equivalent Java object. 
	 Gson can work with arbitrary Java objects including pre-existing objects that you do not have source-code of.*/
response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}
	
	@Test(priority=2)
	public void putmethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		HashMap<String,Object >map=new HashMap<String,Object>();
		map.put("id", "63");
		
		map.put("author", "p4");
		request.body(map);
		
		response=request.put("https://www.change2testautomation.com/api/update.php");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);
		int statuscode=response.getStatusCode();
		System.out.println("the status code is" + statuscode);
		Assert.assertEquals(statuscode, 200);

		
	}
	@Test(priority=3)
	public void deletemethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");

		HashMap<String,Object >map=new HashMap<String,Object>();
		map.put("id", "63");
		
		
		request.body(map);
	
response=request.delete("https://www.change2testautomation.com/api/delete.php");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);

		
		
	}
	
	@Test
	public void getmethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		response =request.get("http://www.change2testautomation.com/api/read.php");

		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);


		
	}
	
	@Test
	public void getmethod1() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		response =request.get("http://www.change2testautomation.com/api/read.php/id=10");

		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);


		
	}
	
	
	
}
