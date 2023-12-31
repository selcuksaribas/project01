package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddVendorBillingAddressPage {
    public AddVendorBillingAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='edit btn btn-link btn-primary btn-underline mb-4']") public WebElement addBillingAddressButton;
    @FindBy(id = "billing_first_name") public WebElement billingFirstName;
    @FindBy(id = "billing_last_name") public WebElement billingLastName;
    @FindBy(id = "billing_company") public WebElement companyNameInput;
    @FindBy(id = "select2-billing_country-container") public WebElement selectCountryDropDownArrow;
    @FindBy(id = "billing_country") public WebElement selectCountryDropDown;
    @FindBy(id = "billing_address_1") public WebElement streetAddress1Input;
    @FindBy(id = "billing_address_2") public WebElement streetAddress2Input;
    @FindBy(id = "billing_city") public WebElement cityInput;
    @FindBy(id = "billing_state") public WebElement selectStateDropdown;
    @FindBy(id = "select2-billing_state-container") public WebElement selectStateDropdownArrow;
    @FindBy(id = "billing_postcode") public WebElement zipCodeInput;
    @FindBy(id = "billing_phone") public WebElement phoneInput;
    @FindBy(id = "billing_email_field") public WebElement email;
    @FindBy(name = "save_address") public WebElement saveAddressButton;
    @FindBy(name = "//div[@class='woocommerce-notices-wrapper']") public WebElement addressSucces;

//    public static String getFirstName(){
//        return billingFirstName.getText();
//    }
//
//    public static String getLastName(){
//        return billingLastName.getText();
//    }

}
