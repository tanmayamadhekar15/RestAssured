package RestAssuredProject1.testNG.june_20;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Ex267_CRUD {
    String token;
    Integer bookingID;

    public String getToken() {
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndBookingID() {
        token = getToken();
        // POST Req -
        // POST code
        bookingID = 123;
    }

    @Test
    public void testPUTReq() {
        System.out.println(token);
        System.out.println(bookingID);
        // PUT Code
    }

    @Test
    public void testDeleteReq() {
        System.out.println(token);
        System.out.println(bookingID);
        // DELETE Code
    }

    @Test
    public void testGETReq() {
        System.out.println(token);
        System.out.println(bookingID);
        // GET Code
    }

}
