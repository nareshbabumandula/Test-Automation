package com.restassured.interview;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import junit.framework.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CRUDdOperationsExampleWithExtentReports {
	static ExtentTest test;
	static ExtentReports report;

    @BeforeClass
    public void setup() {
        // Initialize ExtentReports and ExtentHtmlReporter
    	// Extent Reports
		report = new ExtentReports("./target/ExtentReport/ExtentResults.html");
		test = report.startTest("Test CRUD operations using RestAssured");
    }

    @AfterClass
    public void teardown() {
        report.endTest(test);
		report.flush();
    }

    @Test
    public void testCRUDOperations() {
        // Set base URI of the API
        RestAssured.baseURI = "https://reqres.in/";

        // Create
        Response createResponse = createResource();
        test.log(LogStatus.INFO, "Create Response: " + createResponse.getBody().asString());

        // Read
        Response readResponse = readResource();
        test.log(LogStatus.INFO, "Read Response: " + readResponse.getBody().asString());

        // Update
        Response updateResponse = updateResource();
        test.log(LogStatus.INFO, "Update Response: " + updateResponse.getBody().asString());

        // Delete
        Response deleteResponse = deleteResource();
        test.log(LogStatus.INFO, "Delete Response: " + deleteResponse.getStatusCode());

        // Assert the responses or perform any other validation as required
        // ...

        // Log the test result
        test.log(LogStatus.PASS, "CRUD operations executed successfully");
    }

    private Response createResource() {
        // Define the request specification
        RequestSpecification requestSpec = RestAssured.given();

        // Set the request body
        String requestBody = "{\r\n"
        		+ "    \"name\": \"morpheus\",\r\n"
        		+ "    \"job\": \"leader\"\r\n"
        		+ "}";
        requestSpec.body(requestBody);

        // Set the content type header
        requestSpec.contentType(ContentType.JSON);

        // Send POST request to create the resource
        Response response = requestSpec.post("/api/users");

        return response;
    }

    private Response readResource() {
        // Send GET request to read the resource
        Response response = RestAssured.get("/api/users?page=2", 1);

        return response;
    }

    private Response updateResource() {
        // Define the request specification
        RequestSpecification requestSpec = RestAssured.given();

        // Set the request body
        String requestBody = "{\r\n"
        		+ "    \"name\": \"morpheus\",\r\n"
        		+ "    \"job\": \"zion resident\"\r\n"
        		+ "}";
        requestSpec.body(requestBody);

        // Set the content type header
        requestSpec.contentType(ContentType.JSON);

        // Send PUT request to update the resource
        Response response = requestSpec.put("/api/users/2", 1);

        return response;
    }

    private Response deleteResource() {
        // Send DELETE request to delete the resource
        Response response = RestAssured.delete("/api/users/2", 1);

        return response;
    }
}
