package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POST {
    //Interfaces are abstract Classes are used to make reuse of code
    RequestSpecification r=RestAssured.given();
    Response response;
    ValidatableResponse vr;
    @Test
    public void postRequestNonBDDStyle(){
        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{\n" +
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

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.statusCode(200);
    }

    @Description("TC#2 - Verify that create booking not working, with 500 Error")
    @Test
    public void testNonBDDStylePOSTNegative() {

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        String payload = "{}";

        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(payload);

        response = r.when().log().all().post();
        String responseString = response.asString();
        System.out.println(responseString);

        vr = response.then();
        vr.statusCode(500);

    }
}
