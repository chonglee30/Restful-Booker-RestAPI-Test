package com.restful.zippo.exercise;

import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetZippoOptimizingExercise {

	protected RequestSpecification requestSpec;
	protected ResponseSpecification responseSpec;
	
	// 1) Request Spec: Commonly used URL
	// 2) Response Spec: Commonly used Response 
	@BeforeClass
	public void requestSpecification() {
		requestSpec = new RequestSpecBuilder().
				setBaseUri("http://api.zippopotam.us").
				build();
		responseSpec = new ResponseSpecBuilder().
			expectStatusCode(200).
			expectContentType(ContentType.JSON).
			build();
	}
	
	// Test: Request only specify country code and zipcode
	// Test: Response only specify places: place name
	@Test
	public void checkResponseStatusCodeWithSpec() {
		
		String placeName = 
		given().
			spec(requestSpec).
		when().
			get("us/90210").
		then().
			spec(responseSpec).
			extract().
			path("places[0].'place name'");

		Assert.assertEquals("Beverly Hills", placeName);
	}
}