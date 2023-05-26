import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Test_07_GetCurrentPrice {

    @Test
    public void test() {

        Response response = RestAssured.get("https://api.coindesk.com/v1/bpi/currentprice.json");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void test1() {
        given().get("https://api.coindesk.com/v1/bpi/currentprice.json").then().statusCode(200)
                .and().body("bpi.GBP.rate", equalTo("16,667.3107"))
                .body("bpi.GBP.description", equalTo("British Pound Sterling"));


    }
}
