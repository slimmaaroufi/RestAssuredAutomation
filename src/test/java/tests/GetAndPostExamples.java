package tests;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.RestAssuredMatchers.*;

public class GetAndPostExamples {

	//@Test
	public void testGet() {
		
		baseURI = "https://reqres.in/api";
		
		given().
			get("/users?page=2").
		then().
			statusCode(200).
		body("data[2].first_name",equalTo("Tobias")).
		body("data.first_name",hasItems("Tobias","Byron","George"));
	}

	//1ere methode	

	//@Test
	//public void testPost() {
		/*pour creer une collection de valeur */
//		Map<String, Object> map =new HashMap<String, Object>();
//		map.put("name", "slim");
//		map.put("job", "Informaticien");
//		System.out.println(map);
//		JSONObject request =new JSONObject(map);
//		System.out.println(request);
//	}

	//	2eme methode
	
	@Test
	public void testPost() {
		Map<String, Object> map =new HashMap<String, Object>();
		JSONObject request =new JSONObject();
		request.put("name", "slim");
		request.put("job", "Informaticien");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api";
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201)
			.log().all();
		
		
	}
}		
