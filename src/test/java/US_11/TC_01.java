package US_11;

import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VendorSignInPage;
public class TC_01 {

    @Test
    public void TC_01() {
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));


        /*
        Vendor should navigate to "https://allovercommerce.com/"
Vendor clicks on sign in widget.
Vendor enters email.
Vendor enters password.
Verify MyAccount is visible.
Vendor clicks sign in button.
         */

        VendorSignInPage vendorSignInPage = new VendorSignInPage();
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


    }


}
