package RestAssuredProject1.testNG.practice;

import RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO.BookingResponse;
import RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO.Bookingdates;
import RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO.CreateBooking;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class CRUD {
    Gson gson;

    @Test
    public void post(){
        CreateBooking c=new CreateBooking();
        c.setFirstname("Kavya");
        c.setLastname("D");
        c.setDepositpaid(true);
        c.setTotalprice(1000);
        c.setAdditionalneeds("Brunch");

        Bookingdates b=new Bookingdates();
        b.setCheckin("23-12-2020");
        b.setCheckout("29-12-2021");

        c.setBookingdates(b);

        // Convert java object to string using GSON - Serialization
        gson=new Gson();
        String requestPayloadUsingGSON=gson.toJson(c);

        RequestSpecification rs=RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.body(requestPayloadUsingGSON);

        Response res=rs.when().post();

        ValidatableResponse vr=res.then();
        String responseStr=res.asString();
        vr.statusCode(200);

        //Convert String to object using GSON -  Deserialization
        BookingResponse bookingResponse;
        bookingResponse = gson.fromJson(responseStr,BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());



    }
}
