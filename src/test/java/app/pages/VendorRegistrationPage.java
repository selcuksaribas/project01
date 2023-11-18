package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorRegistrationPage {
    public VendorRegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="user_email") public WebElement vendorRegister_Email;
    @FindBy(name = "wcfm_email_verified_input") public WebElement verificationCode;
    @FindBy(name = "wcfm_email_verified_button") public WebElement resendCodeButton;
    @FindBy(id = "passoword") public WebElement vendorPassword;
    @FindBy(id = "confirm_pwd") public WebElement vendorConfirmPassword;
    @FindBy(id = "password_strength") public WebElement vendorPasswordStrength;
    @FindBy(name = "save-data") public WebElement registerButton;
    @FindBy(xpath = "//a[.='Not right now']") public WebElement notRightNowButton;
    @FindBy(xpath = "//a[.='Let's go!'])") public WebElement letsGoButton;
    @FindBy(linkText = "My Account") public WebElement myAccountLink;
    @FindBy(xpath = "//span[@class='wcicon-status-completed']") public WebElement verificationCodeMessage;
    @FindBy(xpath = "//*[.='Email: This field is required.']") public WebElement emailRequireMessage;
    @FindBy(xpath = "//*[@id=\"wcfm_membership_registration_form\"]/div[3]/span") public WebElement applyAsVendorMessage;
    @FindBy(xpath ="//*[@id=\"wcfm_membership_registration_form_expander\"]/div[2]") public WebElement invalidVerificationCodeMessage;
    @FindBy(xpath = "//*[@id=\"wcfm_membership_registration_form_expander\"]/div[2]") public WebElement fieldRequired;
    @FindBy(css=".breadcrumb li:nth-child(3)") public WebElement breadCrumb;
    @FindBy(xpath = "//*[@class='button button-large']") public WebElement largeRightButton;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-error']") public WebElement thisEmailAlreadyExistMessage;
    @FindBy(xpath = "//h2[@class='page-title']") public WebElement  vendorRegistrationPageTitle;
    @FindBy(xpath = "//input[@class='wcfm-text wcfm_ele wcfm_validation_failed']") public WebElement confirmPasswordIsRequired;
}
