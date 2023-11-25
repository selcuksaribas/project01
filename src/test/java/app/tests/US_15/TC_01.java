package app.tests.US_15;

import app.utilities.*;
import app.pages.*;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class TC_01 {

      @Test
      public void TC_001(

              ) {


            Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
            HomePage homePage=new HomePage();
            ManageProductsPage manageProductsPage=new ManageProductsPage();

            homePage.signInOption.click();
            homePage.emailOrUsername.sendKeys("sblbtl87@gmail.com");
            homePage.password.sendKeys("Sibelbetul1987");
            homePage.rememberMeCheckBox.click();
            homePage.signInButton.click();
            WaitUtils.waitFor(2);
            JSUtils.JSscrollAllTheWayDown();
            WaitUtils.waitFor(2);
            manageProductsPage.accountButton1.click();
           // manageProductsPage.accountButton.click();
            WaitUtils.waitFor(2);
            manageProductsPage.storeManagerButton.click();
            WaitUtils.waitFor(2);
            manageProductsPage.productsButton.click();
            WaitUtils.waitFor(2);
            manageProductsPage.addNewButton.click();
            ActionsUtil.actionsScrollDown();
           assertTrue(manageProductsPage.inventoryButton.isDisplayed());
           assertTrue(manageProductsPage.shippingButton.isDisplayed());
           assertTrue(manageProductsPage.AttributesButton.isDisplayed());
           assertTrue(manageProductsPage.seoButton.isDisplayed());
           assertTrue(manageProductsPage.advancedButton.isDisplayed());


      }
}