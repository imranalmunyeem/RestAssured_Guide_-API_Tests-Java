package pojoConversion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
 
import pojo.Person;
 
public class ConvertPojoToJson {
 
	public static void main(String[] args) throws JsonProcessingException {
		// Create object of Pojo and set values
		Person person = new Person();
		person.setName("Amod");
		person.setAge(30);
		// ObjectMapper class to serialize Pojo object to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		System.out.println("Json Object is :-");
		System.out.println(json);
	}
}