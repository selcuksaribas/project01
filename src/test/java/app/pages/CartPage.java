package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//button[@title='Plus']")public WebElement plusIcon;
    @FindBy(xpath = "//button[@title='Minus']")public  WebElement minusIcon;
    @FindBy(xpath = "//button[contains(text(),'Update cart')]")public WebElement updateCartButton;
    @FindBy(id = "calc_shipping_country")public WebElement countryDropdown;
    @FindBy(name = "calc_shipping_state")public WebElement stateDropdown;
    @FindBy(id = "calc_shipping_city")public WebElement townCityBox;
    @FindBy(id = "calc_shipping_postcode")public WebElement postCodeZIPBox;
    @FindBy(name = "calc_shipping")public WebElement updateTotalButton;
    @FindBy(xpath = "//a[@class='checkout-button button alt wc-forward']")public WebElement proceedToCheckoutButton;
    @FindBy(xpath = "//input[@type='number']")public WebElement productQuantity;

    ////////Narin//////////
    @FindBy(name = "coupon_code")public static WebElement couponCodeBox;
    @FindBy(name = "apply_coupon")public static WebElement applyCouponButton;
    @FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
    public static WebElement proceedToCheckOut;
    ////////Narin///////////
}
