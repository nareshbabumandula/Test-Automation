import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ReadJSON {

    @Test
    public void jsonValue() {

        //base URI with Rest Assured class
        RestAssured.baseURI = "https://run.mocky.io/v3";

        //obtain Response from GET request
        Response res = given()
                .when()
                .get("/8ec8f4f7-8e68-4f4b-ad18-4f0940d40bb7");

        //convert JSON to string
        JsonPath j = new JsonPath(res.asString());

        //get a field value from nested JSON
        String p = j.getString("Items.Price");
        System.out.println("Price is: " + p);
    }

}
