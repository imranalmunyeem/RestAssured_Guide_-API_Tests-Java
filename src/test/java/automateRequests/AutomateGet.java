package automateRequests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class AutomateGet {
	@Test
	public void validateStatusCode() {
		given().
			baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			log().all().
			assertThat().
			statusCode(200); //validate status code
		
		
	}
	
	
	
	@Test
	public void validateMultipleBodyItems() {
		given().
			baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
			//validate Multiple Body Items
			body("data.first_name",hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel"),"data.last_name",hasItems("Lawson","Ferguson","Funke","Fields","Edwards","Howell"));  
	}
	
	
	
	
	@Test
	public void validateSingleBodyItems() {
		given().
			baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
			//validate Single Body Items
			body("data[0].first_name",equalTo("Michael"));  
	}
	
	
	
	
	@Test
	public void validateID() {
		given().
			baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
			//validate ID
			body("data[0].id",equalTo(7),"data[1].id",equalTo(8),"data[2].id",equalTo(9),"data[3].id",equalTo(10),"data[4].id",equalTo(11),"data[5].id",equalTo(12));
	}
	
	
	
	@Test
	public void extractAllResponse() {
		Response res = given().
				baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
			extract().
			response();
		System.out.println("Response =" + res.asString());
	}
	
	
	
	
	@Test
	public void extractSingleValueFromResponse() {
		String email = given().
				baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").
		then().
			assertThat().
			extract().
			response().path("data[1].email"); // it will fetch the email from index 1 from the body
		
		System.out.println("Single Response =" + email); 
		assertThat(email, equalTo("lindsay.ferguson@reqres.in")); //assert by hamcrest method - have to import that to work
		}
	
	
	
	@Test
	public void logOnlyIfError() {
		given().
			baseUri("https://reqres.in").
		when().
			get("/api/users?page=2").   
		then().
			log().all().
			assertThat().
			statusCode(200); //validate status code
		
		
	}
}
