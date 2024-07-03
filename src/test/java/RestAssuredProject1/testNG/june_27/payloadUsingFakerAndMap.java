package RestAssuredProject1.testNG.june_27;

//import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class payloadUsingFakerAndMap {
    @Test
    public void testPOSTReq() {
        // LinkedHashMap is used to maintain sequential order
        Map<String, Object> jsonBodyUsingMap = new LinkedHashMap<>();
        //Faker faker = new Faker();

        /*jsonBodyUsingMap.put("firstname", faker.name().firstName());
        jsonBodyUsingMap.put("lastname", faker.name().lastName());
        jsonBodyUsingMap.put("totalprice", faker.random().nextInt(10000));
        jsonBodyUsingMap.put("additionalneeds", "Dinner");
        jsonBodyUsingMap.put("depositpaid", faker.random().nextBoolean());*/

        Map<String, Object> bookingdates = new LinkedHashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2018-01-05");

        jsonBodyUsingMap.put("bookingdates", bookingdates);
        RequestSpecification r = RestAssured
                .given();

        Response response;

        ValidatableResponse validatableResponse;

        String BASE_URL = "https://restful-booker.herokuapp.com";
        String BASE_PATH = "/booking";
        r.baseUri(BASE_URL);
        r.basePath(BASE_PATH);
        r.contentType(ContentType.JSON).log().all();
        r.body(jsonBodyUsingMap);

        response = r.when().log().all().post();
        //String responseString = response.asString();
        //System.out.println(responseString);

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}
