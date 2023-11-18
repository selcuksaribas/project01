package app.tests.US_13;

import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.pages.VendorShippingAddressesPage;
import app.utilities.Driver;
import app.utilities.ExtentReportUtils;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001 {

    /*
    Given
    User navigates to website
    When
    User clicks on sign in button on home page
    And
    User enters a valid email address
    And
    User enters a valid password
    And
    User clicks on Sign in button on login page
    And
    User clicks on Profile button
    And
    User clicks on Addresses
    And
    User clicks on Add under Shipping Address
    And
    User enters First name
    And
    User enters Last name
    And
    User enters Company name
    And
    User selects Country/Region
    And
    User enters Street address
    And
    User enters Town/City
    And
    User selects Province
    And
    User enters ZIP code
    And
    User clicks on Save Address button
    Then
    Verify "Address changed successfully" is visible
     */

    @Test
    public void TC_001(){

        ExtentReportUtils.createTestReport("Allover_commerce_test","TC_001");

        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        VendorShippingAddressesPage vendorShippingAddressesPage = new VendorShippingAddressesPage();

//        User navigates to website
        Driver.getDriver().get("https://allovercommerce.com/");
        ExtentReportUtils.passAndCaptureScreenshot("User is on the home page");

//        User clicks on sign in button on home page
        homePage.signInOption.click();

//        User enters a valid email address
        homePage.emailOrUsername.sendKeys("erkamcavdar.testng@gmail.com");

//        User enters a valid password
        homePage.password.sendKeys("Ec5271996");

//        User clicks on Sign in button on login page
        homePage.signInButton.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User signed in successfully");

//        User clicks on Profile button
        homePage.signOutButton.click();

//        User clicks on Addresses
        myAccountPage.addressesButton.click();

//        User clicks on Add under Shipping Address
        myAccountPage.editYourShippingAddressButton.click();

//        User enters First name
        vendorShippingAddressesPage.firstNameInput.clear();
        vendorShippingAddressesPage.firstNameInput.sendKeys("Erkam");

//        User enters Last name
        vendorShippingAddressesPage.lastNameInput.clear();
        vendorShippingAddressesPage.lastNameInput.sendKeys("Cavdar");

//        User enters Company name
        vendorShippingAddressesPage.companyNameInput.clear();
        vendorShippingAddressesPage.companyNameInput.sendKeys("Erkam INC.");

//        User selects Country/Region
        vendorShippingAddressesPage.countryRegionDropdown.click();
        vendorShippingAddressesPage.countryRegionDropdownInput.sendKeys("Canada", Keys.ENTER);

//        User enters Street address
        vendorShippingAddressesPage.streetAddressInput.clear();
        vendorShippingAddressesPage.streetAddressInput.sendKeys("96 Toronto Avenue");

//        User enters Town/City
        vendorShippingAddressesPage.townCityInput.clear();
        vendorShippingAddressesPage.townCityInput.sendKeys("Toronto");
        WaitUtils.waitFor(1);

//        User selects Province
        vendorShippingAddressesPage.provinceDropdown.click();
        vendorShippingAddressesPage.provinceDropdownInput.sendKeys("Ontario",Keys.ENTER);

//        User enters Postal code
        vendorShippingAddressesPage.postalCodeInput.clear();
        vendorShippingAddressesPage.postalCodeInput.sendKeys("A1A 1A1");
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("Credentials entered successfully");

//        User clicks on Save Address button
        JSUtils.JSclickWithTimeout(vendorShippingAddressesPage.saveAddressButton);
        WaitUtils.waitFor(2);

//        Verify "Address changed successfully" is visible
        ExtentReportUtils.passAndCaptureScreenshot("Address changed successfully message is visible");
        Assert.assertTrue(Driver.getDriver().getPageSource().contains("Address changed successfully"));

//        Close the driver
        Driver.closeDriver();
        ExtentReportUtils.flush();
    }
}
