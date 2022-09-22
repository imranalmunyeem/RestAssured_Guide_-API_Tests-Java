package requestSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HowToReuseRequestSpecification {
	
	io.restassured.specification.RequestSpecification requestSpecification;
	
	@BeforeClass
	public void beforeClass() {
		requestSpecification = given().
				baseUri("https://reqres.in").
				header("header", "value1");
	}
	
	
	@Test
	public void validstatusCode() {
		
		given().spec((io.restassured.specification.RequestSpecification) requestSpecification).

				when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
	
	
	@Test
	public void validBody() {
		
		given().spec((io.restassured.specification.RequestSpecification) requestSpecification).

				when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
}
