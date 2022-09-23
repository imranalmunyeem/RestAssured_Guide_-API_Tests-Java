package sendData;

import java.io.File;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FileDownloadExample {
	public static long getFileSize() {
		File baseFile = new File("./files/minion.zip");
		return baseFile.length();
	}
	@Test
	void test() {
		byte[] dowloadedFile = RestAssured.given().when()
								.get("https://chercher.tech/files/minion.zip")
								.then().extract().asByteArray();

		System.out.println("Actual File Size : "+getFileSize());
		System.out.println("Download File Size : "+dowloadedFile.length);
		assertEquals(getFileSize(), dowloadedFile.length);
	}
}
