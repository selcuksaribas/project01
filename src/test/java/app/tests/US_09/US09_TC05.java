package app.tests.US_09;

import app.pages.HomePage;
import app.pages.VendorRegistrationPage;
import app.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class US09_TC05 {

    @Test
    public void test05() throws InterruptedException {
        ExtentReportUtils.createTestReport("confirm_password_test","fifth_test");
        //Go to home page
        Driver.getDriver().get("https://allovercommerce.com/");

       HomePage homePage = new HomePage();
       VendorRegistrationPage vendorRegistrationPage = new VendorRegistrationPage();
        //Click on register link
        homePage.register_Link.click();
        //Click on the Become a Vendor button
        homePage.signUp_BecomeVendorLink.click();
        //Enter your email in the Email field

        WaitUtils.waitForPageToLoad(5);

        Assert.assertEquals(
                Driver.getDriver().getCurrentUrl(),
                "https://allovercommerce.com/vendor-register/"
        );

        //get window handle of vendor registration page
        String vendorHandle = Driver.getDriver().getWindowHandle();
        LoggerUtils.info("Vendor Registration Handle saved");

        //fakeMailHandle will be set later
        String fakeMailHandle = null;

        WaitUtils.waitFor(1);
        //switch to a new tab
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);
        Driver.getDriver().get("https://fakemail.net");


        WaitUtils.waitForPageToLoad(10);

        //Manage and locate the second window handle
        //This will be the handle for fake mail website
        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(vendorHandle)) {
                fakeMailHandle = handle;
            }
        }

        //Test to make sure the handles are both opened properly
        try {
            Driver.getDriver().switchTo().window(vendorHandle);
            Assert.assertEquals(
                    Driver.getDriver().getCurrentUrl(),
                    "https://allovercommerce.com/vendor-register/"
            );

            Driver.getDriver().switchTo().window(fakeMailHandle);
            Assert.assertEquals(
                    Driver.getDriver().getCurrentUrl(),
                    "https://www.fakemail.net/"
            );
        } catch (Exception e) {
            System.out.println("The handles are pointing to incorrect URLs");
        }

        //prints the window handles for both websites
        System.out.println("Vendor Registration Handle: " + vendorHandle);
        System.out.println("FakeMail handle: " + fakeMailHandle);

        try {
            //locate the consent button on fake mail popup
            WebElement consentButton = Driver.getDriver().findElement(By.cssSelector(
                    ".fc-cta-consent"
            ));
            //The consent button on the popup is clicked once it is ready to do so
            WaitUtils.waitForClickablility(consentButton, 3);
            consentButton.click();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        WaitUtils.waitFor(1);

        //locate the email field from fake mail
        //get and store the email in a container called generatedEmail
        WebElement generatedEmailEl = Driver.getDriver().findElement(By.cssSelector(".animace"));
        String generatedEmail = generatedEmailEl.getText();

        Driver.getDriver().switchTo().window(vendorHandle);


        //Enter email address in email field
        vendorRegistrationPage.vendorRegister_Email.sendKeys(generatedEmail);

        //Enter password which contain lowercase, uppercase, numbers and special characters
        vendorRegistrationPage.vendorPassword.sendKeys("Summer12*");

        // Left blank confirm password field.
        //locate the verification message
        WebElement verificationMessage = Driver.getDriver().findElement(By.cssSelector(
                ".email_verification_message"
        ));

        //switch to fake mail again

        Driver.getDriver().switchTo().window(fakeMailHandle);

        WaitUtils.waitFor(10);

        //Then locate the top most row of incoming mails

        WebElement incomingMailFirstRow = Driver.getDriver().findElement(By.xpath(
                "//tr[contains(@class, 'hidden-lg') and contains(@class, 'newMail')][1]"
        ));

        //use JS because mail is refreshed every 10 seconds
        //this can lead to stale exceptions
        //JS is very good at preventing this
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", incomingMailFirstRow);


        //go into iframe

        WebElement iframeEl = Driver.getDriver().findElement(By.cssSelector("#iframeMail"));
        BrowserUtils.switchToIframeByWebElement(iframeEl);

        //locate the verification code in the mail
        WebElement locateVerificationCode = Driver.getDriver().findElement(By.cssSelector("#body_content_inner b"));

        System.out.println(locateVerificationCode.getText());
        WaitUtils.waitForVisibility(locateVerificationCode, 15);

        //Store the verification code as text
        String generatedVerificationCode = locateVerificationCode.getText();

        //switch back to Vendor registration page
        Driver.getDriver().switchTo().window(vendorHandle);

        //wait for verification code field to be visible in page
        //Then type the verification code
        WaitUtils.waitForVisibility(vendorRegistrationPage.verificationCode, 5);
        vendorRegistrationPage.verificationCode.sendKeys(generatedVerificationCode);

        //Click on the Register Button
        JSUtils.JSscrollIntoView(vendorRegistrationPage.registerButton);
        WaitUtils.waitFor(1);
        vendorRegistrationPage.registerButton.click();

        //Verify that the registration process doesn't complete
        JSUtils.JSscrollIntoView(vendorRegistrationPage.confirmPasswordIsRequired);

        Assert.assertTrue(vendorRegistrationPage.confirmPasswordIsRequired.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("the registration process doesn't complete");

        ExtentReportUtils.flush();
        Thread. sleep(5000);
        Driver.closeDriver();






    }
}
