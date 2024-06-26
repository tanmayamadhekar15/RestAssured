package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PATCH {
    RequestSpecification rs = RestAssured.given();
    Response r;
    ValidatableResponse vr;
    String token = "a0d5b4bb80bb80a";
    String bookingid;

    String BASE_URL = "https://restful-booker.herokuapp.com";
    String BASE_PATH = "/booking";

    @Test
    public void patchRequest() {
        String basePath = BASE_PATH + "/2139";

        String payload = "{\n" +
                "    \"firstname\" : \"J\",\n" +
                "    \"lastname\" : \"B\",\n" +
                "}";

        rs.baseUri(BASE_URL);
        rs.basePath(basePath);
        rs.contentType(ContentType.JSON);
        rs.cookie("token", token);
        rs.body(payload);

        r = rs.when().log().all().patch();

        vr = r.then();
        vr.statusCode(200);
        vr.body("firstname", Matchers.equalTo("J"));
        vr.body("lastname", Matchers.equalTo("B"));

    }
}
