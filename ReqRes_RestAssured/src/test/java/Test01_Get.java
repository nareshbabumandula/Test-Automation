import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

import static org.hamcrest.Matchers.*;

public class Test01_Get {

    @Test
    public void test() {

        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test1() {
        given().get("https://reqres.in/api/users?page=2").then().statusCode(200)
                .body("data.id[0]", equalTo(7))
                .and().body("data.email[0]", equalTo("michael.lawson@reqres.in"));
    }

    @Test
    public void jsonValidations() {
    	
    	//base URI with Rest Assured class
        RestAssured.baseURI = "https://reqres.in";

        //input details
        RequestSpecification reqspec = RestAssured.given();
        //get response
        Response res = reqspec.get("/api/users?page=2");
        
        //Response body
        ResponseBody b = res.getBody();
        
        //convert response body to string
        String responseBody = b.asString();
        
       //JSON Representation from Response Body
       //JsonPath is an alternative to using XPath for easily getting values from a Object document
        JsonPath jsnPath = res.jsonPath();
        String email = jsnPath.get("data.email[0]");
        System.out.println("Email address is : " + email);
        Assert.assertEquals(email, "michael.lawson@reqres.in", "Email is not matching");
       	
    }
    
}