package com.restful.exercise;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class Post_GoogleMap_Exercise {

	private String placeID;
	
	public void setPlaceID(String id) {
		placeID = id;
	}
	
	public String getPlaceID() {
		return placeID;
	}
	
	// Post API:
	@Test
	public void postGoogleMapTest() {
		
		String postBody ="{"+
				  "\"location\": {"+
				    "\"lat\": -33.8669710,"+
				    "\"lng\": 151.1958750"+
				  "},"+
				  "\"accuracy\": 50,"+
				  "\"name\": \"Google Shoes!\","+
				  "\"phone_number\": \"(02) 9374 4000\","+
				  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
				  "\"types\": [\"shoe_store\"],"+
				  "\"website\": \"http://www.google.com.au/\","+
				  "\"language\": \"en-AU\""+
				"}";
		
		RestAssured.baseURI="http://216.10.245.166";
		
		Response postResponse = 
		given().
		queryParam("key","qaclick123").
		body(postBody).
		when().
		post("/maps/api/place/add/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK")).
		extract().response();
		
		// Response -> String
		// String -> JSon
		String responseString = postResponse.asString();
		System.out.println(responseString);
		JsonPath jPath = new JsonPath(responseString);
		
		//placeID = jPath.getString("place_id");
		//System.out.println("Place ID: "+placeID);
		setPlaceID(jPath.getString("place_id"));
		System.out.println("Place ID: "+getPlaceID());
	}
	
	// Delete API:
	@Test
	public void deletePostAPI() {
		RestAssured.baseURI="http://216.10.245.166";
		
		System.out.println("Delete Previously Created API: "+getPlaceID());
		given().
		queryParam("key", "qaclick123").
		body("{"+
		"\"place_id\": \""+getPlaceID()+"\""+
		"}").
		when().
		post("/maps/api/place/delete/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("status",equalTo("OK"));		
	} 
	
	
}
