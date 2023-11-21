package app.tests.US_18.US_12;

import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddVendorBillingAddressPage;
import pages.VendorMyAccountPage;
import pages.VendorSignInPage;

import static org.testng.AssertJUnit.assertTrue;
public class TC_01 {

    @Test
    public void TC_01() {
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));


    /*
    Vendor should navigate to "https://allovercommerce.com/"
Vendor signs in.
Vendor cliks on addresses button.
Vendor cliks on add button.
Verify  first name entered automatically.
Verify  last name entered automatically.
Verify  email entered automatically.
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

        vendorMyAccountPage.addresses.click();
        WaitUtils.waitFor(2);


        addVendorBillingAddressPage.addBillingAddressButton.click();
       Assert.assertTrue(addVendorBillingAddressPage.billingFirstName.isDisplayed());
        Assert.assertTrue(addVendorBillingAddressPage.billingLastName.isDisplayed());
        Assert.assertTrue(addVendorBillingAddressPage.email.isDisplayed());




        Assert.assertEquals(addVendorBillingAddressPage.email.getAttribute("value"),ConfigReader.getProperty("sblbtl87@gmail.com"));

    }


    }



