import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class ShareDataUsingITestContext {

    @Test
    public void createBooking(ITestContext context)
    {
        int bookingId = RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Jim\",\r\n" +
                        "    \"lastname\" : \"Brown\",\r\n" +
                        "    \"totalprice\" : 111,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2018-01-01\",\r\n" +
                        "        \"checkout\" : \"2019-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .when()
                .post()
                .then()
                .log()
                .all()
                .extract()
                .jsonPath()
                .get("bookingid");
        // Storing data in a context to use for other tests
        context.setAttribute("bookingId", bookingId);
        System.out.println("Created Booking ID is : " + bookingId);
    }

    @Test
    public void updateBooking(ITestContext context)
    {
        // Retrieving required data from context
        int bookingId = (int) context.getAttribute("bookingId");
        System.out.println("Retrieved Booking ID is : " + bookingId);
        RestAssured
                .given()
                .log()
                .all()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/"+bookingId)
                .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .contentType(ContentType.JSON)
                .body("{\r\n" +
                        "    \"firstname\" : \"Amod\",\r\n" +
                        "    \"lastname\" : \"Mahajan\",\r\n" +
                        "    \"totalprice\" : 222,\r\n" +
                        "    \"depositpaid\" : true,\r\n" +
                        "    \"bookingdates\" : {\r\n" +
                        "        \"checkin\" : \"2022-01-01\",\r\n" +
                        "        \"checkout\" : \"2022-01-01\"\r\n" +
                        "    },\r\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\r\n" +
                        "}")
                .when()
                .put()
                .then()
                .log()
                .all();

    }
}
