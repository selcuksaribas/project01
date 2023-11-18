package app.tests.US_04;

import app.pages.CustomerBillingAddressPage;
import app.pages.CustomerShippingAddressPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US04_TC01 {
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
    Enter ZIP Code
    Click on Save Address button
    Verify "Address changed successfully" is visible
     */

    @Test
    public void customerShippingAddressTest(){
        ExtentReportUtils.createTestReport("Allover_commerce_test","US04_TC01");
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

//        Login to website	https://allovercommerce.com/
        HomePage homePage = new HomePage();
        homePage.signInOption.click();
        homePage.emailOrUsername.sendKeys("kalaycibetul414@gmail.com");
        homePage.password.sendKeys("Bs\"12345678901");
        homePage.signInButton.click();

//        Click on profile button
        homePage.signOutButton.click();

        MyAccountPage myAccountPage =new MyAccountPage();
//        Select Addresses from the menu
        myAccountPage.addressesButton.click();

//        Click on Add button under the Shipping Address
        myAccountPage.editYourShippingAddressButton.click();

        CustomerShippingAddressPage customerShippingAddressPage =new CustomerShippingAddressPage();

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

//        Enter ZIP Code	L4K0K6
//        Enter Phone	1234567890
//        customerBillingAddressPage.billingPostcodeInput.click();
        customerShippingAddressPage.shippingPostcodeInput.clear();
        customerShippingAddressPage.shippingPostcodeInput.sendKeys("L4K0K6");

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);

//        Click on Save Address button
        customerShippingAddressPage.saveAddressButton.click();

//        Verify "Address changed successfully" is visible
        Assert.assertEquals(myAccountPage.billingAddressChangedSuccessfully.getText(),"Address changed successfully.");
        ExtentReportUtils.passAndCaptureScreenshot("User can add and edit Shipping Address");
        ExtentReportUtils.flush();

        Driver.getDriver().close();



    }
}
