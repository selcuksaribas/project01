package app.tests.US_07;
import app.pages.ComparePage;
import app.utilities.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TC_002 {
    private ChromeDriver driver;  // Use ChromeDriver to access specific methods

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void compareMultipleProductsTest() {
        // Assume that the driver is already logged in

        // Create an instance of ComparePage
        ComparePage comparePage = new ComparePage();

        // Perform steps for adding products to compare
        for (int i = 0; i < 4; i++) {
            // Assume that the search and selection steps are already implemented in ComparePage

        }

        // Click on ''Compare button'' on the product pictures
        comparePage.compareButton.click();

        // Click on ''Start compare'' button
        comparePage.startCompareButton.click();

        // Verify that all product features are compared
        WebElement comparisonResult = driver.findElement(By.id("comparison-result"));
        assert comparisonResult.isDisplayed() : "Product features are not compared successfully.";

        // Additional verifications or assertions if needed
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
