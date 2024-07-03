package RestAssuredProject1.testNG.june_27.authpayloadUsingPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;


public class authPOJO {
    @Test
    public void getAuth(){
        /*String authPayload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
                */

        AuthClass ac=new AuthClass();
        ac.setUsername("admin");
        ac.setPassword("password123");

        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                .when().body(ac).post()

                .then().log().all().statusCode(200);


    }
}
