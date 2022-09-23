package sendParameter;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class PathParameter {
	@Test
	public void sendPathParameter() {
		  given().baseUri("https://reqres.in").pathParam("userID", "4").

				when().get("/api/users/{userID}").then().log().all(); //you have to pass the userID after url
		

	}
}
