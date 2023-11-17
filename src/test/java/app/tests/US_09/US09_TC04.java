package app.tests.US_09;

import app.pages.HomePage;
import app.pages.VendorRegistrationPage;
import app.pages.VendorStoreManager;
import app.pages.VendorStoreSetUp;
import app.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US09_TC04 {
    HomePage homePage;
    VendorRegistrationPage vendorRegistrationPage;
    VendorStoreSetUp  vendorStoreSetUp;
    VendorStoreManager vendorStoreManager;

    @Test
    public void test04() throws InterruptedException {
        ExtentReportUtils.createTestReport("Password_test","fourth_test");
        //Go to home page
        Driver.getDriver().get("https://allovercommerce.com/");
        //Create objects
        homePage = new HomePage();
        vendorRegistrationPage = new VendorRegistrationPage();
        vendorStoreSetUp = new VendorStoreSetUp();
        vendorStoreManager = new VendorStoreManager();
        //Click on register link
        WaitUtils.waitForPageToLoad(5);
        homePage.register_Link.click();
        //Click on the Become a Vendor button
        WaitUtils.waitForPageToLoad(5);
        homePage.signUp_BecomeVendorLink.click();
       // Enter password which does not contain number in the password field
        vendorRegistrationPage.vendorPassword.sendKeys("Summer*");

        //Enter password which does not contain uppercase in the password field
        vendorRegistrationPage.vendorConfirmPassword.sendKeys("Summer*");
        ExtentReportUtils.passAndCaptureScreenshot("password strength message");

        //Verify that "weak" message  visible
        WaitUtils.waitFor(2);
        Assert.assertEquals(
                vendorRegistrationPage.vendorPasswordStrength.getText(),
                "Weak");

        ExtentReportUtils.flush();
        Thread. sleep(5000);
        Driver.closeDriver();


    }


}
