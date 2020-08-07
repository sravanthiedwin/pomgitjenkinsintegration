package com.datadriven;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import phpApiBasicProject.Setvalues_Pojo;
import phpApiBasicProject.payload;

public class Datadriven_Pojo {
	@DataProvider(name="Dataforpost")
	public Object[][] data2() {
		
		return new Object[][] {{"title","candy","auth"},
			{"body","taffy","auth2"},
			{"author","c","auth3"},
			{"title","b","auth4"}};
		

	}

	Response response;
	@Test(dataProvider="Dataforpost")
	public void postmethod(String t,String b,String a) {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	Setvalues_Pojo set=new Setvalues_Pojo();
	
	request.body(set.setvalues_datadriven(t, b, a));
	response=request.post("https://www.change2testautomation.com/api/insert.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}
	@DataProvider(name="Dataforput")
	public Object[][] data1() {
		
		return new Object[][] {{"306","author"}};
		
			
		

	}
	@Test(dataProvider="Dataforput")
	public void postmethod(String t,String b) {
	RequestSpecification request=RestAssured.given();
	request.header("Content-Type","application/json");
	
	Setvalues_Pojo set=new Setvalues_Pojo();
	
	request.body(set.setvalues_putdatadriven(t, b ));
	response=request.put("https://www.change2testautomation.com/api/update.php");
	
	String responsebody=response.getBody().asString();
	System.out.println("Response body is: " +responsebody);
	int code=response.getStatusCode();

}


}
