package RestAssuredProject1.testNG.june_22.NonBDDStyle_RestFulBooker;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET {
    @Test
    public void getRequestNonBDDStyle(){
        //RequestSpec is an interface
        RequestSpecification rs=RestAssured.given();
        //Request URL
        rs.baseUri("https://api.zippopotam.us");
        rs.basePath("/IN/560037");
        //When
        rs.when().get();
        //then
        rs.then().log().all().statusCode(200);

    }


    @Test
    public void getRequestPositive(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/2002").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void getRequestNegative(){

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/-1").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);
    }
}
