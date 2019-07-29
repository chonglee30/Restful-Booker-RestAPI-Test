package com.restful.zippo.exercise;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import org.testng.annotations.Test;
	
public class GetZippoBasicFeaturesExercise {
	
	// Test1: Check for status code
	@Test
	public void checkResponseStatusCode() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().
			statusCode(200);
	}
	
	// Test2: Check for content type
	@Test
	public void checkResponseContentType() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().
			contentType(ContentType.JSON);  // or application/json
	}

	// Test3: Check for Request Log
	@Test(enabled=false)
	public void checkRequestLog() {
		given().
			log().all().
		when().
			get("http://api.zippopotam.us/us/90210");
	}
	
// Request Log:
//		Request method:	GET
//		Request URI:	http://api.zippopotam.us/us/90210
//		Proxy:			<none>
//		Request params:	<none>
//		Query params:	<none>
//		Form params:	<none>
//		Path params:	<none>
//		Headers:		Accept=*/*
//		Cookies:		<none>
//		Multiparts:		<none>
//		Body:			<none> 
	
	// Test4: Check for Response Log
	@Test(enabled=false)
	public void checkResponseLog() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			log().all();
	}	
	
// Response Log:
//		HTTP/1.1 200 OK
//		Date: Sat, 27 Jul 2019 20:28:58 GMT
//		Content-Type: application/json
//		Transfer-Encoding: chunked
//		Connection: keep-alive
//		Set-Cookie: __cfduid=d82339cef42ef3b0df647e8d21664cf0e1564259338; expires=Sun, 26-Jul-20 20:28:58 GMT; path=/; domain=.zippopotam.us; HttpOnly
//		X-Cache: hit
//		Charset: UTF-8
//		Vary: Accept-Encoding
//		Access-Control-Allow-Origin: *
//		Server: cloudflare
//		CF-RAY: 4fd15ce0d84f3b5a-YVR
//		Content-Encoding: gzip
//
//		{
//		    "post code": "90210",
//		    "country": "United States",
//		    "country abbreviation": "US",
//		    "places": [
//		        {
//		            "place name": "Beverly Hills",
//		            "longitude": "-118.4065",
//		            "state": "California",
//		            "state abbreviation": "CA",
//		            "latitude": "34.0901"
//		        }
//		    ]
//		}
	
	// Test5: Check for Places: Place Name
	@Test
	public void requestZipCodeCheckPlaceNameInResponseBody() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().
			body("places[0].'place name'", equalTo("Beverly Hills"));
	}
	
	// Test6: Check for Places:State
	@Test
	public void requestZipCodeCheckStateInResponseBody() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().
			body("places[0].'state'", equalTo("California"));
	}	
	
	// Test7: Check for country
	@Test
	public void requestZipCodeCheckCountryInResponseBody() {
		given().
		when().
			get("http://api.zippopotam.us/us/90210").
		then().
			assertThat().
			body("country", equalTo("United States"));
	}	
	
	// Test8: Check for size of place name 
	@Test
    public void requestZipCodeCheckNumberOfPlaceNamesInResponseBody() {
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasSize(1));
    }
	
	// Test9: Check for place name contains Beverly Hills 
	@Test
    public void requestUsZipCode90210_checkListOfPlaceNamesInResponseBody_expectContainsBeverlyHills() {
        given().
        when().
            get("http://zippopotam.us/us/90210").
        then().
            assertThat().
            body("places.'place name'", hasItem("Beverly Hills")); // Invert: not()
    }
		
//  {"post code": "90210", 
//	 "country": "United States", 
//	 "country abbreviation": "US", 
//	 "places": [
//    {"place name": "Beverly Hills", 
//	   "longitude": "-118.4065", 
//     "state": "California", 
//     "state abbreviation": "CA",
//     "latitude": "34.0901"}]}
//	
	
}