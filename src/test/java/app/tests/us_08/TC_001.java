package app.tests.us_08;

import app.pages.HomePageHalil;
import app.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_001 {
//1- User should navigate to "https://allovercommerce.com/"
//2- User clicks on the Sign-in button at home page
//3- User enters valid Username or email address
//4- User enters valid password
//5- User clicks on the Sign-in button at login page
//6- User is able to Sign In
//7- User clicks on to the 'search box'
//8- User enter a product name
//9- User clicks the 'search icon'
//10- User clicks the 'add to wishlist' icon first product on list
//11- User must see color of 'add to wishlist' icon changed
    @Test
    public void TC_001(){
        System.out.println("I m starting coding");

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
        HomePageHalil homePageHalil = new HomePageHalil();
        homePageHalil.signInOption.click();


    //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys(ConfigReader.getProperty("us_08_username"));
    //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys(ConfigReader.getProperty("us_08_password"));
    //5- User clicks on the Sign-in button at login page
        homePageHalil.rememberMeCheckBox.click();
    //6- User is able to Sign In
        homePageHalil.signInButton.click();
        //wait may need if the internet connection is slow or website is slow
        Assert.assertTrue(homePageHalil.signOutButton.isDisplayed());
    //7- User clicks on to the 'search box'
        homePageHalil.searchBox.click();
    //8- User enter a product name ==> apple
        homePageHalil.searchBox.sendKeys("apple");
        //homePage.searchBox.sendKeys("apple" + Keys.ENTER); //alternative

        //????????????try to use JavaSkiprit here??????????????????
        //assert if its able to type apple

    //9- User clicks the 'search icon'
        homePageHalil.searchIcon.click();

    //10- User clicks the 'add to wishlist' icon first product on list
        //JSUtils.JSscrollIntoView(homePage.searchResult1);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIcon);
        homePageHalil.searchResult1WishIcon.click();
//        JSUtils.JSscrollIntoView(homePage.searchResult2);
//        ActionsUtil.actionsHoverOverOnElement(homePage.searchResult2WishIcon);

    //11- User must see color of 'add to wishlist' icon changed
        WaitUtils.waitFor(3);
        JSUtils.JSscrollIntoView(homePageHalil.searchResult1WishIconAdded);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIconAdded);
        Assert.assertTrue(homePageHalil.searchResult1WishIconAdded.isDisplayed());


        Driver.closeDriver();
    }
}
