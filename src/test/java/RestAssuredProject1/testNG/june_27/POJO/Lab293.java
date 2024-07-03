/*package RestAssuredProject1.testNG.june_27.POJO;
import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Lab293 {

        RequestSpecification r=RestAssured.given();

        Response response;

        ValidatableResponse validatableResponse;


        @Description("Create booking with valid payload")
        @Test
        public void testNonBDDStylePOSTPositive() {
            String BASE_URL = "https://restful-booker.herokuapp.com";
            String BASE_PATH = "/booking";

            Booking booking = new Booking();
            booking.setFirstname("Jones");
            booking.setLastname("Brown");
            booking.setTotalprice(1341);
            booking.setDepositpaid(true);

            BookingDates bookingDates = new BookingDates();
            bookingDates.setCheckin("2018-01-01");
            bookingDates.setCheckout("2019-01-01");
            booking.setBookingdates(bookingDates);
            booking.setAdditionalneeds("Breakfast");
            r=RestAssured.given();
            r.baseUri(BASE_URL);
            r.basePath(BASE_PATH);
            r.contentType(ContentType.JSON).log().all();

            Response response;
            response = r.when().log().all().body(booking).post();
            String responseString = response.asString();
            System.out.println(responseString);

            ValidatableResponse validatableResponse=response.then();
            //validatableResponse = response.then().log().all();
            validatableResponse.statusCode(200);


        }

        @Description("TC 2 - Verify that create booking not working, with 500 Error")
        @Test
        public void testNonBDDStylePOSTNegative() {

            String BASE_URL = "https://restful-booker.herokuapp.com";
            String BASE_PATH = "/booking";
            String payload = "{}";

            r.baseUri(BASE_URL);
            r.basePath(BASE_PATH);
            r.contentType(ContentType.JSON).log().all();
            r.body(payload);

            response = r.when().log().all().post();
            String responseString = response.asString();
            System.out.println(responseString);


            validatableResponse = response.then();
            validatableResponse.statusCode(500);




        }
}
*/