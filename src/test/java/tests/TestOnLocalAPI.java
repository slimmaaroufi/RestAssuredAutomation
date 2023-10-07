package tests;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;


public class TestOnLocalAPI {
	
	//@Test
	public void get() {
		baseURI= "http://localhost:3000";
	given().
		get("/users").
	then().
		statusCode(200).log().all();
		
	}
	//@Test
	public void post() {
		/*creation d'un nouveau utilisateur*/
		/* declaration de l'objet json */
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Slim");
		request.put("lastName", "testing");
		request.put("subjectId", 1);
		
		baseURI= "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).log().all();
		
		
	}
	
	
	//@Test
	public void put() {
		/*mettre à jour nouveau utilisateur*/
		/* declaration de l'objet json */
		JSONObject request = new JSONObject();
		
		request.put("firstName", "maaroufi");
		request.put("lastName", "bordeaux");
		request.put("subjectId", 2);
		
		baseURI= "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/6").
		then().
			statusCode(200).log().all();
		
		
	}
	
		
	//@Test
	/*mettre à jour certains données particulieres  pour nouveau utilisateur*/
	public void patch() {
		/*mettre à jour nouveau utilisateur*/
		/* declaration de l'objet json */
		JSONObject request = new JSONObject();
		
		
		request.put("lastName", "DOE");
		
		
		baseURI= "http://localhost:3000";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/users/6").
		then().
			statusCode(200).log().all();
		
		
	}
	
	
	@Test
		/*supprimer un nouveau utilisateur*/
		public void delete() {

		baseURI= "http://localhost:3000";
		when().
			delete("/users/6").
		then().
			statusCode(200);
			
		}
	
	
	
}
