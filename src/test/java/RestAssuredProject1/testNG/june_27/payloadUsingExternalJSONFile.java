package RestAssuredProject1.testNG.june_27;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class payloadUsingExternalJSONFile {
   /* @Test
    public void postUsingExternalJSON() throws FileNotFoundException {
        //provide file location as parameter
        File f=new File(".//externalfile.json");
        //To read file
        FileReader fr=new FileReader(f);

        JSONTokener jt=new JSONTokener(fr);

        JSONObject jsonData=new JSONObject(jt);


        RequestSpecification rs= RestAssured.given();
                rs.basePath("/booking");
                rs.baseUri("https://restful-booker.herokuapp.com");
                rs.body(jsonData.toString());

        Response res=rs.when().post();

        ValidatableResponse vr=res.then().log().all().statusCode(200);

    }*/
}
