package com.restful.zippo.exercise;

import com.restful.zippo.data.*;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

public class GetZippoSerializationObjectsExercise {

	protected RequestSpecification requestSpec;
	protected ResponseSpecification responseSpec;
	
	// 1) Request Spec: Commonly used URL
	// 2) Response Spec: Commonly used Response 
	@BeforeClass
	public void requestSpecification() {
//		requestSpec = new RequestSpecBuilder().
//				setBaseUri("http://api.zippopotam.us").
//				build();
		//responseSpec = new ResponseSpecBuilder().
//			expectStatusCode(200).
//			expectContentType(ContentType.JSON).
//			build();
	}
	
	@Test
	public void requestZipCodeCheckPlaceNameInResponseBody() {
		Location location = 
				given().
				when().
					get("http://api.zippopotam.us/us/90210").
				as(Location.class);
		
		Assert.assertEquals("Beverly Hills", location.getPlaces().get(0).getPlaceName());
	}
	
	
	
}
