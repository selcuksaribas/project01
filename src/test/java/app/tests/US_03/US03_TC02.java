package app.tests.US_03;

import app.pages.CustomerBillingAddressPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.utilities.*;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class US03_TC02 {

    @Test
    public void customerBillingAddressTest(){
        ExtentReportUtils.createTestReport("Allover_commerce_test","US03_TC02");
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
        myAccountPage.accountDetailsButton.click();
        myAccountPage.accountFirstNameButton.clear();
        myAccountPage.accountFirstNameButton.sendKeys("John");
        myAccountPage.accountLastNameButton.clear();
        myAccountPage.accountLastNameButton.sendKeys("Doe", Keys.ENTER);

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
        customerBillingAddressPage.billingPhoneInput.sendKeys("4512345678");

        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);

//        Click on Save Address button
        customerBillingAddressPage.saveAddressButton.click();

//        Verify "Address changed successfully" is visible
        Assert.assertEquals(myAccountPage.billingAddressChangedSuccessfully.getText(),"Address changed successfully.");
        ExtentReportUtils.passAndCaptureScreenshot("User can add and edit Billing Address");
        ExtentReportUtils.flush();

        Driver.getDriver().close();



    }

}
