package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex277 {
    String token;
    Integer bookingId;
    RequestSpecification requestSpecification = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;

    @BeforeTest
    public void getAToken() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.post();

        validatableResponse = response.then();
        validatableResponse.statusCode(200);

        // Extract the Token from this -  extract keys ->pass key name as path
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);
    }

    @BeforeTest
    public void getBookingID() {

        String payload = "{\n" +
                "    \"firstname\" : \"Amit\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        response = requestSpecification.when().post();

        ValidatableResponse validatableResponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        bookingId = response.then().log().all().extract().path("bookingid");
        String firstName = response.then().log().all().extract().path("booking.firstname");
        System.out.println(firstName);
        System.out.println(bookingId);
        Assert.assertNotNull(bookingId);

    }

    @Test
    public void testPUTRequestPositive() {
        // token and BookingID
        System.out.println(" - Test Case PUT Request ");

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


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/" + bookingId);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);


        // Put Request
        requestSpecification.body(payload).log().all();

        response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String fullResponseJSON= response.asString();
        System.out.println(fullResponseJSON);

        //Approach 1- Rest Assured Validate matchers
        validatableResponse.body("firstname", Matchers.equalTo("Jim"));
        validatableResponse.body("totalprice", Matchers.equalTo(111));

        //Approach 2 - Testng asserts
        String firstname=response.then().log().all().extract().path("firstname");
        Integer totalprice=response.then().extract().path("totalprice");
        Assert.assertEquals(firstname,"Jim");
        Assert.assertEquals(totalprice,111);

        //Approach 3 - Testng assertion using json path lib
        JsonPath json =new JsonPath(fullResponseJSON);
        String firstJsonPath =json.getString("firstname");
        Integer tp=json.getInt("totalprice");
        Assert.assertEquals(firstJsonPath,"Jim");
        Assert.assertEquals(tp,111);


        //Approach 4 - AssertJ
        assertThat(firstJsonPath)
                .isEqualTo("Jim")
                .isNotBlank().isNotEmpty();

        assertThat(tp).isEqualTo(111).isNotNull().isPositive();



    }
}

