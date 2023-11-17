package pages;
import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class VendorSignInPage {
    //    1. create constructor
//    2. create page objects
    public VendorSignInPage (){
        PageFactory.initElements(Driver.getDriver(),this);

    }




    @FindBy(xpath = "//span[.='Sign In']")
    public WebElement signInWidget;
    @FindBy(id = "username")
    public WebElement usernameInput;
    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(name = "login")
    public WebElement signInButton;

    @FindBy(id = "menu-item-1079")
    public WebElement myAccount;

}