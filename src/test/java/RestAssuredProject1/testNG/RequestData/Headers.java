package RestAssuredProject1.testNG.RequestData;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.BDDAssertions.and;

public class Headers {

    @Test
    public void getHeaders(){
        given()
                .when()
                .get("https://www.google.com/")

                .then().log().all().statusCode(200)
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Content-Encoding","gzip")
                .and()
                .header("Server","gws");
    }

    @Test
    public void getHeaderInfo(){
        //No then is required as it just verifies , here we need to getCookie from pre condition
        Response res=given()
                .when()
                .get("https://www.google.com/");

       String getHeader=res.getHeader("Content-Type");
        System.out.println(getHeader);

        //To get all header
        io.restassured.http.Headers getAllHeaders=res.getHeaders();

        //Get all keys and values using for
        for(Header k:getAllHeaders){

            System.out.println(k.getName() + " " + k.getValue());
        }
    }
}
