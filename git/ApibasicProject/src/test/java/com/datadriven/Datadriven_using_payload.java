package com.datadriven;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import phpApiBasicProject.payload;

public class Datadriven_using_payload {
	@DataProvider(name="Dataforpost")
	public Object[][] data2() {
		
		return new Object[][] {{"title","candy","auth"},
			{"body","taffy","auth2"},
			{"author","c","auth3"},
			{"title","b","auth4"}};
		

	}

	Response response;
	@Test(dataProvider="Dataforpost")
	public void postmethod(String title,String body,String author) {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	
	request.body(payload.datadriven_post(title, body, author));
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}
	

}
