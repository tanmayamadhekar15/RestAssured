/*
package RestAssuredProject1;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class createRequest {
    @BeforeSuite
    void setUp(){
        System.out.println("Set up");
    }
    */
/*@Test
    void setAuth() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com";

        // Create JSON body
        String jsonBody = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";

        // Send POST request for authentication
        Response response = given()
                .contentType(ContentType.JSON)
                .body(jsonBody)
                .when()
                .post("/auth")
                .then()
                .statusCode(200)
                .extract()
                .response();

        // Extract token from response
        String token = response.jsonPath().getString("token");

        // Print token (optional)
        System.out.println("Token: " + token);

        // Assert that token is not null
        Assert.assertNotNull(token, "Token should not be null");
    }*//*

    @Test
    void post(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="booking";
        String jsonBody = "{ \"username\" : \"admin\", \"password\" : \"password123\" }";
        String userData=
                " \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        given().body(userData).body(jsonBody).when().post().then().log().all().assertThat().statusCode(201);
    }

    @AfterSuite
    void tearDown(){
        System.out.println("Tear down");
    }
}
*/
