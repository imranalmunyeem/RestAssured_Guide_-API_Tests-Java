package sendPlayloads;


import static io.restassured.RestAssured.given;

public class URLEncodedRequestPayload {
	public void automate_Form_URL_Encoded_Request_Payload() {
	given().
		baseUri("https://reqres.in").
		formParam("key1", "value1").
		formParam("key2", "value2").
		log().all().
	when().
		post("/post").
	then().
		log().all().
		assertThat().
		statusCode(200);
	}
}
