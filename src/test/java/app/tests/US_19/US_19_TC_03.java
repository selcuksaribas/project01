package app.tests.US_19;

import app.pages.CartPage;
import app.pages.CheckoutPage;
import app.pages.HomePage;
import app.pages.ProductPage;
import app.utilities.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_19_TC_03 {
    public static void main(String[] args) {
        System.out.println("This is class level 19-03 - Before @Test annotation");
    }
    @Test
    public void US_19_TC_03(){
        HomePage homepage = new HomePage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();
        CheckoutPage checkoutPage = new CheckoutPage();
        Actions actions = new Actions(Driver.getDriver());
//        Sign in as a user
        Driver.getDriver().get("https://www.allovercommerce.com");
        WaitUtils.waitFor(5);
        homepage.signInOption.click();
        homepage.emailOrUsername.sendKeys("selcuk.testng@gmail.com");
        homepage.password.sendKeys("selcuk.testng");
        homepage.rememberMeCheckBox.click();
        homepage.signInButton.click();
        WaitUtils.waitFor(2);

//        This step is for removing of any products if they are exist in cart before the test
        productPage.cartIcon.click();
        WaitUtils.waitFor(1);

        try {
            productPage.removeFromCartButton.click();
            WaitUtils.waitFor(1);
        }catch (NoSuchElementException e){
        }
        productPage.closeCartIconWindow.click();
//        Select product from auto-suggestion
        homepage.searchBox.sendKeys("man boo");
        homepage.elementInAutoSuggestion.click();
        WaitUtils.waitFor(2);
        JSUtils.JSscrollIntoView(productPage.addToCartButton);
        WaitUtils.waitFor(1);
//        Click on “Add to Cart” button
        productPage.addToCartButton.click();
//        Assert the success message is displayed
        Assert.assertTrue(productPage.productAddedSuccessAlert.isDisplayed());
//        Click on the Cart button and select “View Cart” option
        productPage.cartIcon.click();
        WaitUtils.waitFor(1);
        productPage.viewCartButton.click();
        WaitUtils.waitFor(2);
//        Increase product quantity 3 times and decrease 2 times and click on update cart button
        int increaseNumber = 3;
        for (int i=0 ; i<increaseNumber; i++){
            cartPage.plusIcon.click();
        }
        int decreaseNumber = 2;
        for (int i=0 ; i<decreaseNumber; i++){
            cartPage.minusIcon.click();
        }
        WaitUtils.waitFor(1);
        cartPage.updateCartButton.click();
        WaitUtils.waitFor(4);
//        Assert the product amount is 2
        String actualQuantityValue = cartPage.productQuantity.getAttribute("value");
        String totalValue = String.valueOf(increaseNumber-decreaseNumber+1);
        Assert.assertEquals(actualQuantityValue, totalValue,"Quantity Value is not as expected");

//        Enter the shipping address and click on “update totals” button
        BrowserUtils.dropdownSelectByValue(cartPage.countryDropdown, "TR");
        WaitUtils.waitFor(1);
        JSUtils.JSscrollIntoView(cartPage.stateDropdown);
        WaitUtils.waitFor(1);
        BrowserUtils.dropdownSelectByValue(cartPage.stateDropdown,"TR06");
        cartPage.townCityBox.clear();
        cartPage.townCityBox.sendKeys("Ankara");
        cartPage.postCodeZIPBox.clear();
        cartPage.postCodeZIPBox.sendKeys("123");
        JSUtils.JSscrollIntoView(cartPage.updateTotalButton);
        WaitUtils.waitFor(2);
        cartPage.updateTotalButton.click();
        WaitUtils.waitFor(3);

//        Click on “proceed to checkout” button
        cartPage.proceedToCheckoutButton.click();
        WaitUtils.waitFor(2);

//        Click on coupon button and enter the coupon code
        checkoutPage.enterYourCodeButton.click();
        checkoutPage.couponCodeBox.sendKeys("112233");
        checkoutPage.applyCouponButton.click();
        WaitUtils.waitFor(2);

//        Enter the first_name and last_name
        checkoutPage.firstName.clear();
        checkoutPage.firstName.sendKeys("Selcuk");
        checkoutPage.lastName.clear();
        checkoutPage.lastName.sendKeys("Test");
        JSUtils.JSscrollIntoView(checkoutPage.countryRegionDropdown);
        WaitUtils.waitFor(1);

//           Leave the address area blank
//        BrowserUtils.dropdownSelectByValue(checkoutPage.countryRegionDropdown,"TR");
        checkoutPage.streetAddressFirstLine.clear();
//        checkoutPage.streetAddressFirstLine.sendKeys("123");
        checkoutPage.postCodeZIP.clear();
//        checkoutPage.postCodeZIP.sendKeys("123");
        checkoutPage.townCity.clear();
//        checkoutPage.townCity.sendKeys("Ankara");

//        WaitUtils.waitFor(1);
//        BrowserUtils.dropdownSelectByValue(checkoutPage.provinceStateDropdown,"TR06");
//        WaitUtils.waitFor(1);

        checkoutPage.phone.clear();
//        checkoutPage.phone.sendKeys("123");
        checkoutPage.email.clear();
        checkoutPage.email.sendKeys("selcuk.testng@gmail.com");

//        Select “wire transfer” and assert the “pay at the door” is clickable
        checkoutPage.wireTransferEFTButton.click();
        Assert.assertTrue(checkoutPage.payAtTheDoorButton.isEnabled());
        WaitUtils.waitFor(2);
        JSUtils.JSscrollIntoView(checkoutPage.placeOrderButton);
        WaitUtils.waitFor(1);

//        Click on place order button to finish process
        checkoutPage.placeOrderButton.click();
        WaitUtils.waitFor(4);

//        Assert the process is failed
        Assert.assertTrue(checkoutPage.alertTownCityRequired.isDisplayed());

//        I added signout option since next testcase starts with signin codes
        ActionsUtil.actionsScrollUp();
        WaitUtils.waitFor(1);
        homepage.signOutButton.click();
        WaitUtils.waitFor(1);
        homepage.confirmLogoutButton.click();
        WaitUtils.waitFor(1);

//        Close the driver
        Driver.closeDriver();
    }
}