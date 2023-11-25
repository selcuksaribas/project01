package US_16;

import app.utilities.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManageProductsPage;
import static org.testng.AssertJUnit.assertTrue;


public class TC_01 {

    @Test
    public void TC_001(

    ) {

        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        HomePage homePage=new HomePage();
        ManageProductsPage manageProductsPage=new ManageProductsPage();

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
        new Actions(Driver.getDriver()).sendKeys(Keys.PAGE_DOWN).perform();
        manageProductsPage.shippingButton.click();//element intercepted
        WaitUtils.waitFor(2);
        manageProductsPage.weight_input.sendKeys("20");
        WaitUtils.waitFor(2);
        manageProductsPage.length_input.sendKeys("12");
        WaitUtils.waitFor(2);
        manageProductsPage.height_input.sendKeys("23");
        WaitUtils.waitFor(2);
        manageProductsPage.shippingClassButton.click();
        WaitUtils.waitFor(2);
      //  assertTrue(manageProductsPage.processingTime.isSelected());











    }}