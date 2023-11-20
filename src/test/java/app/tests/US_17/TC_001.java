package app.tests.US_17;


import app.pages.*;
import app.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

@Listeners(app.utilities.ListenerUtils.class)
public class TC_001 {

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
     Click the checkout button*/

    @Test
    public void TC_001() throws InterruptedException {

        LoggerUtils.info("Test case Begins...");

        ExtentReportUtils.createTestReport("Test Report US_17 TC_001","Vendor Login Test");
        ExtentReportUtils.pass("Starting the vendor login test...");
        //     go to "https://allovercommerce.com/"

        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        ExtentReportUtils.pass("User is on the home page....");

        HomePage homePage=new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        ProductPage productPage = new ProductPage();
        CheckoutPage checkoutPage = new CheckoutPage();

        //     Click on the Sign-in button
        homePage.signInOption.click();
        ExtentReportUtils.pass("Navigated to the login page....");
        //     Enter a valid Username or email address
       homePage.emailOrUsername.sendKeys("TestNG112023@gmail.com");
        //     Enter valid password
       homePage.password.sendKeys("Techpro179");

        ExtentReportUtils.passAndCaptureScreenshot(
                "Username : "+ConfigReader.getProperty("admin_username")
                        +" password : "+ConfigReader.getProperty("admin_password")+" are entered successfully");
        //     Click on the Sign-in button
        homePage.getSignInButton.click();
        WaitUtils.waitFor(2);

        ExtentReportUtils.pass("Entered vendor credentials, and clicked on the login button successfully");
        //Click on account symbol
        homePage.accountSymbol.click();
       WaitUtils.waitFor(2);
        ExtentReportUtils.pass("Account symbol has been clicked");
        //     Click on orders
        myAccountPage.ordersButton.click();
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("Orders button has been clicked");
        //     Click on Go Shop
        myAccountPage.goShopButton.click();
        ExtentReportUtils.pass("goShopButton has been clicked");
        WaitUtils.waitFor(3);

        //     Click add the cart for a desired item
        productPage.searchBox.sendKeys("macbook", Keys.ENTER);
        ExtentReportUtils.pass("Product name was entered successfully");
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
        ExtentReportUtils.passAndCaptureScreenshot("Desired item is added to the cart successfully");
        //     Click the checkout button
        ActionsUtil.actionsScrollDown();
        WebElement checkout= checkoutPage.proceedToCheckOut;

        js.executeScript("arguments[0].click();",checkout);
        //checkoutPage.proceedToCheckOut.click();
        ExtentReportUtils.passAndCaptureScreenshot("CheckoutPage was clicked successfully");


        ExtentReportUtils.flush();

        LoggerUtils.info("Test completed...");
    }
    }








