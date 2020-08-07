package com.datadriven;

import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Datadriven_using_parmeters {
	
	Response response;
	
	//Run from testng.xml 
	@Parameters({"id"})
	@Test()
	public void deletemethod(String id) {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");

		JSONObject js=new JSONObject();
	js.put("id", id);
	request.body(js.toJSONString());
	
response=request.delete("https://www.change2testautomation.com/api/delete.php");
		
		String responsebody=response.getBody().asString();
		System.out.println("Response body is: " +responsebody);

		
		
	}

}
