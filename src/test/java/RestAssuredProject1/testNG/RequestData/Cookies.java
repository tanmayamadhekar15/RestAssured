package RestAssuredProject1.testNG.RequestData;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class Cookies {
    @Test
    public void getCookies(){
        given()
                .when()
                .get("https://www.google.com/")

                .then().log().all().statusCode(200)
                .cookie("AEC","AQTF6HxbdbaM73g-RtkUxLDjE7swMwb0h2o-nUvUTVyr_g6Po5HHTDd4LQ");

    }

    @Test
    public void getCookieInfo(){
    //No then is required as it just verifies , here we need to getCookie from pre condition
        Response res=given()
                .when()
                .get("https://www.google.com/");

        String singleCookie=res.getCookie("AEC");
        System.out.println(singleCookie);

        //To get all cookies
        Map<String,String> getALlCookies=res.getCookies();  //getcookies returns Map
        System.out.println(getALlCookies.keySet());  //returns only key

        //Get all keys and values using for
        for(String k:getALlCookies.keySet()){
            String value= res.cookie(k);
            System.out.println(k + " " + value);
        }
    }

}
