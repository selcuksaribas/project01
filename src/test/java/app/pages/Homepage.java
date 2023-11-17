package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

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
