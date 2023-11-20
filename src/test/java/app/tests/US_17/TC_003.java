package app.tests.US_17;

import app.pages.CheckoutPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.pages.ProductPage;
import app.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;
@Listeners(app.utilities.ListenerUtils.class)
public class TC_003 {
    @Test
    public void TC_003()throws InterruptedException{

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
     And
     Click on orders
     And
     Click on Go Shop
     And
     Click on a desired item
     And
     Verify that the selected item is seen on the screen
     And
     Click on the add to cart button
     And
     Verify the message that the product added to the cart is visible
     And
     Click on the cart symbol
     And
     Verify that the added products are visible
     Then
     Click the checkout button
     and
     Verify that the total amount is visible
     and
     Check if the "Wire transfer/EFT" option is clickable
     and
     Check if the "Pay-at-the-door" option is clickable.
     and
     Click on place order button
     Then
     Verify that "Thank you your order has been received" is visible */



            //     go to "https://allovercommerce.com/"
            LoggerUtils.info("Test case begins .. ");
            ExtentReportUtils.createTestReport("Test Report US_17 TC_003","Admin Login Test");
//        2......
            ExtentReportUtils.pass("Starting the admin login test...");
            Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
            HomePage homePage=new HomePage();
            MyAccountPage myAccountPage = new MyAccountPage();
            ProductPage productPage = new ProductPage();
            CheckoutPage checkoutPage = new CheckoutPage();

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

            //     Click on orders
            myAccountPage.ordersButton.click();
            ActionsUtil.actionsScrollDown();
            WaitUtils.waitFor(3);

            //     Click on Go Shop
            myAccountPage.goShopButton.click();

            WaitUtils.waitFor(3);

            //     Click add the cart for a desired item
            productPage.searchBox.sendKeys("macbook", Keys.ENTER);
            WebElement macbook= productPage.macbook;
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();",macbook);


            //     Click on the add to cart button
            productPage.addToCartButton.click();

            //     Verify the message that the product added to the cart

            //     Click on the cart symbol
            productPage.cartIcon.click();
            WaitUtils.waitFor(2);

            productPage.viewCartButton.click();
            //     Verify that the added products are visible
            assertTrue(checkoutPage.MacBookCart.isDisplayed());

            //     Click the checkout button
            ActionsUtil.actionsScrollDown();
            WaitUtils.waitFor(2);
            checkoutPage.proceedToCheckOut.click();
            //Verify that the total amount is visible
            assertTrue(checkoutPage.totalAmount.isDisplayed());
            //2- Check if the "Wire transfer/EFT" option is clickable
            ActionsUtil.actionsScrollDown();
            JavascriptExecutor jss = (JavascriptExecutor) Driver.getDriver();
            jss.executeScript("arguments[0].click();",checkoutPage.wireTransferEFT);
            WaitUtils.waitFor(3);
            ExtentReportUtils.passAndCaptureScreenshot("WireTransferEft is clicked successfully");


            //3- Check if the "Pay-at-the-door" option is clickable.
            jss.executeScript("arguments[0].click();",checkoutPage.payAtTheDoor);
            WaitUtils.waitFor(3);
            ExtentReportUtils.passAndCaptureScreenshot("payAtTheDoor is clicked successfully");

            //4- Click on place order button
            checkoutPage.placeOrderButton.click();
            //5-Verify that "Thank you your order has been received" is visible
            assertTrue(checkoutPage.orderReceivedSuccessfullyMessage.isDisplayed());

            ExtentReportUtils.flush();

            LoggerUtils.info("Test completed...");

        }


}
