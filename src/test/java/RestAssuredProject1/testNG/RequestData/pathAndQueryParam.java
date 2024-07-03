package RestAssuredProject1.testNG.RequestData;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class pathAndQueryParam {

    //URL : https://reqres.in/api/users?page=2&id=5
    // Query param goes automatically with request, no need to add in request.
    //Only query param help to filter
    @Test
    void parameterType(){

        given()
                .pathParam("path","users")
                .queryParam("page","2")
                .queryParam("id","5")

                .when()
                .get("https://reqres.in/api/{path}")

                .then()
                .log().all()
                .statusCode(200);

    }
}
