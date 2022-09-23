package sendData;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class MultipartData {
	@Test
	public void sendMultipartData() {
		  given().baseUri("https://reqres.in").multiPart("foo1", "bar1").multiPart("foo2", "bar2").

				when().get("/api/users/{userID}").then().log().all(); //you have to pass the userID after url
		

	}
}
