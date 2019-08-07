package com.restful.jsonserver.exercise;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import com.restful.jsonserver.data.Posts;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PostJsonServerBasicExercise {
	
	// Test#1: Basic Post:
	// Include inside the given body param
	@Test(enabled=false)
	public void basicPost() {	
		Response res = 
		given().
		body("    { \"id\": \"2\","
				+ "\"title\": \"Cleveland\", "
				+ "\"author\": \"Kyrie\" }").
		when().
		contentType(ContentType.JSON).
		post("http://localhost:3000/posts/");
	
		System.out.println(res.asString());
	}
	
	// Test#2: Post: through object creation
	@Test(enabled=false)
	public void objectPost() {	
		Posts posts = new Posts("3", "Seahawks", "Wilson");
		
		Response res = given().
		when().
		contentType(ContentType.JSON).
		body(posts).
		post("http://localhost:3000/posts/");
	
		System.out.println("Response as object: "+res.asString());
	}	
	
	
	// Test#3 Post: checking the contents of body 
	@Test(enabled=false)
	public void createPostCheckBodyContents() {
		Posts posts = new Posts("4", "Packers", "Favre");
		
		given().
		when().contentType(ContentType.JSON).
		body(posts).
		post("http://localhost:3000/posts/").
		then().
		statusCode(201).
		body("id", is(posts.getId())).
		body("title",is(posts.getTitle())).
		body("author",is(posts.getAuthor()));
	}
	
	// Test#4 Post: complete checking the contents of body after posting an api
	@Test(enabled=true)
	public void createCompletePost() {
		Posts posts = new Posts("5", "Lakers", "Horry");
		
		String id =

		given()
		.contentType(ContentType.JSON)
		.body(posts)
		.when()
		.post("http://localhost:3000/posts/")
		.then()
		.statusCode(201)
		.extract()
		.path("id");
		
		given()
		.pathParams("id", id)
		.when().get("http://localhost:3000/posts/{id}")
		.then()
		.statusCode(200)
		.body("id", is(posts.getId()))
		.body("title",is(posts.getTitle()))
		.body("author",is(posts.getAuthor()));
	}
	
}