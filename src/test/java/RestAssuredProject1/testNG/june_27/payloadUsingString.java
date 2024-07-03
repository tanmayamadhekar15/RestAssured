package RestAssuredProject1.testNG.june_27;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class payloadUsingString {
    //create request body with different ways
    RequestSpecification rs = RestAssured.given();  // RequestSpec - Method Overloading(Compile time poly)
    Response res;
    ValidatableResponse vr;
    String tokenValue;

    @BeforeTest
    public void setUp() {
        rs.baseUri("https://restful-booker.herokuapp.com");
    }

    @Test(priority = 1)//Create request body data using String - testcases less than 50
    public void getToken() {
        String payloadString = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(payloadString);

        res = rs.when().post();

        vr = res.then().log().all().statusCode(200);

        String tokenValue=res.then().log().all().extract().path("token");
        Assert.assertNotNull(tokenValue);

    }

    @Test(priority = 2,dependsOnMethods = {"getToken"})
    public void createBooking(){
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
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",tokenValue);
        rs.body(payload);
        res=rs.when().post();


        vr=res.then();
        vr.statusCode(200);
        res.prettyPrint();
    }
}