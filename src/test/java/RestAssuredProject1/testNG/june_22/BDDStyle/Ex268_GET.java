package RestAssuredProject1.testNG.june_22.BDDStyle;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Ex268_GET {
    // Two ways to create testcases
    /*
    1. BDD style : Given, when, then
    2. Non BDD style : Class  and Object
     */

    /*
    // GET Request - https://api.zippopotam.us/IN/{pincode}
    // URL - https://api.zippopotam.us
    // Path - /in/{pincode}
    // HEADER ?
    // GET Method
    // base url = https://api.zippopotam.us
    // basePath = /IN/560037
    // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No
    // Payload - ? NO


    // Verification
    // Status Code
    // Response Body
    // Time, Headers ,Cookies


    // BDD Style - Given, when, then
     */
    // given ->
    // URL
    // HEADER ?, Cookies
    // base url = https://api.zippopotam.us
    // basePath = /IN/560037
    // Auth - Basic, Digest, JWT, Bearer Token, OAuth 2.0 ? = No

    // When  ->
    // PaYLOAD - ? NO/yES - JSON. XML  -> String, Hashmap, Object class
    // GET Method

    // Then()
    // Response Validation
    //  Status Code
    //  Response Body
    //  Time, Headers ,Cookies


    @Test
    public void getRequestBDDStyle() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);


    }

    @Test
    public void getRequestBDDStyle2() {
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/560037")

                .when().log().all().get()

                .then()
                .log().all()
                .statusCode(200);
    }
}