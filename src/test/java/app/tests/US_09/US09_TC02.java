package app.tests.US_09;

import app.pages.HomePage;
import app.pages.VendorRegistrationPage;

import app.utilities.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import static app.utilities.JSUtils.JSclickWithTimeout;

public class US09_TC02 {
    HomePage homePage;
    VendorRegistrationPage vendorRegistrationPage;

    @Test
    public void verificationCodeNegativeTest() throws InterruptedException {
        //Go to home page
        Driver.getDriver().get("https://allovercommerce.com/");
        //Create objects
        homePage = new HomePage();
        vendorRegistrationPage = new VendorRegistrationPage();
        //Click on register link
        homePage.register_Link.click();
        //Click on the Become a Vendor button
        homePage.signUp_BecomeVendorLink.click();
        //Enter your email in the Email field
        vendorRegistrationPage.vendorRegister_Email.sendKeys("lizandro.cruz@forkshape.com");

        //Don't enter verification code in the Verification Code field.
        //Enter password which contain lowercase, uppercase, numbers and special characters
        vendorRegistrationPage.vendorPassword.sendKeys("Monday12.");
        //Enter same password in the confirm password field
        vendorRegistrationPage.vendorConfirmPassword.sendKeys("Monday12.");
        //Verify that "Verification code sent to your email: abc@gmail.com." message is visible
        WaitUtils.waitForPageToLoad(4);
        Assert.assertTrue(vendorRegistrationPage.verificationCode.isDisplayed());

        //Click on the Register Button
        JSclickWithTimeout(vendorRegistrationPage.registerButton);
        //Verify that the registration process doesn't complete
        JSUtils.JSscrollIntoView(vendorRegistrationPage.vendorRegistrationPageTitle);
        Assert.assertEquals(vendorRegistrationPage.vendorRegistrationPageTitle.getText(),
                "Vendor Registration");

        LoggerUtils.info("End Test.");
        Thread.sleep(5000);
        Driver.closeDriver();









    }
}
