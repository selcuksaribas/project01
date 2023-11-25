package app.US_15;

import app.utilities.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import app.pages.HomePage;
import app.pages.ManageProductsPage;
import static org.testng.AssertJUnit.assertTrue;


public class TC_03 {

    @Test
    public void TC_03(

    ) {


        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage = new HomePage();
        ManageProductsPage manageProductsPage = new ManageProductsPage();

        homePage.signInOption.click();
        homePage.emailOrUsername.sendKeys(ConfigReader.getProperty("email"));
        homePage.password.sendKeys(ConfigReader.getProperty("psw"));
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
        manageProductsPage.category.click();
        WaitUtils.waitFor(2);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
        manageProductsPage.productBrands.click();
        WaitUtils.waitFor(2);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
        manageProductsPage.sku_input.sendKeys("2");
        WaitUtils.waitFor(2);
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
        WaitUtils.waitFor(2);
        manageProductsPage.stockManage.click();
        WaitUtils.waitFor(2);
        manageProductsPage.stockQuantity.sendKeys("2");
        WaitUtils.waitFor(2);
       // manageProductsPage.backordersSelect.isSelected();
        manageProductsPage.soldIndButton.click();




    }
}