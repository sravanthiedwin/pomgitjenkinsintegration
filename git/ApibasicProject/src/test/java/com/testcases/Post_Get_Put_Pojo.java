package com.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import phpApiBasicProject.Setvalues_Pojo;
import phpApiBasicProject.payload;

public class Post_Get_Put_Pojo {
	Response response;
	@Test(priority=1)
	public void postmethod() {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	Setvalues_Pojo set=new Setvalues_Pojo();
	
	request.body(set.setvalues());
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}
	

	@Test(priority=2)
	public void putmethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		
		Setvalues_Pojo set=new Setvalues_Pojo();
		
		request.body(set.setvalues_put());
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

		
		Setvalues_Pojo set=new Setvalues_Pojo();
		
		request.body(set.setvalues_delete());
	
response=request.delete("https://www.change2testautomation.com/api/delete.php");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);

		
		
	}

}
