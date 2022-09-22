package requestSpecification;

import static io.restassured.RestAssured.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

public class RequestSpecificationBuilder {

	@BeforeClass
	public void beforeClass() {
		RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
		requestSpecBuilder.setBaseUri("https://reqres.in");
		requestSpecBuilder.addHeader("Connection", "keep-alive");

		requestSpecification = requestSpecBuilder.build();
	}

	@Test
	public void validateStatusCode() {
		when().get("/api/users?page=2").then().log().all().assertThat().statusCode(200); // validate status code

	}
}
