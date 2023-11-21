package app.tests.US_17;

import app.pages.*;
import app.utilities.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(app.utilities.ListenerUtils.class)
public class TC_002 {

 /*
 Given
     go to "https://allovercommerce.com/"
     When
     Click on the Sign-in button
     And
     Enter a valid Username or email address
     And
     Enter valid password
     And
     Click on the Sign-in button
     And
     Click on account symbol
     and
     Click on "First Name"
     and
     Change the First Name
     and
     Click on the "Last Name"
     and
     Change the Last Name
     and
     Refresh the page
     and
     Verify that the entered first name visible
     Then
     Verify that the entered last name visible

     */

    @Test
      public void TC_002() {

        LoggerUtils.info("Test case Begins...");
      ExtentReportUtils.createTestReport("Test Report US_17 TC_002","Editing Billing Details ");
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        ProductPage productPage = new ProductPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        AddVendorBillingAddressPage addBillingAddressPage = new AddVendorBillingAddressPage();

        //     Click on the Sign-in button
        homePage.signInOption.click();

        //     Enter a valid Username or email address
        homePage.emailOrUsername.sendKeys("TestNG112023@gmail.com");
        //     Enter valid password
        homePage.password.sendKeys("Techpro179");
        //     Click on the Sign-in button
        homePage.getSignInButton.click();
        WaitUtils.waitFor(2);
        //Click on account symbol
        homePage.accountSymbol.click();
        WaitUtils.waitFor(2);
        //  Go to addresses
        myAccountPage.addresses.click();
        //     Click edit your billing address
        addBillingAddressPage.addBillingAddressButton.click();
      ExtentReportUtils.passAndCaptureScreenshot("User is on billing details page....");
//         Click on the firstname
        addBillingAddressPage.billingFirstName.click();
        addBillingAddressPage.billingFirstName.clear();
      ExtentReportUtils.passAndCaptureScreenshot("User is on the home page....");
        // Enter a new First Name
        addBillingAddressPage.billingFirstName.sendKeys("Tom");
      ExtentReportUtils.passAndCaptureScreenshot("First name has been successfully entered");
// Click on the "Last Name"
        addBillingAddressPage.billingLastName.click();
        addBillingAddressPage.billingLastName.clear();
//Change the Last Name
        addBillingAddressPage.billingLastName.sendKeys("Hanks");
      ExtentReportUtils.passAndCaptureScreenshot("Last name has been entered successfully");
// Click the save button
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(2);
        addBillingAddressPage.saveAddressButton.click();
      ExtentReportUtils.passAndCaptureScreenshot("Billing info has been saved successfully");

      ExtentReportUtils.flush();
//        Logger utils
      LoggerUtils.info("Test completed...");


    }}