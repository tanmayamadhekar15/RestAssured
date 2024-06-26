package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PUT {
    RequestSpecification rs= RestAssured.given();
    Response r;
    ValidatableResponse vr;
    String token="a0d5b4bb80bb80a";
    String bookingid;

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void putRequest(){
    String basePath=BASE_PATH+"/2139";

    String payload ="{\n" +
            "    \"firstname\" : \"James\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    rs.baseUri(BASE_URL);
    rs.basePath(basePath);
    rs.contentType(ContentType.JSON);
    rs.cookie("token",token);
    rs.body(payload);

    r=rs.when().log().all().put();

    vr=r.then();
    vr.statusCode(200);
    vr.body("firstname", Matchers.equalTo("James"));
    vr.body("lastname", Matchers.equalTo("Brown"));

    }
}
