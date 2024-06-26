package RestAssuredProject1.testNG;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC02_CreateXML {

    @Test
    void getToken(){
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().get().
                then().
                statusCode(201);
    }
    @Test
    void getToken1(){
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().get().
                then().
                statusCode(201);
    }
}
