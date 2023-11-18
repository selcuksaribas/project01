package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCouponPage {
    public AddCouponPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy (xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-coupons']") public WebElement coupons;
    @FindBy(xpath = "//*[@id='add_new_coupon_dashboard']") public WebElement addNewCoupon;
    @FindBy(xpath = "//input[@id='title']") public WebElement codeBox;
    @FindBy(xpath = "//*[@id='description']") public  WebElement descriptionBox;
    @FindBy(xpath = "(//select)[1]") public  WebElement discountType;
    @FindBy(xpath = "//*[@id=\"discount_type\"]/option[1]") public WebElement percentageDiscount;
    @FindBy(xpath = "//*[@id=\"discount_type\"]/option[2]") public WebElement fixedProductDiscount;
    @FindBy(xpath = "//*[@id='coupon_amount']") public WebElement couponAmountBox;
    @FindBy(xpath = "//input[@data-date_format='yy-mm-dd']") public WebElement expiryDate;
    @FindBy(xpath = "(//*[@type='checkbox'])[1]") public WebElement allowFreeShip;
    @FindBy(xpath = "(//*[@type='checkbox'])[2]") public WebElement showOnStore;
    @FindBy(xpath = "(//input[@type='submit'])[1]") public WebElement submit;
    @FindBy(xpath = "//*[@id=\"wcfm-coupons\"]/tbody/tr[1]/td[1]/a") public WebElement publishedCoupon;
}
