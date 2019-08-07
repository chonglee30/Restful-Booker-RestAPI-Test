package com.restful.jsonserver.exercise;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.lessThan;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetJsonServerBasicExercise {

	@BeforeClass
	public void init() {
		RestAssured.baseURI ="http://localhost:3000";
	}
	
	// Test#1: Get Requst: return all response as json string.
	// send URL associated with data parameters.
	@Test(enabled=false)
	public void testGetBasicRequest() {
		Response res =
		given().
		when().
			get("/posts/");
		
		System.out.println("Get Response: "+res.asString());
	}
	
	// Test#2: Get Requst: return response if id=3
	@Test(enabled=false)
	public void testGetSpecificIDRequest() {
		Response res =
		given().
		when().
			get("/posts/3");
		
		System.out.println("Get Response: "+res.asString());
	}
	
	// Test#3: Get Requst: return response time
	@Test(enabled=true)
	public void testGetResponseTime() {
		
		Response resp =
		given().
		when().get("/posts/");
		
		Long time =	resp.then().
		extract().
		time();
		
		System.out.println("Elpased Time: "+time);
	}
	
	// Test#4: Ensure less than SLA time
	@Test(enabled=true)
	public void testCheckLessThanSLATime() {
		given().
		when().get("/posts/").
		then().and().
		time(lessThan(1000L));
	}
	
}