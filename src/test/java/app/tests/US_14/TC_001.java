package app.tests.US_14;

import app.pages.AddProductsPage;
import app.pages.HomePage;
import app.pages.MyAccountPage;
import app.pages.ReusableMethods;
import app.utilities.*;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class TC_001 {




    /*
    Given
    User navigates to website
    And
    User clicks on sign in button on home page
    And
    User enters a valid email address
    And
    User enters a valid password
    And
    User clicks on Sign in button on login page
    And
    User clicks on Profile button
    And
    User clicks on Store Manager
    And
    User clicks on Products from the menu
    And
    User clicks on Add New button
    And
    User selects product type
    Then
    Verify Simple Product, Variable Product, Grouped Product, External-Affiliate Product options exist
    And
    User enters a product title
    And
    User clicks on large image field to add image
    And
    User clicks on Select Files
    And
    User chooses the file and clicks open
    And
    User clicks Select to add the Image
    And
    User clicks on small image field to add second image
    And
    User clicks on Upload Files tab
    And
    User clicks on Select Files
    And
    User chooses the file and clicks open
    And
    User clicks on Add to gallery button
    Then
    Verify image uploaded successfully
    And
    User enters a short description
    And
    User enters a description
    And
    User clicks on Add new category
    And
    User enters a category name
    And
    User clicks on Add button under category
    Then
    Verify category is added
    Then
    Verify Product Brand option exist
    And
    User clicks on Add new product brands
    And
    User enter the product brand
    And
    User clicks on add button under product brands
    And
    User clicks on Submit button
    Then
    Verify "Published" is visible
     */

    @Test
    public void TC_001() throws AWTException, IOException {

        ExtentReportUtils.createTestReport("Allover_commerce_test","TC_001");

        HomePage homePage = new HomePage();
        MyAccountPage myAccountPage = new MyAccountPage();
        AddProductsPage addProductsPage = new AddProductsPage();
        ReusableMethods reusableMethods = new ReusableMethods();
        Faker faker = new Faker();



//        User navigates to website
        Driver.getDriver().get("https://allovercommerce.com/");
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("allovercommerce"));
        ExtentReportUtils.passAndCaptureScreenshot("User is on the allovercommerce homepage");

//        User clicks on sign in button on home page
        homePage.signInOption.click();

//        User enters a valid email address
        homePage.emailOrUsername.sendKeys("erkamcavdar.testng@gmail.com");

//        User enters a valid password
        homePage.password.sendKeys("Ec5271996");

//        User clicks on Sign in button on login page
        homePage.signInButton.click();

//        User clicks on Profile button
        homePage.signOutButton.click();

//        User clicks on Store Manager
        myAccountPage.storeManagerButton.click();

//        User clicks on Products from the menu
        myAccountPage.productsButton.click();

//        User clicks on Add New button
        myAccountPage.addNewButton.click();
        WaitUtils.waitFor(2);

//        User selects product type

        Select selectProductType = new Select(addProductsPage.productTypeDropDown);
        selectProductType.selectByIndex(0);

//        Verify Simple Product, Variable Product, Grouped Product, External-Affiliate Product options exist

        //Assert options exist
        Assert.assertTrue(addProductsPage.productTypeDropDown.getText().contains("Simple Product"));
        Assert.assertTrue(addProductsPage.productTypeDropDown.getText().contains("Variable Product"));
        Assert.assertTrue(addProductsPage.productTypeDropDown.getText().contains("Grouped Product"));
        Assert.assertTrue(addProductsPage.productTypeDropDown.getText().contains("External/Affiliate Product"));

//        User enters a product title
        addProductsPage.proTitle.sendKeys("Gaming Table");

//        User clicks on large image field to add image
        addProductsPage.largeImageInput.click();

//        User clicks on Select Files
        addProductsPage.selectFilesButton.click();

//        User chooses the file and clicks open
        String pathOfFile1 = "C:\\Users\\Rabia\\Desktop\\GamingTable1.jpg";
        reusableMethods.uploadFile(pathOfFile1);
        WaitUtils.waitFor(1);

//        User clicks Select to add the Image
        addProductsPage.selectButton.click();

//        User clicks on small image field to add second image
        addProductsPage.smallImageInput.click();
        WaitUtils.waitFor(2);

//        User clicks on Upload Files tab
        JSUtils.JSclickWithTimeout(addProductsPage.uploadFilesButton);
        WaitUtils.waitFor(2);

//        User clicks on Select Files
        addProductsPage.selectFilesButton2.click();

//        User chooses the file and clicks open
        String pathOfFile2 = "C:\\Users\\Rabia\\Desktop\\GamingTable2.jpg";
        reusableMethods.uploadFile(pathOfFile2);
        WaitUtils.waitFor(1);

//        User clicks on Add to gallery button
        addProductsPage.addToGalleryButton.click();

//        Verify image uploaded successfully
        //Assert Images added successfully
        WaitUtils.waitFor(3);
        Assert.assertTrue(addProductsPage.removeSmallImgButton.isDisplayed());
        Assert.assertTrue(addProductsPage.removeLargeImgButton.isDisplayed());
        MediaUtils.takeScreenshotOfThisElement(addProductsPage.imageCategoryBrandVerify);

//        User enters a short description
        String shortDescription = "Gaming Desk 47 Inch Gamer Desk Carbon Fiber Surface Computer Workstation Home Office Ergonomic PC Desk Simple Gaming Table with Cup Holder & Headphone Hook";
        ActionsUtil.actionsScrollDown();
        Driver.getDriver().switchTo().frame("excerpt_ifr");
        addProductsPage.shortDescriptionInput.sendKeys(shortDescription);
        Driver.getDriver().switchTo().defaultContent();

//        User enters a description
        String description = "Large Gaming Surface, Ergonomic Design, Industrial-grade materials, Item weights 33.77 pounds";
        Driver.getDriver().switchTo().frame("description_ifr");
        addProductsPage.descriptionInput.sendKeys(description);
        Driver.getDriver().switchTo().defaultContent();
        WaitUtils.waitFor(2);

//        User chooses categories
        addProductsPage.categoryCheckbox1.click();
        WaitUtils.waitFor(2);
        addProductsPage.categoryCheckbox2.click();
        WaitUtils.waitFor(2);

//        Verify categories are clickable
        Assert.assertTrue(addProductsPage.categoryCheckbox1.isSelected());
        MediaUtils.takeScreenshotOfThisElement(addProductsPage.imageCategoryBrandVerify);
        WaitUtils.waitFor(2);
        addProductsPage.categoryCheckbox1.click();
        addProductsPage.categoryCheckbox2.click();
        WaitUtils.waitFor(2);

//        User clicks on Add new category
        addProductsPage.addNewCategoryButton.click();

//        User enters a category name
        String categoryName = faker.commerce().department();
//        String categoryName = "Deneme1996";
        addProductsPage.newCategoryInput.sendKeys(categoryName);

//        User clicks on Add button under category
        addProductsPage.categoryAddButton.click();
        WaitUtils.waitFor(5);

//        Verify category is added
        MediaUtils.takeScreenshotOfThisElement(addProductsPage.imageCategoryBrandVerify);
        List<WebElement> categoryElements = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']"));
        for(WebElement e : categoryElements){
//            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains(categoryName)); //Assert Category is added
        }

//        Verify Product Brand option exist
        MediaUtils.takeScreenshotOfThisElement(addProductsPage.imageCategoryBrandVerify);
        Assert.assertTrue(addProductsPage.productBrandVerify.isDisplayed());

//        User clicks on Add new product brands
        addProductsPage.addNewProductBrandsButton.click();
        WaitUtils.waitFor(2);

//        User enters the product brand
        String productName = faker.commerce().productName();
//        String productName = "Deneme1996";
        addProductsPage.newProductBrandInput.sendKeys(productName);
        WaitUtils.waitFor(2);

//        User clicks on add button under product brands
        addProductsPage.productAddButton.click();
        WaitUtils.waitFor(6);

//        Verify new product brand is added
        MediaUtils.takeScreenshotOfThisElement(addProductsPage.imageCategoryBrandVerify);
        List<WebElement> productBrandElements = Driver.getDriver().findElements(By.xpath("//ul[@id='product_brand']"));
        for(WebElement e : productBrandElements){
//            System.out.println(e.getText());
            Assert.assertTrue(e.getText().contains(productName)); //Assert Product brand is added
        }

//        User clicks on Submit button
        WaitUtils.waitFor(3);
        JSUtils.JSclickWithTimeout(addProductsPage.submitButton);
        WaitUtils.waitFor(6);
        MediaUtils.takeScreenshotOfTheEntirePageAsString();

//        Verify "Published" is visible
        WaitUtils.waitFor(5);
        Assert.assertTrue(addProductsPage.publishedVerify.isDisplayed());
        ExtentReportUtils.flush();

    }
}
