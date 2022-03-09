package com.qa.base;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class fakeApi {
	
	@Test
	void getFakeData() {
		RestAssured.baseURI="http://localhost:3000/";
		given().get("employee").then().statusCode(200).log().all();
	}
	@Test
	void AddFakeData() {
		RestAssured.baseURI="http://localhost:3000/";
		JSONObject jb = new JSONObject();
		jb.put("name", "mantu");
		jb.put("id", 12445);
		given().header("content-type","application/json").body(jb.toJSONString()).when().post("employee").then()
.statusCode(201);	
}

@Test
void deleteFakeData() {
	RestAssured.baseURI="http://localhost:3000/employee/";
	JSONObject jb = new JSONObject();
	//jb.put("id", "aKJfDXn");
	given().header("content-type","application/json").when().delete("aKJfDXn").then().statusCode(200);
}
}