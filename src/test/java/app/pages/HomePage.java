package app.pages;


import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath= "//button[@value=\"Sign In\"]") public WebElement getSignInButton;
    
    @FindBy(id = "rememberme")public WebElement rememberMeCheckBox;
    @FindBy(name = "login")public WebElement signInButton;
 
    @FindBy(xpath = "//a[contains(text(),'Confirm and log out')]")public WebElement confirmLogoutButton;
 

    @FindBy (xpath = "//i[@class=\"w-icon-account\"]") public WebElement accountSymbol;



    // REGISTER LINKS

    @FindBy(xpath = "//span[.='Register']") public WebElement register_Link;

    //SIGN UP
    @FindBy(xpath = "//div[@id='customer_login']//a[.='Sign Up']") public WebElement signUp_Tab;
    //SIGN UP BECOME A VENDOR
    @FindBy(xpath = "//div[@id='customer_login']//a[.='Become a Vendor']") public WebElement signUp_BecomeVendorLink;
    @FindBy(xpath = "(//button[@type='submit'])[1]") public WebElement searchIcon;


 

    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    public static WebElement signInOption;

    @FindBy(id = "username")
    public static WebElement emailOrUsername;

    @FindBy(id = "password")
    public static WebElement password;

    @FindBy(name = "login")
    public static WebElement signInButton;

    @FindBy(xpath = "(//input[@type='search'])[1]")
    public static WebElement searchBox;

    @FindBy(xpath = "//div[@class='autocomplete-suggestions']//div[.='man boot']")
    public static WebElement elementInAutoSuggestion;

    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")
    public WebElement signOutButton;



}
