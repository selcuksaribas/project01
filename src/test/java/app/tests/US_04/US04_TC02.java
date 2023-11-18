package app.tests.US_04;

import app.pages.CustomerBillingAddressPage;
import app.pages.CustomerShippingAddressPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US04_TC02 {
    /*
    Login to website
    Click on profile button
    Select Addresses from the menu
    Click on Add button under the Shipping Address
    Enter First name
    Enter Last name
    Enter Country/Region
    Enter Street address
    Enter Town / City
    Select State
    Leave ZIP Code blank
    Click on Save Address button
    Verify "ZIP code is required" is visible
     */

    @Test
    public void customerShippingAddressTest() {
        ExtentReportUtils.createTestReport("Allover_commerce_test","US04_TC02");
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

//        Login to website	https://allovercommerce.com/
        HomePage homePage = new HomePage();
        homePage.signInOption.click();
        homePage.emailOrUsername.sendKeys("kalaycibetul414@gmail.com");
        homePage.password.sendKeys("Bs\"12345678901");
        homePage.signInButton.click();

//        Click on profile button
        homePage.signOutButton.click();

        MyAccountPage myAccountPage = new MyAccountPage();
//        Select Addresses from the menu
        myAccountPage.addressesButton.click();

//        Click on Add button under the Shipping Address
        myAccountPage.editYourShippingAddressButton.click();

        CustomerShippingAddressPage customerShippingAddressPage = new CustomerShippingAddressPage();

//        Enter First name
//        Enter Last name
        customerShippingAddressPage.shippingFirstNameInput.clear();
        customerShippingAddressPage.shippingFirstNameInput.sendKeys("John");
        customerShippingAddressPage.shippingLastNameInput.clear();
        customerShippingAddressPage.shippingLastNameInput.sendKeys("Doe");

//        Enter Country/Region	Canada

        customerShippingAddressPage.shippingCountryDropDown.click();
        customerShippingAddressPage.countryRegionDropdownInput.sendKeys("Canada", Keys.ENTER);
//        Enter Street address	10 King St
        customerShippingAddressPage.shippingAddressFirstLineInput.click();
        customerShippingAddressPage.shippingAddressFirstLineInput.clear();
        customerShippingAddressPage.shippingAddressFirstLineInput.sendKeys("10 King st");

        ActionsUtil.actionsScrollDown();

//        Enter Town / City	Toronto
        customerShippingAddressPage.shippingCityInput.clear();
        customerShippingAddressPage.shippingCityInput.sendKeys("Toronto");

//        Select State	Ontario
        customerShippingAddressPage.shippingProvinceDropDown.click();
        customerShippingAddressPage.provinceDropdownInput.sendKeys("Ontario", Keys.ENTER);

        ActionsUtil.actionsScrollDown();


//        Leave ZIP Code blank
        customerShippingAddressPage.shippingPostcodeInput.clear();

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);

//        Click on Save Address button
        customerShippingAddressPage.saveAddressButton.click();

//        Verify "Street address is a required field." is visible
        Assert.assertEquals(customerShippingAddressPage.postCodeRequired.getText(),"Postal code is a required field.");
        ExtentReportUtils.passAndCaptureScreenshot("All required fields must be filled in Shipping Address Page");
        ExtentReportUtils.flush();

        Driver.getDriver().close();
    }
}
