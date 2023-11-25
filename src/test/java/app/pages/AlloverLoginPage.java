package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverLoginPage {
    public AlloverLoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "reg_username")
    public WebElement userName;

    @FindBy(id = "reg_email")
    public WebElement eMail;

    @FindBy(id = "reg_password")
    public WebElement Password;

    @FindBy(id = "register-policy")
    public WebElement policyButton;

    @FindBy(xpath = "//button[@class='woocommerce-Button woocommerce-button button woocommerce-form-register__submit']")
    public WebElement registerButton;
}
