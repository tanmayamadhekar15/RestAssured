package RestAssuredProject1.testNG.june_20;

import io.restassured.RestAssured;


public class RA01 {
    public static void main(String[] args) {

       RestAssured.
               given()
               .baseUri("https://restful-booker.herokuapp.com/")
               .basePath("/ping")
               .when().get().
                        then().
                            statusCode(201);

    }
}
