package US_12;

import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddVendorBillingAddressPage;
import pages.VendorMyAccountPage;
import pages.VendorSignInPage;
public class TC_02 {

    @Test
    public void TC_02() {
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));


      /*
        Vendor should navigate to "https://allovercommerce.com/"
Vendor signs in.
Enter Country/Region
Enter Street address
Enter Town / City
Select State
Enter ZIP Code
Enter Phone
Click on "Save Adresses" button
Verify address cahanged succesfully is visible
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
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.selectCountryDropDownArrow.click();
        WaitUtils.waitFor(2);
        Select select = new Select(addVendorBillingAddressPage.selectCountryDropDown);
        select.selectByVisibleText("United States (US)");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.streetAddress1Input.sendKeys("Vianesa Grove");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.streetAddress2Input.sendKeys("Whitehouse");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.cityInput.sendKeys("New York");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.selectStateDropdownArrow.click();
        WaitUtils.waitFor(2);
        Select select1 = new Select(addVendorBillingAddressPage.selectStateDropdown);
        select1.selectByVisibleText("Alabama");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.zipCodeInput.sendKeys("35211");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.phoneInput.sendKeys("4694681658");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(2);
        Assert.assertEquals(addVendorBillingAddressPage.addressSucces.getText(),"Address changed successfully.");


    }
}
