import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
public class ResponseHeaderReader {
    @Test
    public void ressponseAssertion() {

        //base URL
        RestAssured.baseURI = "https://run.mocky.io";

        //GET operation
        given() .when().get("/v3/6c6ed634-5e78-4b80-94c7-cf17c04c7055").
        then().log().all()

        //verify status code as 200
        .assertThat().statusCode(200)

        //verify body
        .body("Location", Matchers.equalTo("Makinac Island"))

        //verify header
        .header("Content-Length" , "57");
    }
}

