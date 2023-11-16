package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {


    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(xpath = "//button[@name='add-to-cart']")
    public static WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-btn alert-success']")
    public static WebElement productAddedSuccessAlert;

   //@FindBy(xpath = "//a[@class='cart-toggle']")
   @FindBy(xpath = "(//span[@class='cart-count'])[1]")
   //@FindBy(xpath = "(//*[@class='w-icon-cart'])[1]")
    public static WebElement cartIcon;

   //@FindBy(xpath = "//a[contains(text(),'View cart')]")
   @FindBy(xpath = "//a[text()='View cart']")
    public static WebElement viewCartButton;

    @FindBy (xpath = "//*[@class='btn btn-success btn-md']")
    public static WebElement viewCartAfterAddCart;



}

