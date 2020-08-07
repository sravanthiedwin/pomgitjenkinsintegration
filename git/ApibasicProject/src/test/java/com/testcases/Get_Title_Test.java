package com.testcases;

import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_Title_Test {
JsonArray responseArray;
Response response;
	@Test
	public void getmethod() {
		RequestSpecification request=RestAssured.given();
		request.header("Content-Type","application/json");
		
		// 1.To get a particular title  from the response using asString
		
		/*response =request.get("http://www.change2testautomation.com/api/read.php");
		
		String respStr = response.asString();
		System.out.println("respStr: "+respStr);
		String[] listOfObjs = respStr.split("}");
		//System.out.println("elementsInObj: "+elementsInObj);
		for(int j=0; j<listOfObjs.length; j++) {
			String[] elementsInObj = listOfObjs[j].split(",");
			for(int k=0;k<elementsInObj.length;k++) {
				if(elementsInObj[k].contains("\"title\":\"edwin\"")) {
					System.out.println("elementsInObj: "+elementsInObj[k].toString());
					System.out.println("KeyValue: "+elementsInObj[k].toString());
				}
			}
		}*/
//2.To get a particular  title from the response using JsonArray and JsonObject
		
		responseArray =request.get("http://www.change2testautomation.com/api/read.php").as(JsonArray.class);
		for(int i=0; i < responseArray.size(); i ++) {
			JsonObject jsonObj = responseArray.get(i).getAsJsonObject();
			if(jsonObj.get("body").getAsString().equals("candy")) {
				System.out.println("Response: "+ jsonObj);
			System.out.println(jsonObj.get("id").getAsString());
			}
		}

	}
	
}
