package app.tests.US_10;

import app.pages.VendorRegistrationPage;

import app.utilities.Driver;
import app.utilities.ExtentReportUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



import java.io.IOException;

public class US10_TC01 {



    @Test
    public void tc01() throws IOException {
        ExtentReportUtils.createTestReport("password_strength_test","first_test");
       Base base = new Base();
       VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
        base.repeat("Sun1*");

        base.checkInputField();

        WaitUtils.waitFor(2);
        Assert.assertEquals(
                vendorRegistrationPage.vendorPasswordStrength.getText(),
                "Too short"
        );
        ExtentReportUtils.passAndCaptureScreenshot("Too short message is visible");

        base.clearPasswordField();
        WaitUtils.waitFor(1);
        ExtentReportUtils.flush();
    }

    @AfterClass
    public static void tearUp() {
        Driver.closeDriver();
    }
}