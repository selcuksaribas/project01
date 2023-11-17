package app.tests.US_10;

import app.pages.VendorRegistrationPage;
import app.utilities.Driver;
import app.utilities.ExtentReportUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class US10_TC03 {


    @Test
    public void tc03() throws IOException {
        ExtentReportUtils.createTestReport("password_strength_test","third_test");

       Base base = new Base();
       VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
        base.repeat("Sun12.");

        base.checkInputField();

        WaitUtils.waitFor(2);
        Assert.assertEquals(
                vendorRegistrationPage.vendorPasswordStrength.getText(),
                "Good"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Good message is visible");

        base.clearPasswordField();
        WaitUtils.waitFor(1);
        ExtentReportUtils.flush();
    }

    @AfterClass
    public static void tearUp() {
        Driver.closeDriver();
    }
}