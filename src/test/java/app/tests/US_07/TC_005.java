package app.tests.US_07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class TC_005 {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void deleteProductsFromConsolidationTest() {
        // Step 1: Login to the website (Assuming you have a login mechanism)
        // Your login code goes here

        // Step 2: Click on the search box
        WebElement searchBox = driver.findElement(By.id("search-box"));
        searchBox.click();

        // Step 3: Enter a product name
        searchBox.sendKeys("Product Name");

        // Step 4: Click the search icon
        WebElement searchIcon = driver.findElement(By.id("search-icon"));
        searchIcon.click();

        // Loop for selecting and adding products to wishlist
        for (int i = 0; i < 2; i++) {
            // Step 5: Select the product from listed products
            List<WebElement> productList = driver.findElements(By.cssSelector(".product"));
            WebElement selectedProduct = productList.get(i); // Assuming selecting the i-th product
            selectedProduct.click();

            // Step 6: Verify that the selected product is seen on the screen
            WebElement productTitle = driver.findElement(By.id("product-title"));
            assert productTitle.isDisplayed() : "Selected product is not displayed on the screen.";

            // Step 7: Click on "Wishlist" button to add to the wishlist
            WebElement wishlistButton = driver.findElement(By.id("wishlist-button"));
            wishlistButton.click();
        }

        // Step 8: Navigate to the consolidation screen
        WebElement consolidationScreenLink = driver.findElement(By.id("consolidation-screen-link"));
        consolidationScreenLink.click();

        // Step 9: Delete all products from the consolidation screen
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(".delete-button"));
        for (WebElement deleteButton : deleteButtons) {
            deleteButton.click();
        }

        // Step 10: Verify that all products are deleted
        List<WebElement> consolidatedProducts = driver.findElements(By.cssSelector(".consolidated-product"));
        assert consolidatedProducts.isEmpty() : "Products are not deleted from the consolidation screen.";

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
