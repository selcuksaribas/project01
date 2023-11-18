package app.tests.US_20;

import app.pages.*;
import app.utilities.ActionsUtil;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_01 {

    @Test
    public void TC_01(){

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

       //ActionsUtil.actionsScrollDown(cartPage.proceedToCheckOut);

        WaitUtils.waitFor(2);
        CartPage.proceedToCheckOut.click();

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

        WaitUtils.waitFor(5);
        CheckoutPage.placeOrderButton.click();



      //  Verify that "Thank you. Your order has been received." is visible.

        WaitUtils.waitFor(2);

        Assert.assertTrue(CheckoutPage.orderReceivedSuccessfullyMessage.getText().contains("Thank you"));


       //Click on 'My Account -Orders

       // OrderDetailsPage.myOrders.click();

        //    Verify that the details of shopping is seen
        //Assert.assertTrue(OrderDetailsPage.myAccount.isDisplayed());

    }

}
