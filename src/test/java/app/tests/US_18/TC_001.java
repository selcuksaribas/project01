package app.tests.US_18;

import app.pages.*;
import app.utilities.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(app.utilities.ListenerUtils.class)
public class TC_001 {

    /*
    Given
   Navigate to "https://allovercommerce.com/"
   When
   Click on the Sign in button
   and
   Enter a valid Username or email address
   and
   Enters valid password
   and
   Click on the Sign in button
   and
   Click on my account symbol
   and
   Click on the "Store Manager
   and
   Click on the "Coupons"
   and
   Click on the "Add New"
   and
   Enter the coupon code
   and
   Verify that the coupon code is visible
   and
   Enter the coupon description
   and
   Verify that the coupon description is visible
   and
   Click on the discount type box
   and
   Click on the "Percentage Discount"
   and
   Verify that "Percentage Discount" is clickable
   and
   Click on the "Fixed Product"
   and
   Verify that the "Fixed Product" discount is clickable
   and
   Enter coupon amount
   and
   Verify that the coupon amount is visible
   and
   Click on the desired year on the coupon expiry box
   and
   Click on the desired month on the coupon expiry box
   and
   Click on the desired day on the coupon expiry box
   and
   Verify that the coupon expiry date is visible
   and
   Click on the "free shipping" button
   and
   Verify that "free shipping" button is clickable
   and
   Click on the "Show on the store" button
   and
   Verify that "Show on the Store" button is clickable
   and
   Click on "submit button"
   and
   Click on the coupons
   then
   Verify that the created coupon is visible
*/



    @Test
    public void TC_001() {
          LoggerUtils.info("Test case begins .. ");
//        1.......
          ExtentReportUtils.createTestReport(" Test Report US_18","Add Coupon Test");
//        2......
          ExtentReportUtils.pass("Starting the add coupons test...");
          //     go to "https://allovercommerce.com/"

          Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

          HomePage homePage = new HomePage();
          MyAccountPage myAccountPage = new MyAccountPage();
          ProductPage productPage = new ProductPage();
          CheckoutPage checkoutPage = new CheckoutPage();
          AddCouponPage addCouponPage = new AddCouponPage();

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
//7-  Click on the "Store Manager
          myAccountPage.storeManager.click();
          ExtentReportUtils.pass("Store manager button is clicked successfully");
          //8- Click on the "Coupons"
          ActionsUtil.actionsScrollDown();
          addCouponPage.coupons.click();
          ExtentReportUtils.pass("Coupons button is clicked successfully");
          //   Click on the "Add New"
          addCouponPage.addNewCoupon.click();
          ExtentReportUtils.pass("Add new coupon button is clicked successfully");
          // Enter the coupon code
          addCouponPage.codeBox.clear();
          addCouponPage.codeBox.sendKeys("2989878042");
          ExtentReportUtils.passAndCaptureScreenshot("Coupon Code is sent successfully");
          //   Enter the coupon description
          addCouponPage.descriptionBox.clear();
          addCouponPage.descriptionBox.sendKeys("Winter Sale");
          ExtentReportUtils.passAndCaptureScreenshot("Coupon description is clicked successfully");

          //Click on the discount type box
          WebElement discountType= addCouponPage.discountType;
          JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
          js.executeScript("arguments[0].click();",discountType);

         ExtentReportUtils.pass("Discount Type is clicked");

          //15-Click on the "Percentage Discount"
          addCouponPage.percentageDiscount.click();
          ExtentReportUtils.passAndCaptureScreenshot("PercentageDiscount is clicked successfully");

          //17- Click on the "Fixed Product"
          addCouponPage.fixedProductDiscount.click();
          ExtentReportUtils.pass("Fixed product is clicked successfully");

          //19- Enter coupon amount
          addCouponPage.couponAmountBox.clear();
          addCouponPage.couponAmountBox.sendKeys("100");
          ExtentReportUtils.passAndCaptureScreenshot("Coupon amount is added successfully");
          //21- Click on the desired year on the coupon expiry box

          addCouponPage.expiryDate.sendKeys("2023-12-12");
          addCouponPage.expiryDate.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN);
          WaitUtils.waitFor(2);
          ExtentReportUtils.passAndCaptureScreenshot("Expiry date added successfully");
          //24- Verify that the coupon expiry date is visible
          System.out.println("expiryDate = " + addCouponPage.expiryDate.getAttribute("value"));
          Assert.assertTrue(addCouponPage.expiryDate.getAttribute("value").equals("2023-12-12"));
         // 26- Verify that "free shipping" button is clickable
          WebElement allowFreeShip= addCouponPage.allowFreeShip;
          JavascriptExecutor jss = (JavascriptExecutor) Driver.getDriver();
          js.executeScript("arguments[0].click();",allowFreeShip);
          Assert.assertTrue(allowFreeShip.isSelected());
          ExtentReportUtils.pass("Free shipping is selected successfully");

          //27- Click on the "Show on the store" button
          //28- Verify that "Show on the Store" button is clickable

          WebElement showOnStore=addCouponPage.showOnStore;
          JavascriptExecutor jsse = (JavascriptExecutor) Driver.getDriver();
          jss.executeScript("arguments[0].click();",showOnStore);
          Assert.assertTrue(showOnStore.isSelected());
          ExtentReportUtils.pass("Show on strore is clicked successfully");

//29- Click on "submit button"

          jss.executeScript("arguments[0].click();",addCouponPage.submit);
          WaitUtils.waitFor(2);


//30- Click on the coupons
          addCouponPage.coupons.click();
          ExtentReportUtils.pass("Coupon is added successfully");
//31- Verify that the created coupon is visible

          String couponName=addCouponPage.publishedCoupon.getText();
          System.out.println("couponName = " + couponName);
          Assert.assertEquals(couponName,"2989878042");
          ExtentReportUtils.flush();

          LoggerUtils.info("Test completed...");



    }}