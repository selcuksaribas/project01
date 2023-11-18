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

}
