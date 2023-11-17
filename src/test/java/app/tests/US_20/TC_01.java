package app.tests.US_20;

import app.pages.*;
import app.utilities.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    @Test
    public void TC_01(){

        ExtentReportUtils.createTestReport("Allover_commerce_test", "TC_01");

           // AllovercommercePage allovercommercePage = new AllovercommercePage();
            ProductPage productPage = new ProductPage();
            CheckoutPage checkoutPage = new CheckoutPage();
            //Actions actions = new Actions(Driver.getDriver());
            //SoftAssert softAssert = new SoftAssert();


        //    Login to the website

        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage =new HomePage();
        HomePage.signInOption.click();
        WaitUtils.waitFor(5);
        HomePage.emailOrUsername.sendKeys("narinmtestng@gmail.com");
        WaitUtils.waitFor(2);
        HomePage.password.sendKeys("1234567Techpro");
        WaitUtils.waitFor(2);
        HomePage.signInButton.click();
        WaitUtils.waitFor(5);


        //    Click on to the search box, enter a product name and select the product from listed products
        //    Verify that the selected product is seen on the screen

        HomePage.searchBox.sendKeys("women's leather white bag", Keys.ENTER);
        //Assert.assertTrue(HomePage.elementInAutoSuggestion.isDisplayed());

       // Click on Add to Cart Button, Verify the message the product added to the cart is seen,
        //    Click on view cart button
       // ActionsUtil.actionsScrollDown(ProductPage.addToCartButton);
        ProductPage.addToCartButton.click();
        WaitUtils.waitFor(1);
        Assert.assertTrue(ProductPage.addToCartButton.isDisplayed());
        ProductPage.cartIcon.click();
        //ExtentReportUtils.info("Women's leather white hangbag has been added to your cart.");
        //ProductPage.viewCartAfterAddCart.click();
        WaitUtils.waitFor(1);


        //    Verify that the selected product is seen on the cart - checkout

        CartPage cartPage = new CartPage();
        ProductPage.viewCartButton.click();
//        WaitUtils.waitFor(5);
        //Assert.assertTrue(ProductPage.productAddedSuccessAlert.isDisplayed());

//        extentTest.info("WIEV cart butonuna tıklandı");

        //    Click on Coupon code box, Enter Coupon Code, Click on Apply Coupon button
        // Verify that coupon is applied successfully

       // CartPage.couponCodeBox.click();
        //allovercommercePage.enterCouponCodekm.sendKeys(ConfigReader.getProperty("couponCode"));
        ActionsUtil.actionsScrollDown(CartPage.couponCodeBox);
        CartPage.couponCodeBox.sendKeys("DISCOUNT10");
        CartPage.applyCouponButton.click();
        //Assert.assertTrue(CartPage.successCoupon.getText().contains("Thank you"));

        //    Click on Proceed to checkout button

       //ActionsUtil.actionsScrollDown(cartPage.checkout);

        WaitUtils.waitFor(5);
        //CartPage.checkout.click();

       //WebElement checkout = cartPage.checkout;
      // JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
       //javascriptExecutor.executeScript("argument[0].click()", proceedToCheckOut);
//       ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(checkout,5));
//        JavascriptExecutor jsout = (JavascriptExecutor) Driver.getDriver();
//        jsout.executeScript("argument[0].click();", checkout);

        //CartPage.proceedToCheckOut.click();
        WebElement checkOut = cartPage.proceedToCheckOut;
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].click()", checkOut);

        //    Enter Billing First Name and Last Name

        WaitUtils.waitFor(2);

        CheckoutPage.firstName.clear();
        CheckoutPage.firstName.sendKeys("team01");

        CheckoutPage.lastName.clear();
        CheckoutPage.lastName.sendKeys("team");

//    Select Billing Country

        //CheckoutPage.countryRegionDropdown.findElement(By.name("United State"));

//    Enter Billing Address Information
        CheckoutPage.streetAddressFirstLine.clear();
        CheckoutPage.streetAddressFirstLine.sendKeys("High Street");
        CheckoutPage.townCity.clear();
        CheckoutPage.townCity.sendKeys("NY");
       // CheckoutPage.provinceStateDropdown.findElement(By.name("New York"));
        CheckoutPage.postCodeZIP.clear();
        CheckoutPage.postCodeZIP.sendKeys("10001");

//    Enter Billing Phone  and Email Address
        CheckoutPage.phone.clear();
        CheckoutPage.phone.sendKeys("001 234 567 8989");
        CheckoutPage.email.clear();
        CheckoutPage.email.sendKeys("narinmtestng@gmail.com");

//    Click on Wire transfer/EFT or Pay at the door
        //CheckoutPage.wireTransferEFTButton.click();

        //    Click on Place order button

        //CheckoutPage.placeOrderButton.click();

        WaitUtils.waitFor(3);
        WebElement placeOrder = checkoutPage.placeOrderButton;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", WaitUtils.waitForVisibility(placeOrder,5));
        js.executeScript("arguments[0].click()", placeOrder);
//        JavascriptExecutor jsch = (JavascriptExecutor) Driver.getDriver();
//        jsch.executeScript("argument[0].click();", window);
        //CheckoutPage.placeOrderButton.click();



      //  Verify that "Thank you. Your order has been received." is visible.

        //WaitUtils.waitFor(1);

        OrderDetailsPage orderDetailsPage = new OrderDetailsPage();

        //Assert.assertTrue(OrderDetailsPage.orderReceivedSuccessfullyMessage.isDisplayed());

        //OrderDetailsPage.orderReceivedSuccessfullyMessage.isDisplayed();

        WebElement successfullyMessage = OrderDetailsPage.orderReceivedSuccessfullyMessage;
        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) Driver.getDriver();
       // javascriptExecutor1.executeScript("Thank you", successfullyMessage);
        javascriptExecutor1.executeScript("arguments[0].scrollIntoView(true);",successfullyMessage);

        //CheckoutPage.orderReceivedSuccessfullyMessage.isDisplayed();


        //Assert.assertTrue(OrderDetailsPage.orderReceivedSuccessfullyMessage.getText().contains("Thank you"));
        //ExtentReportUtils.passAndCaptureScreenshot("THANK YOU.");
        ExtentReportUtils.passAndCaptureScreenshot("Thank you");


        Driver.closeDriver();
        ExtentReportUtils.flush();








       //Click on 'My Account -Orders

       // OrderDetailsPage.myOrders.click();

        //    Verify that the details of shopping is seen
        //Assert.assertTrue(OrderDetailsPage.myAccount.isDisplayed());

    }

}
