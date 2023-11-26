package app.tests.US_15;
import app.pages.*;
import app.utilities.*;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



import static org.testng.AssertJUnit.assertTrue;


public class TC_02 {

    @Test
    public void TC_02(

    ) {


        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage = new HomePage();
        ManageProductsPage manageProductsPage = new ManageProductsPage();

        homePage.signInOption.click();
        homePage.emailOrUsername.sendKeys("sblbtl87@gmail.com");
        homePage.password.sendKeys("Sibelbetul1987");
        homePage.rememberMeCheckBox.click();
        homePage.signInButton.click();
        WaitUtils.waitFor(2);
        JSUtils.JSscrollAllTheWayDown();
        WaitUtils.waitFor(2);
        manageProductsPage.accountButton1.click();
        WaitUtils.waitFor(2);
        manageProductsPage.storeManagerButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.productsButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.addNewButton.click();
        WaitUtils.waitFor(2);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();

        assertTrue(manageProductsPage.productTypeDropdown.isDisplayed());
        manageProductsPage.virtualOption.click();
        manageProductsPage.downloadableOption.click();
        manageProductsPage.proTitle.sendKeys("bag");
        manageProductsPage.regPrice.sendKeys("100");
        manageProductsPage.salePrice.sendKeys("80");
      //  manageProductsPage.addShortMedia.click();
      //  manageProductsPage.addMedia.click();







        Driver.closeDriver();







    }}


