package app.pages;


import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class HomePage {
    //    1. create constructor
//    2. create page objects
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[contains(text(),'Sign In')]")public WebElement signInOption;
    @FindBy(id = "username")public WebElement emailOrUsername;
    @FindBy(id = "password")public WebElement password;
    @FindBy(id = "rememberme")public WebElement rememberMeCheckBox;
    @FindBy(name = "login")public WebElement signInButton;
    @FindBy(xpath = "//span[contains(text(),'Sign Out')]")public WebElement signOutButton;
    @FindBy(xpath = "//a[contains(text(),'Confirm and log out')]")public WebElement confirmLogoutButton;
    @FindBy(xpath = "(//input[@type='search'])[1]")public WebElement searchBox;
    @FindBy(xpath = "//div[@class='autocomplete-suggestions']//div[.='man boot']")public WebElement elementInAutoSuggestion;

}
