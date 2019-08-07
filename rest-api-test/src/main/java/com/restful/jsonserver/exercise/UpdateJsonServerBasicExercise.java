package com.restful.jsonserver.exercise;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import com.restful.jsonserver.data.Posts;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;

public class UpdateJsonServerBasicExercise {

	// Test#1: Basic Put:
	@Test(enabled=false)
	public void basicPut() {
		
		Posts updatedPosts = new Posts();
		//posts.setId("3");
		updatedPosts.setTitle("Seahawks Quaterback");
		updatedPosts.setAuthor("Russuel Wilson");
		
		Response res =
		given().
		when().contentType(ContentType.JSON).
		body(updatedPosts).
		put("http://localhost:3000/posts/3");
		
		
		System.out.println(res.asString());
	}
	
	// Test#2: Basic Patch:
	@Test(enabled=false)
	public void basicPatch() {
		
		Response resp =
		given().
		body("{\"title\":\"Seattle Seahawks QB\"}").
		when().contentType(ContentType.JSON).
		patch("http://localhost:3000/posts/3");
		
		System.out.println("Patch Request: "+resp.asString());
	}
	
	// Test#3: Basic Delete:
	@Test(enabled=true)
	public void basicDelete() {
		
		Response resp =				
		given().
		when().
		delete("http://localhost:3000/posts/2");
		
		System.out.println("Delete Request: "+resp.asString());
	}
	
}