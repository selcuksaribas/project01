package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorShippingAddressPage {
    public VendorShippingAddressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "shipping_first_name") public WebElement firstNameInput;
    @FindBy(id = "shipping_last_name") public WebElement lastNameInput;
    @FindBy(id = "shipping_company") public WebElement companyNameInput;
    @FindBy(id = "select2-shipping_country-container") public WebElement countryRegionDropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement countryRegionDropdownInput;
    @FindBy(id = "shipping_address_1") public WebElement streetAddressInput;
    @FindBy(id = "shipping_city") public WebElement townCityInput;
    @FindBy(id = "shipping_postcode") public WebElement postalCodeInput;
    @FindBy(id = "select2-shipping_state-container") public WebElement provinceDropdown;
    @FindBy(xpath = "//input[@class='select2-search__field']") public WebElement provinceDropdownInput;
    @FindBy(xpath = "//button[@value='Save address']") public WebElement saveAddressButton;
}
