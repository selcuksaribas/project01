package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerShippingAddressPage {
    public CustomerShippingAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "shipping_first_name") public WebElement shippingFirstNameInput;
    @FindBy(id = "shipping_last_name") public WebElement shippingLastNameInput;
    @FindBy(id = "shipping_company") public WebElement shippinCompanyNameInput;
    @FindBy(id = "select2-shipping_country-container") public WebElement shippingCountryDropDown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement countryRegionDropdownInput;
    @FindBy(id = "shipping_address_1") public WebElement shippingAddressFirstLineInput;
    @FindBy(id = "shipping_address_2") public WebElement shippingAddressSecondLineInput;
    @FindBy(id = "shipping_city") public WebElement shippingCityInput;
    @FindBy(id = "select2-shipping_state-container") public WebElement shippingProvinceDropDown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement provinceDropdownInput;
    @FindBy(id = "shipping_postcode") public WebElement shippingPostcodeInput;
    @FindBy(xpath = "//button[@value='Save address']") public WebElement saveAddressButton;
    @FindBy(xpath = "//*[@data-id='shipping_postcode']") public WebElement postCodeRequired;
}
