package RestAssuredProject1.testNG.june_27;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class payloadUsingMap {
    //create request body with different ways
    RequestSpecification rs= RestAssured.given();  // RequestSpec - Method Overloading(Compile time poly)
    Response res;
    ValidatableResponse vr;
    String tokenValue;
    Integer bookingid;

    @BeforeTest
    public void setUp(){
        rs.baseUri("https://restful-booker.herokuapp.com");
    }

    @Test(priority = 1)  //create request body using Map - LinkedHashMap(indexing) , HashMap (hashing)
    public void getTokenUsingMap(){
        Map<String,String> m=new LinkedHashMap<String,String>();  // Runtime poly - Dynamic dispatch
        m.put("username","admin");
        m.put("password","password123");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(m);

        res=rs.when().post();

        vr= res.then().log().all().statusCode(200);
        String tokenValue=res.then().extract().path("token");
    }

    @Test(priority = 2,dependsOnMethods = {"getTokenUsingMap"})
    public void createBookingUsingMap(){
        Map<String, Object> mapData=new LinkedHashMap<>();
        mapData.put("firstname","Jim");
        mapData.put("lastname","Antone");
        mapData.put("totalprice",150);

        Map<String,String> mapData2=new HashMap<>();
        mapData2.put("checkin","12-23-2023");
        mapData2.put("checkout","12-28-2023");

        mapData.put("bookingdates",mapData2);

        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",tokenValue);
        rs.body(mapData);

        res=rs.when().post();

        vr=res.then().log().all().statusCode(200);
        String bookingID=res.then().extract().path("bookingid");

    }
}
