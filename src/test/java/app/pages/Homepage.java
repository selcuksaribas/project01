package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath= "//button[@value=\"Sign In\"]") public WebElement getSignInButton;
    @FindBy(xpath = "//span[contains(text(),'Sign In')]")public WebElement signInOption;
    @FindBy(id = "username")public WebElement emailOrUsername;
    @FindBy(id = "password")public WebElement password;
    @FindBy(id = "rememberme")public WebElement rememberMeCheckBox;
    @FindBy(name = "login")public WebElement signInButton;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")public WebElement signOutButton;
    @FindBy(xpath = "//a[contains(text(),'Confirm and log out')]")public WebElement confirmLogoutButton;
    @FindBy(xpath = "(//input[@type='search'])[1]")public WebElement searchBox;
    @FindBy(xpath = "//div[@class='autocomplete-suggestions']//div[.='man boot']")public WebElement elementInAutoSuggestion;
    @FindBy (xpath = "//i[@class=\"w-icon-account\"]") public WebElement accountSymbol;
    @FindBy(xpath = "//span[.='Register']") public WebElement register_Link;
    @FindBy(xpath = "//div[@id='customer_login']//a[.='Sign Up']") public WebElement signUp_Tab;
    @FindBy(xpath = "//div[@id='customer_login']//a[.='Become a Vendor']") public WebElement signUp_BecomeVendorLink;
    @FindBy(xpath = "(//button[@type='submit'])[1]") public WebElement searchIcon;

    ///////////This line added by Halil /////////////
    ///////this page name should be search result page
    //after search  adding items to wishlist
    @FindBy(xpath = "(//figure[@class='product-media'])[1]")
    public WebElement searchResult1;
    @FindBy(xpath = "(//figure[@class='product-media'])[2]")
    public WebElement searchResult2;
    @FindBy(xpath = "(//figure[@class='product-media'])[3]")
    public WebElement searchResult3;


    //for first item
    @FindBy(xpath = "(//div[@class='yith-wcwl-add-button'])[1]")
    public WebElement searchResult1WishIcon;
    //for second item
    @FindBy(xpath = "(//div[@class='yith-wcwl-add-button'])[2]")
    public WebElement searchResult2WishIcon;
    @FindBy(xpath = "(//div[@class='yith-wcwl-add-button'])[3]")
    public WebElement searchResult3WishIcon;

    //item after added wishlist new form of wish icon
    @FindBy(xpath = "(//div[@class='yith-wcwl-wishlistaddedbrowse'])[1]")
    public WebElement searchResult1WishIconAdded;
    //for second item
    @FindBy(xpath = "(//div[@class='yith-wcwl-wishlistaddedbrowse'])[2]")
    public WebElement searchResult2WishIconAdded;
    @FindBy(xpath = "(//div[@class='yith-wcwl-wishlistaddedbrowse'])[3]")
    public WebElement searchResult3WishIconAdded;

    //wishlistpagebutton
    @FindBy(xpath = "//i[@class='w-icon-heart']")
    public WebElement wishListPageButton;

    //scroll up button
    @FindBy(xpath = "//i[@class='w-icon-angle-up']")
    public WebElement scrollUpPage;

    //item at wishlistPage
    @FindBy(xpath = "//table[@data-id='437']//td[5]") //first add cart button
    public WebElement wishAddedTable;

    //item at wishlistPage quick-view buttons
    @FindBy(xpath = "//table[@data-id='437']//td[5]//button") //first add cart button
    public WebElement wishAddedTableQuickView;

    //item at wishlistPage cart buttons for first
    @FindBy(xpath = "(//table[@data-id='437']//td[5]//a)[1]") //first add cart button
    public WebElement wishAddedTableCartButtonItem1;

    //item at wishlistPage cart buttons for second
    @FindBy(xpath = "(//table[@data-id='437']//td[5]//a)[2]") //first add cart button
    public WebElement wishAddedTableCartButtonItem2;

    //item added alert
    @FindBy(xpath = "//div[@class='woocommerce-message alert alert-simple alert-btn alert-success']")
    public WebElement itemAddedToCartAlert;

    //cart button
    @FindBy(xpath = "(//i[@class='w-icon-cart'])[1]")
    public WebElement cartButton;

    //checkout button
    @FindBy(xpath = "(//div[@class='cart-popup widget_shopping_cart dropdown-box']//a)[9]")
    public WebElement checkOutButton;





    //quick-view
    @FindBy(xpath = "//div[@class='product-meta-inner']")
    public WebElement wishAddedTableQuickViewProperties;

    //quick-view second element on properties //extra
    @FindBy(xpath = "(//div[@class='product-meta-inner']//a)[2]")
    public WebElement wishAddedTableQuickViewProperties2Element;

    ///////////This line added by Halil /////////////
}
