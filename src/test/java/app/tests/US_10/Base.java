package app.tests.US_10;

import app.pages.VendorRegistrationPage;
import app.utilities.Driver;
import app.utilities.JSUtils;
import app.utilities.WaitUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;





public class Base {
   VendorRegistrationPage vendorRegistrationPage;
    public void repeat(String pass) {
        Driver.getDriver().get("https://allovercommerce.com/vendor-register/");
        WaitUtils.waitForPageToLoad(15);

        //vendor object
        vendorRegistrationPage = new VendorRegistrationPage();

        //Scroll to breadcrumb

     JSUtils.JSscrollIntoView(
                vendorRegistrationPage.breadCrumb
        );

        WaitUtils.waitFor(2);

        //type password
        vendorRegistrationPage.vendorPassword.sendKeys(pass);
    }

    public void checkInputField() {
        VendorRegistrationPage alloverCommerceVendorRegistrationPage = new VendorRegistrationPage();
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        WebElement passwordField = alloverCommerceVendorRegistrationPage.vendorPassword;

        if(passwordField.getAttribute("type").equals("password")) {

            // Change type to text
            js.executeScript("arguments[0].type='text';", passwordField);

            // Get value
            String passwordText = (String) js.executeScript("return arguments[0].value;", passwordField);

            System.out.println(passwordText);
        }
    }

    public void clearPasswordField() {
       VendorRegistrationPage alloverCommerceVendorRegistrationPage = new VendorRegistrationPage();
        //Java example
        WebElement passwordField = alloverCommerceVendorRegistrationPage.vendorPassword;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

        // Set value
        js.executeScript("arguments[0].value = arguments[1];",
                passwordField, "");
    }
}