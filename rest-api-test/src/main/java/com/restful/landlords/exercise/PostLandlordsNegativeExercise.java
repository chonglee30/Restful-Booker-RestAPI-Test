package com.restful.landlords.exercise;

import io.restassured.response.*;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import com.restful.jsonserver.data.Posts;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import com.restful.jsonserver.data.LandLord;

public class PostLandlordsNegativeExercise {
	
	@BeforeClass
	public void init() {
		RestAssured.baseURI = "http://localhost:8080/swagger";
	}
	
	//Test#1: Missing 2 required fields: 
	@Test(enabled=true) 
	public void missingTwoRequiredFieldsTest() {
		
		LandLord landLord = new LandLord("","");
		
		given()
			.contentType(ContentType.JSON)
			.body(landLord)
		.when()
			.post("/landlords")
		.then()
			.statusCode(405)
			.body("message",is("Request method 'POST' not supported"))
			.body("fieldErrorDTOs[0].fieldName", is("firstName"));
//			.body("fieldErrorDTOs[0].fieldError",is("First name can not be empty"))
//			.body("fieldErrorDTOs[1].fieldName", is("lastName"))
//			.body("fieldErrorDTOs[1].fieldError",is("Last name can not be empty"));	
	}
	
}
