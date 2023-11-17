package app.tests.US_10;

import app.pages.VendorRegistrationPage;
import app.utilities.Driver;
import app.utilities.ExtentReportUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import java.io.IOException;

public class US10_TC04 {
    Base base;
    VendorRegistrationPage vendorRegistrationPage;
    @Test
    public void tc04() throws IOException {
        ExtentReportUtils.createTestReport("password_strength_test","fourth_test");

        base = new Base();
        vendorRegistrationPage = new VendorRegistrationPage();
        base.repeat("Winter45*");

        base.checkInputField();

        WaitUtils.waitFor(2);
        Assert.assertEquals(
                vendorRegistrationPage.vendorPasswordStrength.getText(),
                "Strong"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Strong message is visible");

        base.clearPasswordField();
        WaitUtils.waitFor(1);
        ExtentReportUtils.flush();
    }
    @AfterClass
    public static void tearUp() {
        Driver.closeDriver();
    }
}
