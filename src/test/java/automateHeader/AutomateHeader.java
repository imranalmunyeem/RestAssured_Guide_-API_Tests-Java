package automateHeader;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class AutomateHeader {

	@Test
	public void multiple_Header() {
		  given().baseUri("https://reqres.in").header("header", "value1").header("x-key", "value2").

				when().get("/api/users?page=2").then().log().all();
		

	}

	///////// Alternative 1
	@Test
	public void multiple_Header_Using_Object() {
		Header header = new Header("header", "value1");
		Header matchHeader = new Header("x-key", "value2");
		Headers headers = new Headers (header, matchHeader);

		given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
	
	///////// Alternative 2
	@Test
	public void multiple_Header_Using_Hash() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
	
	
	@Test
	public void multi_Value_Header() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		given().baseUri("https://reqres.in").header("value1","value2","value3").

				when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
	
	
	
	@Test
	public void assert_Response_Header() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").
				
				then().log().all().assertThat().statusCode(200).header("responseHeader", "actualHeader"); // validate status code

	}
	
	
	
	@Test
	public void assert_Multiple_Response_Header() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").
				
				then().log().all().assertThat().statusCode(200).headers("responseHeader", "actualHeader","moreheader","moreactualheader"); // validate status code

	}
	
	
	@Test
	public void extract_Header() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		Headers extractedHeaders = given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").
				
				then().log().all().assertThat().statusCode(200).extract().headers(); // validate status code
		
		System.out.println("Headers name:" +extractedHeaders.get("responseHeader").getName());
		System.out.println("Headers value:" +extractedHeaders.get("responseHeader").getValue());

	}
	
	
	
	@Test
	public void extract_All_Header_Using_Loop() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		Headers extractedHeaders = given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").
				
				then().log().all().assertThat().statusCode(200).extract().headers(); // validate status code
		
		for(Header header: extractedHeaders) {
			System.out.println("header name =" + header.getName() +",");
			System.out.println("header value =" + header.getValue());
		}	
	}
	
	
	
	@Test
	public void extract_Multi_Value_Header_Using_List() {
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("header", "value1");
		headers.put("x-key", "value2");
	

		Headers extractedHeaders = given().baseUri("https://reqres.in").headers(headers).

				when().get("/api/users?page=2").
				
				then().log().all().assertThat().statusCode(200).extract().headers(); // validate status code
		
		List<String> values = extractedHeaders.getValues("multiValueHeaders");
		
		for(String value:values) {
			System.out.println(value);
		}	
	}
}
