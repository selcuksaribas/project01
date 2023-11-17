package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
    public OrderDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(linkText = "/my-account-2/orders/")
    public static WebElement myOrders;

    @FindBy(xpath = "//h2[@class='page-title']")
    public static WebElement myAccount;

    @FindBy(xpath = "//p[contains(text(), 'Thank you. Your order has been received.')]")
   // @FindBy (xpath = "//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received order-success']")
    public static WebElement orderReceivedSuccessfullyMessage;


}
