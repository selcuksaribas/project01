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

}
