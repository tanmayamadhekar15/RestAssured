package RestAssuredProject1.testNG.june_22.BDDStyle;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POST {

    @Test
    public void postBDDStyle(){
    //Approach 1
    String payload="{\n" +
            "    \"firstname\" : \"Jim\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
        RequestSpecification rs= RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.body(payload);

        rs.when().post();
        rs.then().statusCode(200);

    //Approach 2
    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";
        RestAssured
                .given().baseUri(BASE_URL).basePath(BASE_PATH)
                .contentType(ContentType.JSON).log().all().body(payload)

                .when().log().all().post()

                .then().log().all().statusCode(200);
    }
}
