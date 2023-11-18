package app.tests.US_03;

import app.pages.CustomerBillingAddressPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US03_TC03 {


    @Test
    public void customerBillingAddressFailTest() {
        ExtentReportUtils.createTestReport("Allover_commerce_test","US03_TC03");
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
        myAccountPage.accountDetailsButton.click();
        myAccountPage.accountFirstNameButton.clear();
        myAccountPage.accountFirstNameButton.sendKeys("John");
        myAccountPage.accountLastNameButton.clear();
        myAccountPage.accountLastNameButton.sendKeys("Doe", Keys.ENTER);

//        Select Addresses from the menu
        myAccountPage.addressesButton.click();
//        Click on Edit Your Billing Address button
        myAccountPage.editYourBillingAddressButton.click();


        CustomerBillingAddressPage customerBillingAddressPage = new CustomerBillingAddressPage();

//        Verify First name, Last name and Email address come up automatically
//        Enter Country/Region	Canada

        customerBillingAddressPage.billingCountryDropdown.click();
        customerBillingAddressPage.countryRegionDropdownInput.sendKeys("Canada", Keys.ENTER);
//        Leave Street address blank
        customerBillingAddressPage.billingAddressFirstInput.click();
        customerBillingAddressPage.billingAddressFirstInput.clear();


        ActionsUtil.actionsScrollDown();

//        Enter Town / City	Toronto
        customerBillingAddressPage.billingCityInput.clear();
        customerBillingAddressPage.billingCityInput.sendKeys("Toronto");

//        Select State	Ontario
        customerBillingAddressPage.billingProvinceDropdown.click();
        customerBillingAddressPage.provinceDropdownInput.sendKeys("Ontario", Keys.ENTER);

        ActionsUtil.actionsScrollDown();

//        Enter ZIP Code	L4K0K6
//        Enter Phone	1234567890
//        customerBillingAddressPage.billingPostcodeInput.click();
        customerBillingAddressPage.billingPostcodeInput.clear();
        customerBillingAddressPage.billingPostcodeInput.sendKeys("L4K0K6");
        customerBillingAddressPage.billingPhoneInput.clear();
        customerBillingAddressPage.billingPhoneInput.sendKeys("4511234567");

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);

//        Click on Save Address button
        customerBillingAddressPage.saveAddressButton.click();

//        Verify "Street address is a required field." is visible
        Assert.assertEquals(customerBillingAddressPage.streetAddressRequired.getText(),"Street address is a required field.");
        ExtentReportUtils.passAndCaptureScreenshot("All required fields must be filled in Billing Address Page");
        ExtentReportUtils.flush();

        Driver.getDriver().close();


    }
}
