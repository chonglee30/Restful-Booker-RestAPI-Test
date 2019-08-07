package com.restful.jsonserver.exercise;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import com.restful.jsonserver.data.Info;
import com.restful.jsonserver.data.ArrayPost;
import com.restful.jsonserver.data.ComplexPost;
import com.restful.jsonserver.data.Posts;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;

public class PostJsonServerComplexExercise {

	// Test#1: Post with an object
	@Test(enabled=false)
	public void testPostComplexObject() {
		Info info = new Info("zion@no.com","4323230908","222 Saints Street");
		ComplexPost complexPost = new ComplexPost("2","Falcons","Ryan",info);
		
		Response res = 
		given().
		when().contentType(ContentType.JSON).
		body(complexPost).
		post("http://localhost:3000/posts/");
		
		System.out.println(res.asString());
	}
	
	// Test#2: Post with an array of objects
	// Array Info:
	@Test(enabled=true)
	public void testPostArrayObject() {
		Info info1 = new Info("firstEmail","firstPhone#","firstStreet");
		Info info2 = new Info("secondEmail", "secondPhone#", "secondStreet");
		
		ArrayPost arrayPost = new ArrayPost("11", "Champion Title", "MJ", new Info[] {info1, info2});
		
    	Response resp = given().
    	when().
    	contentType(ContentType.JSON).
    	body(arrayPost).
    	post("http://localhost:3001/posts");
    	
    	System.out.println("Response : "+ resp.asString());
	}
	
}