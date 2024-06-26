package RestAssuredProject1.testNG.june_25;

import org.testng.annotations.Test;

public class priorityEx {
    // TestNG Priority in Java
    // TestNG also allows the use of negative priority values.

    @Test(priority = 1)
    public void testMethodOne() {
        System.out.println("Test Method One");
    }

    @Test(priority = 2)
    public void testMethodTwo() {
        System.out.println("Test Method Two");
    }

    @Test(priority = 0)
    public void testMethodZero() {
        System.out.println("Test Method Zero");
    }

    @Test(priority = -1)
    public void testMethodNegativeOne() {
        System.out.println("Test Method Negative One");
    }

}
