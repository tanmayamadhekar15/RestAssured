package RestAssuredProject1.testNG.june_20;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Ex265_HardSoftAssertions {

    @Description("TC#1")
    @Test
    public void testCase(){

        // Assertion ->  Expect Result = Actual Results
        // Two Types Assertions
        // Soft Assertions - If assert faile, then execution continues
        SoftAssert s = new SoftAssert();
        s.assertEquals("Testing","Testing","Equal");
        s.assertEquals("Manual","Manual","Equal");
        System.out.println("End of the Program");
        s.assertAll();


       //Hard Assertion - If assert fails then execution stops. (thread kills program)
    /*
       Assert.assertEquals("Automation","Automation");
       System.out.println("End of the program");
       Assert.assertEquals("1","2");
       System.out.println("Assert fails so thread stops execution");
*/

    }
}
