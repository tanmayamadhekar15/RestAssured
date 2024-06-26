package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DELETE {
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;
    String token = "a0d5b4bb80bb80a";
    String bookingid;

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void deleteRequest() {
        String basePath = BASE_PATH + "/1";

        rs.baseUri(BASE_URL);
        rs.basePath(basePath);
        rs.cookie("token", token);

        r = rs.when().log().all().delete();

        vr = r.then();
        vr.statusCode(201);

    }
}
