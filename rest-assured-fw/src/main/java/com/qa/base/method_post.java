package com.qa.base;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class method_post {

	
	@Test
	void test_01() {
	
Map<String,String> body= new HashMap<String, String>();
body.put("name", "morpheus");
body.put("job", "leader");

JSONObject js = new JSONObject();
System.out.println(js.toJSONString(body));
 given()
  	.body(js.toJSONString(body))
  	.when().post("https://reqres.in/api/users").then().statusCode(201);
	
	}
	@Test
	void test_02() {
		RestAssured.baseURI="https://reqres.in/api/users";			
	RequestSpecification rs= RestAssured.given();
 rs.header("content-type","application/json");
 JSONObject js = new JSONObject();
 js.put("name", "morpheus");
 js.put("job", "leader");
 rs.body( js.toJSONString());
 Response rp=rs.request(Method.POST);
System.out.println(rp.getBody());
 rp.getBody().toString().equals("\"name\": \"morpheus\",\r\n" + 
 		"    \"job\": \"leader\",\r\n" + 
 		"    \"id\": \"919\",\r\n" + 
 		"    \"createdAt\": \"2021-10-30T16:52:12.720Z\"\r\n" + 
 		"}");
		 

		
	
	}
}
