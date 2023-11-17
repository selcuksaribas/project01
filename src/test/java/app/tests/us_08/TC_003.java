package app.tests.us_08;

import app.pages.HomePage;
import app.utilities.ActionsUtil;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_003 {
//1- User should navigate to "https://allovercommerce.com/"
//2- User clicks on the Sign-in button at home page
//3- User enters valid Username or email address
//4- User enters valid password
//5- User clicks on the Sign-in button at login page
//6- User is able to Sign In
//7- User clicks on to the 'search box'
//8- User enter a product name
//9- User clicks the 'search icon'
    //-------TC_002-------//
//10- User clicks the 'add to wishlist' icon first three product on list
//11- User must see color of 'add to wishlist' icons changed for each products
//12- User clicks 'wishlist' icon top on the page
//13- User must see all choosen product on the wishlist page
    //-------TC_003-------//
//14- User clicks first 'QUICK VIEW' button
//15- User able to see the properties of the product for first product
    @Test
    public void TC_003(){
        System.out.println("I m starting coding for TC_002");

    //1- User should navigate to "https://allovercommerce.com/"
        //option1
        //Driver.getDriver().get("https://allovercommerce.com/");
        //option2
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));

        //get the page title
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("allover_commerce_title")));

    //2- User clicks on the Sign-in button at home page
        //Create page object for HomePage
        HomePage homePage = new HomePage();
        homePage.signInOption.click();
    //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePage.emailOrUsername.sendKeys(ConfigReader.getProperty("us_08_username"));
    //4- User enters valid password ==> property=>us_08_password (testng)
        homePage.password.sendKeys(ConfigReader.getProperty("us_08_password"));
    //5- User clicks on the Sign-in button at login page
        homePage.rememberMeCheckBox.click();
    //6- User is able to Sign In
        homePage.signInButton.click();
        //wait may need if the internet connection is slow or website is slow
        Assert.assertTrue(homePage.signOutButton.isDisplayed());
    //7- User clicks on to the 'search box'
        homePage.searchBox.click();
    //8- User enter a product name ==> apple
        homePage.searchBox.sendKeys("apple");
        //homePage.searchBox.sendKeys("apple" + Keys.ENTER); //alternative

        //????????????try to use JavaSkiprit here??????????????????
        //assert if its able to type apple

    //9- User clicks the 'search icon'
        homePage.searchIcon.click();

    ////10- User clicks the 'add to wishlist' icon first three product on list
        for (int i = 0; i < 2; i++) {
            System.out.println(i);
            ActionsUtil.actionsHoverOverOnElement(homePage.searchResult1WishIcon);
            homePage.searchResult1WishIcon.click();
            WaitUtils.waitFor(5);
        }

//11- User must see color of 'add to wishlist' icons changed for each products
        //we check at TC_001 we skip that
//        WaitUtils.waitFor(3);
//        JSUtils.JSscrollIntoView(homePage.searchResult1WishIconAdded);
//        ActionsUtil.actionsHoverOverOnElement(homePage.searchResult1WishIconAdded);
//        Assert.assertTrue(homePage.searchResult1WishIconAdded.isDisplayed());

//12- User clicks 'wishlist' icon top on the page
//        ActionsUtil.actionsHoverOverOnElement(homePage.wishListPageButton);
        homePage.wishListPageButton.click();

//13- User must see all chosen products on the wishlist page
        WaitUtils.waitFor(5);
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);
        ActionsUtil.actionsHoverOverOnElement(homePage.wishAddedTableQuickView);
        Assert.assertTrue(homePage.wishAddedTable.isDisplayed());

        //14- User clicks first 'QUICK VIEW' button
        homePage.wishAddedTableQuickView.click();

        //15- User able to see the properties of the product for first product
        WaitUtils.waitFor(5);
        Assert.assertTrue(homePage.wishAddedTableQuickViewProperties.isDisplayed());

        //extra
        homePage.wishAddedTableQuickViewProperties2Element.click();

        Driver.closeDriver();

    }

}
