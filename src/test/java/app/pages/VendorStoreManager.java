package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorStoreManager {
    public VendorStoreManager(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@class='wcfm_welcomebox_user_details rgt']")public WebElement WelcomeAlloverCommerceMessage;
    @FindBy(xpath = "//span[@class='wcfmfa fa-power-off']") public WebElement LogOutButton;
}
