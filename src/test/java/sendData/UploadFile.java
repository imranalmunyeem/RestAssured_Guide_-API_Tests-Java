package sendData;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.jupiter.api.Test;

public class UploadFile {
	@Test
	public void uploadFileMultipartFormData() {
		String attributes = "input attributes here";
		  given().baseUri("https://reqres.in").multiPart("file", new File("temp.txt")).multiPart("attributes", attributes,"application/json").
		  
				when().get("/api/users/{userID}").then().log().all(); //you have to pass the userID after url
		

	}
}
