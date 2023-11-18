package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerBillingAddressPage {
    public CustomerBillingAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "billing_first_name") public WebElement billingFirstNameInput;
    @FindBy(id = "billing_last_name") public WebElement billingLastNameInput;
    @FindBy(id = "billing_company") public WebElement billingCompanyNameInput;
    @FindBy(id = "select2-billing_country-container") public WebElement billingCountryDropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement countryRegionDropdownInput;
    @FindBy(id = "billing_address_1") public WebElement billingAddressFirstInput;
    @FindBy(id = "billing_address_2") public WebElement billingAddressSecondInput;
    @FindBy(id = "billing_city") public WebElement billingCityInput;
    @FindBy(id = "select2-billing_state-container") public WebElement billingProvinceDropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement provinceDropdownInput;
    @FindBy(id = "billing_postcode") public WebElement billingPostcodeInput;
    @FindBy(id = "billing_phone") public WebElement billingPhoneInput;
    @FindBy(id = "billing_email") public WebElement billingEmailInput;
    @FindBy(xpath = "//button[@value='Save address']") public WebElement saveAddressButton;
    @FindBy(xpath = "//*[@data-id='billing_address_1']") public WebElement streetAddressRequired;
    @FindBy(xpath = "(//input)[3]") public WebElement firstNameAutomatically;
    @FindBy(xpath = "(//input[@class='input-text '])[2]") public WebElement lastNameAutomatically;

}
