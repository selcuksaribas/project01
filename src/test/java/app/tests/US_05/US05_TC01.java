
package app.tests.US_05;

import app.pages.CartPage;
import app.pages.CheckoutPage;
import app.pages.HomePage;
import app.pages.ProductPage;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US05_TC01 {

    HomePage homepage = new HomePage();
    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US_05_TC_01() {
        //       Sign in as a user
        Driver.getDriver().get("https://www.allovercommerce.com");
        homepage.signInOption.click();
        homepage.emailOrUsername.sendKeys("Whissind47@armyspy.com");
        homepage.password.sendKeys("Kara1919!");
        homepage.rememberMeCheckBox.click();
        homepage.signInButton.click();
        WaitUtils.waitFor(2);
        homepage.searchBar.sendKeys("blue ski");
        homepage.searchedItemImage.click();
        productPage.productLabel.isDisplayed();
        Assert.assertTrue(productPage.productLabel.getText().contains("Blue Ski Boots"));
        productPage.productImage.isDisplayed();
        Assert.assertTrue(productPage.productPrice.getText().contains("$178.89"));
        productPage.addCartButton.click();
        Assert.assertTrue(productPage.successMsg.getText().contains("“Blue Ski Boots” has been added to your cart."));
        productPage.viewCartButton.click();
        cartPage.proceedToCheckoutButton.click();
        checkoutPage.payAtTheDoor.click();
        checkoutPage.placeOrderButton.click();
        Assert.assertTrue(productPage.orderReceivedMessage.getText().contains("Thank you. Your order has been received."));

    }

}
