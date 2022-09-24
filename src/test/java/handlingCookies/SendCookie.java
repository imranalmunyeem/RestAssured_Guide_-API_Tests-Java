package handlingCookies;

import org.testng.annotations.Test;

import io.restassured.http.Cookie;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class SendCookie {
	@Test
	public void sendCookieUsingCookieBuilder() {
		Cookie requestCookie = new Cookie.Builder("first_name", "John").setSecured(true).setComment("Example Comment").build();
		Response response = given()
      .baseUri("http://localhost")
      .basePath("api/users")
			.cookie(requestCookie)
			.get("/2");
	}
	
	@Test
	public void sendMultiValueCookie() {
		Response response = given()
				  .baseUri("http://localhost")
				  .basePath("api/users")
				  .cookie("first_name", "William", "Bill")
				  .get("/2");
	}
	
	@Test
	public void sendMultipleCookie() {
		Response response = given()
				  .baseUri("http://localhost")
				  .basePath("api/users")
				  .cookies("first_name", "John", "last_name","Watson")
				  .get("/2");
	}
}