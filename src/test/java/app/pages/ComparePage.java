package app.pages;

import app.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComparePage {

    public ComparePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // WebElement declarations for Compare Page

    // Search button on the Compare Page
    @FindBy(name = "s")
    public WebElement searchButton;

    // Compare button on the product page
    @FindBy(css = "a.compare.btn-product-icon")
    public WebElement compareButton;

    // Start compare button in the pop-up window
    @FindBy(css = "a.btn.btn-dark.btn-rounded")
    public WebElement startCompareButton;

    // Add methods to interact with elements on the Compare Page if needed
}

