package RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO;

import com.beust.ah.A;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Runner {
    String token;
    String bookingId;
    @Test(priority = 1)
    public void getAuth(){
        AuthClass ac=new AuthClass();
        ac.setUsername("admin");
        ac.setPassword("password123");
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth")
                .contentType(ContentType.JSON)

                .when().body(ac).post()

                .then().log().all().statusCode(200);
    }
    @Test(priority = 2)
    public void createBooking(){
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
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)

                .when().body(c).post()

                .then().log().all().statusCode(200)
                .extract().path("bookingid");

    }
    @Test(priority = 3)
    public void getAllBookings(){
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON)

                .when().get()

                .then().log().all().statusCode(200);
    }

    @Test(priority = 4,dependsOnMethods = {"createBooking"})
    public void updateFullBooking(){
        CreateBooking c=new CreateBooking();
        c.setFirstname("Kenya");
        c.setLastname("Dal");
        c.setDepositpaid(false);
        c.setTotalprice(3000);
        c.setAdditionalneeds("Brunch/lunch");

        Bookingdates b=new Bookingdates();
        b.setCheckin("22-12-2020");
        b.setCheckout("29-11-2021");

        c.setBookingdates(b);
        RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking"+3488)
                .contentType(ContentType.JSON)

                .when().put()

                .then().log().all().statusCode(404); // Not found as update needs authorization , it's absent here

    }


}
