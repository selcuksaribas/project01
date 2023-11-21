package app.tests.US_11;

import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddVendorBillingAddressPage;
import pages.VendorMyAccountPage;
import pages.VendorSignInPage;

public class TC_03 {

    @Test
    public void TC_03() {
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));


/*
Vendor should navigate to "https://allovercommerce.com/"
Vendor signs in.
Verify  "dashboard" is selected.
Verify  "store manager" is selected.
Verify "orders  is selected.
Verify "downloads" is selected.
Verify "addresses" is selected.
Verify "account details" is selected.
Verify "wishlist" is selected.
Verify "support tickets" is selected.
Verify "followings" is selected.
Verify "logout" is selected.
 */


        VendorSignInPage vendorSignInPage = new VendorSignInPage();
        VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
        AddVendorBillingAddressPage addVendorBillingAddressPage = new AddVendorBillingAddressPage();
        vendorSignInPage.signInWidget.click();
        vendorSignInPage.usernameInput.sendKeys("sblbtl87@gmail.com");
        vendorSignInPage.passwordInput.sendKeys("Sibelbetul1987");
        vendorSignInPage.signInButton.click();

        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(2);
        vendorSignInPage.myAccount.click();
        WaitUtils.waitFor(2);

        Assert.assertTrue(vendorSignInPage.myAccount.isDisplayed());
        WaitUtils.waitFor(1);


//        Assert.assertTrue(vendorMyAccountPage.dashboard.isEnabled());
//        Assert.assertTrue(vendorMyAccountPage.storeManager.isEnabled());
//        Assert.assertTrue(vendorMyAccountPage.orders.isEnabled());





        vendorMyAccountPage.dashboard.click();
        WaitUtils.waitFor(1);
        Assert.assertTrue(vendorMyAccountPage.dashboardRecentOrders.isDisplayed());

//        vendorMyAccountPage.storeManager.click();
//        WaitUtils.waitFor(2);



        vendorMyAccountPage.storeManager.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.storeManagerTitle.isDisplayed());

        // return to my account page
        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(2);
        vendorSignInPage.myAccount.click();
        WaitUtils.waitFor(2);


        vendorMyAccountPage.orders.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.ordersBrowseProduct.isDisplayed());

        vendorMyAccountPage.downloads.click();
       WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.downloadsGoShop.isDisplayed());


        vendorMyAccountPage.addresses.click();
       WaitUtils.waitFor(2);
        Assert.assertTrue(addVendorBillingAddressPage.addBillingAddressButton.isDisplayed());

        vendorMyAccountPage.accountDetails.click();
       WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.accountDetailsFirstName.isDisplayed());


      vendorMyAccountPage.wishlist.click();
       WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.wishlistGoShopWindow.isDisplayed());

        // return to my account page
        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(2);
        vendorSignInPage.myAccount.click();
        WaitUtils.waitFor(2);




        vendorMyAccountPage.supportTickets.click();
       WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.supportTicketsCategory.isDisplayed());


        vendorMyAccountPage.followings.click();
        WaitUtils.waitFor(2);
        Assert.assertTrue(vendorMyAccountPage.followingsStore.isDisplayed());

      //  vendorMyAccountPage.logout.click();
     //   WaitUtils.waitFor(2);
    //    Assert.assertTrue(vendorSignInPage.signInButton.isDisplayed());



    }
}
