package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderDetailsPage {
    public OrderDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/section[1]/table/tfoot/tr[1]/th") public WebElement subTotal;
    @FindBy (xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/section[1]/table/tfoot/tr[2]/th") public WebElement shippingDetails;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/section[1]/table/tfoot/tr[3]/th") public WebElement paymentDetails;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/div/div/div/div/div/section[1]/table/tfoot/tr[4]/th") public WebElement total;
}
