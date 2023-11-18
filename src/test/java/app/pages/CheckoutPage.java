package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    public CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='showcoupon']")public WebElement enterYourCodeButton;
    @FindBy(name = "coupon_code")public WebElement couponCodeBox;
    @FindBy(name = "apply_coupon")public WebElement applyCouponButton;
    @FindBy(id = "billing_first_name")public WebElement firstName;
    @FindBy(id = "billing_last_name")public WebElement lastName;
    @FindBy(id = "billing_country")public WebElement countryRegionDropdown;
    @FindBy(id = "billing_address_1")public WebElement streetAddressFirstLine;
    @FindBy(id = "billing_address_2")public WebElement streetAddressSecondLine;
    @FindBy(id = "billing_city")public WebElement townCity;
    @FindBy(id = "billing_postcode")public WebElement postCodeZIP;
    @FindBy(id = "billing_state")public WebElement provinceStateDropdown;
    @FindBy(id = "billing_phone")public WebElement phone;
    @FindBy(id = "billing_email")public WebElement email;
    @FindBy(id = "payment_method_bacs")public WebElement wireTransferEFTButton;
    @FindBy(id = "payment_method_cod")public WebElement payAtTheDoorButton;
    @FindBy(id = "place_order")public WebElement placeOrderButton;
    @FindBy(xpath = "//strong[contains(text(),'Billing First name')]")public WebElement alertFirstNameRequired;
    @FindBy(xpath = "//strong[contains(text(),'Billing Town / City')]")public WebElement alertTownCityRequired;
    @FindBy(xpath = "//p[contains(text(), 'Thank you. Your order has been received.')]")public WebElement orderReceivedSuccessfullyMessage;
    @FindBy(xpath = "//a[@class=\"checkout-button button alt wc-forward\"]") public WebElement proceedToCheckOut;
    @FindBy (xpath = "//table/tbody/tr[1]/td[2]") public WebElement MacBookCart;
    @FindBy (xpath = "//*[@id=\"payment\"]/ul/li[1]/label" ) public WebElement wireTransferEFT;
    @FindBy (xpath = "//*[@id=\"payment\"]/ul/li[2]/label") public WebElement payAtTheDoor;
    @FindBy (xpath = "//*[@id=\"order_review\"]/table/tfoot/tr[3]/td/strong/span") public WebElement totalAmount;

    ///////////This line added by Halil /////////////
    //I ve added for testing issue
    @FindBy(xpath = "(//ul[@class='breadcrumb']//a)[2]")
    public WebElement checkOutButton;

    //I have added chout not succefull massege
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/form[2]/div[1]/ul/li[2]")
    public WebElement noShippingMethodAlert;
    //this button not working
    //new pay at door button
    @FindBy(xpath = "//*[@id=\"payment\"]/ul/li[2]/label")
    public WebElement payAtTheDoorNew;
    //new wire/eft button

    //order notes
    @FindBy(xpath = "//*[@id=\"order_comments\"]")
    public WebElement orderNote;

    ///////////This line added by Halil /////////////



}
