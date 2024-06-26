package RestAssuredProject1.testNG.june_25;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class groupsEx {
    // Grouping of Test Cases

    @Issue("TC123")
    @AllureId("TC#1")
    @Severity(SeverityLevel.NORMAL)
    @Description("Sanity Testcase")
    @Test(groups = {"sanity"},priority = 1)
    public void createBookingPositiveTestcase() {
        System.out.println("Sanity");
        System.out.println("QA");
    }

    @Test(groups = {"sanity"},priority = 2)
    public void RegRun() {
        System.out.println("Reg");
    }

    @Test(groups = {"smoke"},priority = 3)
    public void SmokeRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"qa", "prod"},priority = 3)
    public void QARun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

    @Test(groups = {"prod"},priority = 3)
    public void ProdRun() {
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }

}
