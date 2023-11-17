package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorSignINPage {
    public VendorSignINPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "username") public WebElement signInWidget;
    @FindBy(id = "username") public WebElement usernameInput;
    @FindBy(id = "password") public WebElement passwordInput;
    @FindBy(xpath = " //h2[@class='page-title']") public WebElement myAccount;
    @FindBy(name = "login") public WebElement signInButton;
}
