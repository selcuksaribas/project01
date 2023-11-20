package app.pages;


import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ComparePopUpWindowPage {

    public ComparePopUpWindowPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(className = "compare-popup")
    public WebElement compareWindow;

    @FindBy(xpath = "//p[contains(text(),'Products')]")
    public WebElement numberOfProducts;

    @FindBy(className = "compare-slider")
    public WebElement productList;

    @FindBy(className = "slider-slide")
    public List<WebElement> individualProducts;

    @FindBy(className = "btn-remove")
    public List<WebElement> removeProductButtons;

    @FindBy(className = "compare-clean")
    public WebElement cleanAllButton;

    @FindBy(className = "btn-dark")
    public WebElement startCompareButton;
}

