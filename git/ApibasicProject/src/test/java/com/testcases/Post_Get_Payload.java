package com.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import phpApiBasicProject.payload;

public class Post_Get_Payload {
	
	Response response;
	@Test(priority=1)
	public void postmethod() {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	request.body(payload.postpayload());
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}

	@Test(priority=2)
	public void putmethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		
		request.body(payload.putpayload());
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

		
	request.body(payload.deletepayload());
	
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
