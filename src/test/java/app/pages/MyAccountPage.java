package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(linkText = "Addresses") public WebElement addressesButton;
    @FindBy(partialLinkText = "Orders") public WebElement ordersButton;
    @FindBy(linkText = "Store Manager") public WebElement storeManagerButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[2]/div/a") public WebElement editYourShippingAddressButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/div[1]/div/a") public WebElement editYourBillingAddressButton;
    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-products']") public WebElement productsButton;
    @FindBy(xpath = "//a[.='Store Manager']") public WebElement storeManager;
    @FindBy(xpath = "//a[.='Addresses']") public WebElement addresses;
    @FindBy(xpath = "//a[@class=\"btn btn-dark btn-rounded btn-icon-right continue-shopping mb-4 mt-6\"]") public WebElement goShopButton;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/table/tbody/tr[1]/td[5]/a[1]") public WebElement viewButton;
    @FindBy(id = "add_new_product_dashboard") public WebElement addNewButton;
    @FindBy(linkText = "Account details") public WebElement accountDetailsButton;
    @FindBy(id = "account_first_name") public WebElement accountFirstNameButton;
    @FindBy(id = "account_last_name") public WebElement accountLastNameButton;
    @FindBy(xpath = "//*[text()='Address changed successfully.']") public WebElement billingAddressChangedSuccessfully;
}
