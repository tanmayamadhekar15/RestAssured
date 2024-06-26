/*
package RestAssuredProject1;

import io.restassured.RestAssured;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getRequest {

    @BeforeSuite
    void setUp(){
        System.out.println("Set up");
    }

    @Test
    void get(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        RestAssured.basePath="booking";
        given().when().get().then().log().all().statusCode(200);
    }

    @AfterSuite
    void tearDown(){
        System.out.println("Tear down");
    }

}
*/
