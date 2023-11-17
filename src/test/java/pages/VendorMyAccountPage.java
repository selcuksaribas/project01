package pages;
import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class VendorMyAccountPage {


    //    1. create constructor
//    2. create page objects
    public VendorMyAccountPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement dashboard;
    @FindBy(xpath = "//a[.='Store Manager']")
    public WebElement storeManager;
    @FindBy(xpath = "//a[.='Downloads']")
    public WebElement downloads;
    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addresses;
    @FindBy(xpath = "//a[.='Account details']")
    public WebElement accountDetails;
    @FindBy(xpath = "//a[.='Wishlist']")
    public WebElement wishlist;
    @FindBy(xpath = "//a[.='Support Tickets']")
    public WebElement supportTickets;

    @FindBy(xpath = "//a[.='Followings']")
    public WebElement followings;

    @FindBy (xpath ="//a[.='Orders']")
    public WebElement orders;

    @FindBy(xpath="//a[.='Logout']")
    public WebElement logout;

    @FindBy (xpath ="//a[.='Browse products']")
    public WebElement ordersBrowseProduct;
    @FindBy (xpath ="//a[.='recent orders']")
    public WebElement dashboardRecentOrders;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/div[3]/a")
    public WebElement downloadsGoShop;

    @FindBy(id="account_first_name")
    public WebElement accountDetailsFirstName;



    @FindBy(id="yith-wcwl-form")
    public WebElement wishlistGoShopWindow;


    @FindBy(xpath="//*[@id=\"main\"]/div/div/div/div/div/div/div/div[2]/table/thead/tr/th[3]/span")
    public WebElement supportTicketsCategory;


    @FindBy(xpath="//*[@id=\"main\"]/div/div/div/div/div/div/div/div[2]/table/thead/tr/th[3]/span")

    public WebElement followingsStore;


    @FindBy(xpath="//h2[.='Store Manager']")
    public WebElement storeManagerTitle;

}
