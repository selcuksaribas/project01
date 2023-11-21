package app.tests.US_17;

import app.pages.*;
import app.utilities.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;
@Listeners(app.utilities.ListenerUtils.class)
public class TC_004 {

    @Test
    public void TC_004(){
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
     Click on orders
     and
     Click on the view button for desired order
     and
     Verify that the subtotal is visible
     and
     Verify that shipping information is visible
     and
     Verify that the payment method is visible
     Then
     Verify that the total is visible

     */
        LoggerUtils.info("Test case begins .. ");
//        1.......
        ExtentReportUtils.createTestReport("Test Report US_17 TC_004","Order Details Test");
//        2......
        ExtentReportUtils.pass("Starting the Order Details test...");

        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        ProductPage productPage = new ProductPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        AddVendorBillingAddressPage addBillingAddressPage = new AddVendorBillingAddressPage();
        OrderDetailsPage orderDetailsPage=new OrderDetailsPage();

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

        //Click on orders
        myAccountPage.ordersButton.click();
        ExtentReportUtils.pass("Order Button is clicked successfully");
        // Click on the view button for desired order
        myAccountPage.viewButton.click();
        // Verify that the subtotal is visible
       assertTrue(orderDetailsPage.subTotal.isDisplayed());

        //4-Verify that shipping information is visible
        assertTrue(orderDetailsPage.shippingDetails.isDisplayed());
        ExtentReportUtils.pass("Sipping details are displayed");
        //5-Verify that the payment method is visible
        assertTrue(orderDetailsPage.paymentDetails.isDisplayed());
        ExtentReportUtils.pass("Payment details are displayed");
        //6- Verify that the total is visible
        assertTrue(orderDetailsPage.total.isDisplayed());
        ExtentReportUtils.pass("Total is displayed");
        ExtentReportUtils.flush();
//        Logger utils
        LoggerUtils.info("Test completed...");
    }

    }