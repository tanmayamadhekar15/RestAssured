package RestAssuredProject1.testNG;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class RequestBodyWays {
    //create request body with different ways
    RequestSpecification rs= RestAssured.given();  // RequestSpec - Method Overloading(Compile time poly)
    Response res;
    ValidatableResponse vr;
    @BeforeTest
    public void setUp(){
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/auth");
    }
    /*@Test(priority = 1)//Create request body data using String - testcases less than 50
    public void getToken(){
        String payloadString="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        res=rs.when().body(payloadString).post();

        vr=res.then().log().all().statusCode(200);
    }*/

    @Test(priority = 2)  //create request body using Map - LinkedHashMap(indexing) , HashMap (hashing)
    public void getTokenUsingMap(){
        Map<String,String> m=new LinkedHashMap<String,String>();  // Runtime poly - Dynamic dispatch
        m.put("username","admin");
        m.put("password","password123");

        rs.when();
        rs.body(m);
        res= rs.post();
        vr= res.then().log().all();
        res.statusCode();
    }


}
