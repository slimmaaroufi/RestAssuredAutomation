package tests;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;;

public class SoapXMLRequest {
	
	@Test
	public void validateSoapXML() throws IOException {
		
		/*recupere le fichier dans le code pour que je puisse utiliser le flux d'entree de fichier */
		
		File file = new File("./SoapRequest/Add.xml");
		
		if(file.exists())
			System.out.println(" File Exists");
		
		
		FileInputStream fileInputStream = new FileInputStream(file);
		
		String requestBody = IOUtils.toString(fileInputStream, "UTF-8");
		System.out.println(requestBody);
		baseURI = "http://www.dneonline.com";
					
		given().
			contentType("text/xml").
			accept(ContentType.XML).
			body(requestBody);
		when().
			post("/calculator.asmx").
		then().
			statusCode(200).log().all().
			and().body("//*:AddResult.text()", equalTo("3"));
		
/*  2eme methodetest avec nejib*/	
		
		
	//declaration variable
	//	String requestBody1 = Files.readString(Paths.get("./SoapRequest/Add.xml")); 
	//	System.out.println(requestBody1);
		
	}
	
	

}
