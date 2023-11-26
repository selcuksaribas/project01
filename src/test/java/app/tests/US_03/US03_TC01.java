package app.tests.US_03;

import app.pages.*;

import app.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US03_TC01 {
    @Test
    public void FirstLastNameEmailComeUpTest(){

        ExtentReportUtils.createTestReport("Allover_commerce_test","US03_TC01");


        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

//        Login to website	https://allovercommerce.com/
        HomePage homePage = new HomePage();
        homePage.signInOption.click();
        homePage.emailOrUsername.sendKeys("Clany1988@dayrep.com");
        homePage.password.sendKeys("sanxox-5vimni-giDfit");
        homePage.signInButton.click();

//        Click on profile button
        homePage.signOutButton.click();

        MyAccountPage myAccountPage =new MyAccountPage();

//        Select Addresses from the menu
        myAccountPage.addressesButton.click();
//        Click on Edit Your Billing Address button
        myAccountPage.editYourBillingAddressButton.click();


        CustomerBillingAddressPage customerBillingAddressPage =new CustomerBillingAddressPage();

//        Verify First name, Last name and Email address come up automatically
//        Enter Country/Region	Canada

        customerBillingAddressPage.billingCountryDropdown.click();
        customerBillingAddressPage.countryRegionDropdownInput.sendKeys("Canada", Keys.ENTER);
//        Enter Street address	10 King St
        customerBillingAddressPage.billingAddressFirstInput.click();
        customerBillingAddressPage.billingAddressFirstInput.clear();
        customerBillingAddressPage.billingAddressFirstInput.sendKeys("10 King st");

        ActionsUtil.actionsScrollDown();

//        Enter Town / City	Toronto
        customerBillingAddressPage.billingCityInput.clear();
        customerBillingAddressPage.billingCityInput.sendKeys("Toronto");

        WaitUtils.waitFor(3);

//        Select State	Ontario
        customerBillingAddressPage.billingProvinceDropdown.click();
        customerBillingAddressPage.provinceDropdownInput.sendKeys("Ontario", Keys.ENTER);

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(3);

//        Enter ZIP Code	L4K0K6
//        Enter Phone	1234567890
//        customerBillingAddressPage.billingPostcodeInput.click();
        customerBillingAddressPage.billingPostcodeInput.clear();
        customerBillingAddressPage.billingPostcodeInput.sendKeys("L4K0K6");
        customerBillingAddressPage.billingPhoneInput.clear();
        customerBillingAddressPage.billingPhoneInput.sendKeys("4512345676");

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);

//        Click on Save Address button
        customerBillingAddressPage.saveAddressButton.click();

//        Verify "First name is a required field." and "Last name is a required field." are displayed
        Assert.assertTrue(customerBillingAddressPage.firstNameAutomatically.isDisplayed(),"First name is a required field.");
        Assert.assertTrue(customerBillingAddressPage.lastNameAutomatically.isDisplayed(),"Last name is a required field.");
        ExtentReportUtils.passAndCaptureScreenshot("First name and last name do not come automatically in the first sign in process");
        ExtentReportUtils.flush();

        Driver.getDriver().close();

    }

}
