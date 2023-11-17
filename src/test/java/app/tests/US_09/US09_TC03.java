package app.tests.US_09;

import app.pages.HomePage;
import app.pages.VendorRegistrationPage;
import app.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US09_TC03 {
    HomePage homePage;
    VendorRegistrationPage vendorRegistrationPage;

    @Test
    public void test03() throws InterruptedException {
        ExtentReportUtils.createTestReport("Password_test","third_test");
        //Go to home page
        Driver.getDriver().get("https://allovercommerce.com/");
        //Create objects
        homePage = new HomePage();
        vendorRegistrationPage = new VendorRegistrationPage();

        //Click on register link
        homePage.register_Link.click();
        //Click on the Become a Vendor button
        homePage.signUp_BecomeVendorLink.click();
        //Enter password which does not contain number in the password field
        vendorRegistrationPage.vendorPassword.sendKeys("summer1*");

        //Enter password which does not contain uppercase in the password field
        vendorRegistrationPage.vendorConfirmPassword.sendKeys("summer1*");
        ExtentReportUtils.passAndCaptureScreenshot("password strength message");

        //Verify that "weak" message  visible
        WaitUtils.waitFor(2);
        Assert.assertEquals(
                vendorRegistrationPage.vendorPasswordStrength.getText(),
                "Weak");

        ExtentReportUtils.flush();


        Driver.closeDriver();


    }

}
