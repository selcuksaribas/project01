package app.tests.US_12;

import app.pages.AddVendorBillingAddressPage;
import app.pages.VendorMyAccountPage;
import app.pages.VendorSignINPage;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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

        VendorSignINPage vendorSignInPage = new VendorSignINPage();
        VendorMyAccountPage vendorMyAccountPage = new VendorMyAccountPage();
        AddVendorBillingAddressPage addVendorBillingAddressPage = new AddVendorBillingAddressPage();
        vendorSignInPage.signInWidget.click();
        vendorSignInPage.usernameInput.sendKeys("allover_commerce@yopmail.com");
        vendorSignInPage.passwordInput.sendKeys("123456789@@");
        vendorSignInPage.signInButton.click();


        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.of(10, ChronoUnit.SECONDS));

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

        //wait.until(ExpectedConditions.elementToBeClickable(addVendorBillingAddressPage.billingFirstName)).sendKeys("Whitehouse");
        //wait.until(ExpectedConditions.elementToBeClickable(addVendorBillingAddressPage.billingLastName)).sendKeys("Whitehouse");

//        Assert.assertEquals(AddVendorBillingAddressPage.getFirstName(),"");
//        Assert.assertEquals(AddVendorBillingAddressPage.getLastName(),"");

        WaitUtils.waitFor(2);
        Select select = new Select(addVendorBillingAddressPage.selectCountryDropDown);
        select.selectByVisibleText("United States (US)");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.streetAddress1Input.sendKeys("Vianesa Grove");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.streetAddress2Input.sendKeys("Whitehouse");
        WaitUtils.waitFor(2);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("billing_city")));
        addVendorBillingAddressPage.cityInput.sendKeys("New York");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.selectStateDropdownArrow.click();
        WaitUtils.waitFor(2);
        Select select1 = new Select(addVendorBillingAddressPage.selectStateDropdown);
        select1.selectByVisibleText("Alabama");
        WaitUtils.waitFor(2);
        addVendorBillingAddressPage.zipCodeInput.click();
        addVendorBillingAddressPage.zipCodeInput.sendKeys("32321");
        addVendorBillingAddressPage.phoneInput.sendKeys("122222");
        WaitUtils.waitFor(2);
        wait.until(ExpectedConditions.elementToBeClickable(addVendorBillingAddressPage.saveAddressButton));
        addVendorBillingAddressPage.saveAddressButton.click();
        WaitUtils.waitFor(2);
        Assert.assertEquals(addVendorBillingAddressPage.addressSucces.getText(),"Address changed successfully.");
        Driver.closeDriver();

    }
}
