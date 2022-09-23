import java.util.Map;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import pojo.Person;
 
public class ConvertJsonToPojo {
	public static void main(String[] args) throws JsonProcessingException {
		String jsonObject = "{\r\n" + "  \"name\" : \"Amod\",\r\n" + "  \"age\" : 30\r\n" + "}";
		ObjectMapper objectMapper = new ObjectMapper();
		// Deserialize JSON object to POJO Object
		Person person = objectMapper.readValue(jsonObject, Person.class);
		// Once we get Person Object we can use getter method to fetch values
		System.out.println("Name is :" + person.getName());
		System.out.println("Age is  :" + person.getAge());
 
		// Deserialize JSON object to Map Object
		Map&lt;String, Object> personAsMap = objectMapper.readValue(jsonObject, Map.class);
		// Once we get Map Object we can use keys to fetch values
		System.out.println("Name is :" + personAsMap.get("name"));
		System.out.println("Age is  :" + personAsMap.get("age"));
	}
 