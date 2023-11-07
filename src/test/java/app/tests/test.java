package app.tests;

import app.utilities.Driver;
import app.utilities.ExtentReportUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test {
    @Test
    public void test01(){
        ExtentReportUtils.createTestReport("google_test","first_test");
        Driver.getDriver().get("https://www.google.com");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("google"));
        ExtentReportUtils.passAndCaptureScreenshot("User is on the google page");
        Driver.getDriver().quit();
        ExtentReportUtils.flush();
    }
}
