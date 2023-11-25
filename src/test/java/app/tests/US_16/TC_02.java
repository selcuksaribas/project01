package US_16;

import app.utilities.ActionsUtil;
import app.utilities.ConfigReader;
import app.utilities.Driver;

import app.utilities.WaitUtils;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ManageProductsPage;
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
        manageProductsPage.accountButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.storeManagerButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.productsButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.addNewButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.AttributesButton.click();
        WaitUtils.waitFor(2);
        manageProductsPage.colorDropdown.isSelected();
        WaitUtils.waitFor(2);
        manageProductsPage.sizeDropdown.isSelected();
        WaitUtils.waitFor(2);
        manageProductsPage.submitButton.click();
        assertTrue(manageProductsPage.addedToCard.isDisplayed());





    }
}