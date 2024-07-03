package RestAssuredProject1.testNG.june_27.postpayloadUsingPOJO;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunnerUsingNonBDD {
    //instance variable declaration
    RequestSpecification rs = RestAssured.given();  // RequestSpec - Method Overloading(Compile time poly)
    Response res;
    ValidatableResponse vr;
    String tokenValue;
    Integer bookingID;

    @BeforeTest
    public void setUp() {
        rs.baseUri("https://restful-booker.herokuapp.com");
    }
    @Test(priority = 1)
    public void getAuth(){
        AuthClass ac=new AuthClass();
        ac.setUsername("admin");
        ac.setPassword("password123");
        rs.basePath("/auth");
        rs.contentType(ContentType.JSON);
        rs.body(ac);

        res = rs.when().post();

        vr = res.then().log().all().statusCode(200);
        String tokenValue=res.then().log().all().extract().path("token");

        //vr.body("token", Matchers.equalTo("378cce794e4b109"));
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
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.cookie("token",tokenValue);
        rs.body(c);  //rs.body(new Gson().toJson(c));

        /*
        Gson gc=new Gson();
        String ObjectToStringUsingGSON=gc.toJson(c);
        rs.body(new Gson().toJson(c)); Serialization - Java Object converted to String using GSON
        rs.body(ObjectToStringUsingGSON);
        */

        res=rs.when().post();

        vr=res.then();
        vr.statusCode(200);
        Integer bookingID=res.then().extract().path("bookingid");
        res.prettyPrint();

    }
    @Test(priority = 3)
    public void getAllBookings(){
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);

        res=rs.when().get();

        vr=res.then();
        vr.statusCode(200);
        res.prettyPrint();

    }

    @Test(priority = 4,dependsOnMethods = {"createBooking"})
    public void updateFullBooking(){
        CreateBooking c1=new CreateBooking();
        c1.setFirstname("Kavya");
        c1.setLastname("D");
        c1.setDepositpaid(true);
        c1.setTotalprice(1000);
        c1.setAdditionalneeds("Brunch");

        Bookingdates b=new Bookingdates();
        b.setCheckin("23-12-2020");
        b.setCheckout("29-12-2021");

        c1.setBookingdates(b);
        rs.basePath("/booking/"+bookingID);
        rs.cookie("token",tokenValue);
        rs.contentType(ContentType.JSON);

        rs.body(c1);
        res=rs.when().put();

        vr=res.then();
        vr.statusCode(200);
        res.prettyPrint();

    }



}
