package com.testcases;

import java.io.File;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_usingJsonFile {
	Response response;
	@Test(priority=1)
	public void postmethod() throws FileNotFoundException {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	
	//request.body(new FileInputStream(new File("C://Users//edwin//Desktop//payload.json.txt")));
	request.body(new File("C:\\Users\\edwin\\Desktop\\payload.json.txt"));
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

	}
}
