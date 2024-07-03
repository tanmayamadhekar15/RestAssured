package RestAssuredProject1.testNG.june_27.POJO;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;


public class Lab292 {

    RequestSpecification request = RestAssured.given();
    ValidatableResponse validatableResponse;
    Response response;


    @Description("Create booking with valid payload")
    @Test
    public void testNonBDDstylePostPositive() {
        String Baseurl = "https://restful-booker.herokuapp.com";
        String endpoint = "/booking";

        Booking booking=new Booking();
        booking.setFirstName("Jones");
        booking.setLastName("Brown");
        booking.setPrice(1341);
        booking.setPaid(true);

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        request = RestAssured.given();
        request.baseUri(Baseurl);
        request.basePath(endpoint);
        request.contentType(ContentType.JSON);
        request.body(booking).log().all();

        response = request.when().log().all().post();


        validatableResponse = response.then();
        validatableResponse.statusCode(200);

    }
}


