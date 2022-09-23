package sendPlayloads;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class sendXMLFile {

@Test
	public void passXMLFileAsPayload()
	{
		// Creating a File instance 
		File jsonDataInFile = new File("src/test/resources/Payloads/File2.xml");
		
		//GIVEN
		RestAssured
		    .given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				// Since I am passing payload as xml. Anyway it is optional as Rest Assured automatically identifies.
				.contentType(ContentType.XML)
				.body(jsonDataInFile)
		// WHEN
			.when()
				.post()
				// THEN
			.then()
				.assertThat()
				.statusCode(200);
	}
}
