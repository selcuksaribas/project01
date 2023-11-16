package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    public CartPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(name = "coupon_code")
    public static WebElement couponCodeBox;

    @FindBy(name = "apply_coupon")
    public static WebElement applyCouponButton;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public static WebElement successCoupon;

    //@FindBy(xpath = "//a[@class=\"checkout-button button alt wc-forward\"]")
    @FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
    public static WebElement proceedToCheckOut;




}
