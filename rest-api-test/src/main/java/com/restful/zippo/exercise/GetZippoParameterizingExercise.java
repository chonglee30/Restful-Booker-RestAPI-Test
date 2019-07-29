package com.restful.zippo.exercise;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class GetZippoParameterizingExercise {

	@DataProvider(name="getZipCodesAndPlaces")
	public Object[][] getZipCodesAndPlaces() {
		return new Object[][] {
			{"us","90210","Beverly Hills"},
			{"us","12345","Schenectady"},
			{"ca","B2R","Waverley"}
		};
	}
	
	@Test(dataProvider="getZipCodesAndPlaces")
	public void checkForPlacesWithParameterizing(String countryCode, String zipCode, String expectedPlaceName) {
		given().
			pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
		when().
			get("http://api.zippopotam.us/{countryCode}/{zipCode}").
		then().
			assertThat().
			body("places[0].'place name'", equalTo(expectedPlaceName));
	}	
}