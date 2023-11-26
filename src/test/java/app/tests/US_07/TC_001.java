package app.tests.US_07;

import app.pages.ComparePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC_001 {

    private WebDriver driver;
    private ComparePage comparePage;

    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();

        // Initialize Page Object
        comparePage = new ComparePage();

        // Navigate to the Compare Page (replace with the actual URL)
        driver.get("https://allovercommerce.com/compare-page-url");
    }

    @Test
    public void compareProduct() {
        // Example usage: Click on the search button
        comparePage.searchButton.click();

        // Example usage: Click on the compare button on the product page
        comparePage.compareButton.click();

        // Example usage: Click on the start compare button in the pop-up window
        comparePage.startCompareButton.click();

        // Handle window switching if needed
        // You might need to switch to the new window to interact with elements on the pop-up
        // Example: driver.switchTo().window("window_handle");

        // Additional interactions with elements on the Compare Page if needed
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after the test
        if (driver != null) {
            driver.quit();
        }
    }
}
