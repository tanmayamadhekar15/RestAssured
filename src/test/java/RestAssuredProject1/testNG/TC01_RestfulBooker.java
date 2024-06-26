package RestAssuredProject1.testNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TC01_RestfulBooker {

    @Description("Validate token")
    @Test
    void getToken(){
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/ping")
                .when().get().
                then().
                statusCode(201);
    }
    @Description("Get bookings")
    @Test
    void getBooking(){
        given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking")
                .when().get().
                then().
                statusCode(200);
    }

    @Description("Create bookings")
    @Test
    void createBooking(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        String jsonData="{\n"+
                "\"firstname\" : \"Jim\",\n" +
                        "    \"lastname\" : \"Brown\",\n" +
                        "    \"totalprice\" : 111,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2018-01-01\",\n" +
                        "        \"checkout\" : \"2019-01-01\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n"+"}";

        Response response= given()
                .body(jsonData)
                .contentType(ContentType.JSON)
                .when().post("/booking").
                then().
                statusCode(200)
                .extract().response();
        response.prettyPrint();
    }

}
