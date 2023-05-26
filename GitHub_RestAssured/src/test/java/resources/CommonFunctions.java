package resources;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class CommonFunctions {


	public static Logger log = LogManager.getLogger(CommonFunctions.class);
	RequestSpecification reqSpec;
	
	public RequestSpecification requestSpecification() {
		
		 reqSpec = given()
				 .baseUri(AppHooks.prop.getProperty("baseURI"))				 
				 .queryParam("key", AppHooks.prop.getProperty("key"))
				 .queryParam("token", AppHooks.prop.getProperty("token"))
				.contentType(ContentType.JSON);
		 
		 return reqSpec;
	}
	
	public RequestSpecification postRequestSpecification() {
		
		 reqSpec = given()
				 .baseUri(AppHooks.prop.getProperty("baseURI"))
				 .queryParam("idList", AppHooks.prop.getProperty("idList"))
				 .queryParam("key", AppHooks.prop.getProperty("key"))
				 .queryParam("token", AppHooks.prop.getProperty("token"))
				.contentType(ContentType.JSON);
		 
		 return reqSpec;
	}

	
}
