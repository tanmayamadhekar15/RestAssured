package RestAssuredProject1.testNG.june_25;

import org.testng.annotations.Test;

public class priorityEx2 {
    //same priority then executes as per Alphabetical order
    @Test(priority = 1)
    public void testMethodB() {
        System.out.println("Test Method B");
    }

    @Test(priority = 1)
    public void testMethodA() {
        System.out.println("Test Method A");
    }

    @Test(priority = 1)
    public void testMethodC() {
        System.out.println("Test Method C");
    }
}
