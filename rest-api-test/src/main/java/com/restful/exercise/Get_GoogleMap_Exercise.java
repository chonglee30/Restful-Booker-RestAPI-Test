package com.restful.exercise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get_GoogleMap_Exercise {
	
	@Test
	public void test() {
		
		//System.out.println("Test ");
		RestAssured.baseURI = "https://maps.googleapis.com";
		
		given().
				param("location","-33.8670522,151.1957362").
				param("radius","1500").
				param("key","AIzaSyDIQgAh0B4p0SdyYkyW8tlG-y0yJMfss5Y").
		when().
				get("/maps/api/place/nearbysearch/json").
		then().assertThat().
		statusCode(200).and().
		contentType(ContentType.JSON).and().
		body("results[0].name", equalTo("Sydney")).and().
		body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		header("Server","scaffolding on HTTPServer2");
		//body("results[0].geometry.location.lat",equalTo("-33.8688197"));
				
	}
}
