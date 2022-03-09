package com.qa.base;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class method_get {

	@Test

	void test_01() {
	Response rp=	RestAssured.get("https://reqres.in/api/users?page=2");
	System.out.println(rp.getStatusCode());
	System.out.println(rp.getBody().asString());
	System.out.println(rp.header("content-type"));
	
	assertTrue(rp.getStatusCode()==200);
		
	}
	@Test
	void test_02() {
		given()
		.headers("content-type","application/json")
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.id[0]",equalTo(7))
		.body("data.first_name", hasItems("Lindsay","Tobias","Michael"));
	}
	}

