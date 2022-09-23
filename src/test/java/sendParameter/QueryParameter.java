package sendParameter;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class QueryParameter {
	@Test
	public void singleQueryParameter() {
		  given().baseUri("https://reqres.in").queryParams("foo1", "bar1").

				when().get("/api/users?page=2").then().log().all();
		

	}
	
	@Test
	public void multivalueQueryParameter() {
		  given().baseUri("https://reqres.in").queryParams("foo1", "bar1;bar2;bar3").

				when().get("/api/users?page=2").then().log().all();
		

	}
	
	@Test
	public void multipleQueryParameter() {
		HashMap<String, String> queryParams = new HashMap<String, String>();
		queryParams.put("foo1", "bar1");
		queryParams.put("foo2", "bar2");
		  given().baseUri("https://reqres.in").queryParams(queryParams).

				when().get("/api/users?page=2").then().log().all();
		

	}
}
