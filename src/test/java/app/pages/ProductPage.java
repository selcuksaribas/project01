package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//button[@name='add-to-cart']") public WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-btn alert-success']")public WebElement productAddedSuccessAlert;
    @FindBy(xpath = "//a[@class='cart-toggle']")public WebElement cartIcon;
    @FindBy(xpath = "//a[contains(text(),'View cart')]") public WebElement viewCartButton;
    @FindBy(xpath = "//a[@class='remove remove_from_cart_button']")public WebElement removeFromCartButton;
    @FindBy(partialLinkText = "Close")public WebElement closeCartIconWindow;
    @FindBy(xpath = "(//input[@type='search'])[1]")public WebElement searchBox;
    @FindBy(linkText = "16 ” MacBook Pro") public WebElement macbook;

    ////////Seda////////
    @FindBy(css = "[class=product_title entry-title]")
    public WebElement productLabel;
    @FindBy(xpath = "//div[@class='elementor-widget-container']//input[@type='search']")
    public WebElement productImage;
    @FindBy(css = "[src=https://allovercommerce.com/wp-content/uploads/2022/09/Blue-Ski-Boots-1.jpg]")
    public WebElement addCartButton;
    @FindBy(xpath = "//h1[contains(text(),'Blue Ski Boots')]/parent::div //p[@class='price'][1]")
    public WebElement productPrice;
    @FindBy(className = "woocommerce-order-details__title")
    public WebElement orderReceivedMessage;
    @FindBy(css = "input[id='account_first_name']")
    public WebElement firstName;
    @FindBy(css = "input[id='account_last_name']" )
    public WebElement lastName;
    @FindBy(css = "input[id='account_display_nam']" )
    public WebElement displayName;
    @FindBy(css = "input[id='account_email']")
    public WebElement emailAddress;
    @FindBy(css = "button[name='save_account_details']" )
    public WebElement saveChangeBtn;
    @FindBy(css = "[role=alert]" )
    public WebElement successMsg;
    ///////Seda////////
}
