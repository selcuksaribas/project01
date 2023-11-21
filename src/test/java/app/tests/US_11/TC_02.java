package app.tests.US_11;

import app.pages.VendorMyAccountPage;
import app.pages.VendorSignINPage;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_02 {

    @Test
    public void TC_02() {
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

       /*
        Vendor should navigate to "https://allovercommerce.com/"
Vendor signs in.
Verify  "dashboard" is visible.
Verify "store manage"  is visible
Verify "orders  is visible.
Verify "downloads" is visible.
Verify "addresses" is visible.
Verify "account details" is visible.
Verify "wishlist" is visible.
Verify "support tickets" is visible.
Verify "followings" is visible.
Verify "logout" is visible.
        */

        VendorSignINPage vendorSignInPage = new VendorSignINPage();
        VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();

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

        Assert.assertTrue(vendorMyAccountPage.dashboard.isDisplayed());

       Assert.assertTrue(vendorMyAccountPage.storeManager.isDisplayed());
       Assert.assertTrue(vendorMyAccountPage.orders.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.downloads.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.addresses.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.accountDetails.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.wishlist.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.supportTickets.isDisplayed());
      Assert.assertTrue(vendorMyAccountPage.followings.isDisplayed());
        Assert.assertTrue(vendorMyAccountPage.logout.isDisplayed());














    }
}