package app.tests.us_08;

import app.pages.CheckOutPageHalil;
import app.pages.HomePageHalil;
import app.utilities.ActionsUtil;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_004 {
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
    //-------TC_004------//
//14- User clicks first 'ADD TO CARD' button for each item in wishlist
//15- User see simple alert "“Apple” has been added to your cart."
//16- User clicks "Cart" button
//17- User clicks "CHECKOUT" button
//18- User fills in billing information
//19- User enters 'First name'
//20- User enters 'Last name'
//21- User enters 'Company name'
//22- User enters 'Country / Region'
//23- User enters 'Street address'
//24- User enters 'Town/City'
//25- User enters 'Province'
//26- User enters 'Postal Code'
//27- User enters 'Phone'
//28- User enters 'Email address'
//29- User choose "Payment Methods"
//30- User cliscks "PLACE ORDER"
//31- User clicks 'Ship to a different address?'
//32- User enters same data (19 to 26)
    @Test
    public void TC_004(){
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

    ////10- User clicks the 'add to wishlist' icon first three product on list
        for (int i = 0; i < 2; i++) {
            ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIcon);
            homePageHalil.searchResult1WishIcon.click();
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
        homePageHalil.wishListPageButton.click();

//13- User must see all chosen products on the wishlist page
        WaitUtils.waitFor(5);
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.wishAddedTableQuickView);
        Assert.assertTrue(homePageHalil.wishAddedTable.isDisplayed());

//14- User clicks first 'ADD TO CARD' button for each item in wishlist
        for (int i = 0; i < 2; i++) {
            homePageHalil.wishAddedTableCartButtonItem1.click();
            WaitUtils.waitFor(1);
//15- User see simple alert "“Apple” has been added to your cart."
            Assert.assertTrue(homePageHalil.itemAddedToCartAlert.isDisplayed());
            WaitUtils.waitFor(10);
            ActionsUtil.actionsScrollDown();
            WaitUtils.waitFor(1);
        }

//16- User clicks "Cart" button
        ActionsUtil.actionsScrollUp();
        WaitUtils.waitFor(1);
        homePageHalil.cartButton.click();

//17- User clicks "CHECKOUT" button
        WaitUtils.waitFor(1);
        homePageHalil.checkOutButton.click();


        //18- User fills in billing information
//Create page object for CheckOutPage
        CheckOutPageHalil checkOutPageHalil = new CheckOutPageHalil();

        //        19- User enters 'First name' ->	Halil
        checkOutPageHalil.firstName.clear();
        checkOutPageHalil.firstName.sendKeys("Halil");
//        20- User enters 'Last name' ->	TestNG
        checkOutPageHalil.lastName.clear();
        checkOutPageHalil.lastName.sendKeys("TestNG");
//        21- User enters 'Company name' ->	TechPro Education
        //?? checkOutPage.companyName.sendKeys("TechPro Education");
//        22- User enters 'Country / Region' ->	Canada
        checkOutPageHalil.countryStateDropdown().selectByVisibleText("Canada");

//        23- User enters 'Street address' ->	999 Java Street
        checkOutPageHalil.streetAddressFirstLine.clear();
        checkOutPageHalil.streetAddressFirstLine.sendKeys("999 Java Street");
//        24- User enters 'Town/City' ->	Toronto
        checkOutPageHalil.townCity.clear();
        checkOutPageHalil.townCity.sendKeys("Toronto");
//        25- User enters 'Province' ->	Ontario
        checkOutPageHalil.provinceStateDropdown().selectByVisibleText("Ontario");
//        26- User enters 'Postal Code' ->	M5V 3L9
        checkOutPageHalil.postCodeZIP.clear();
        checkOutPageHalil.postCodeZIP.sendKeys("M5V 3L9");
//        27- User enters 'Phone' ->	4679872143
        checkOutPageHalil.phone.clear();
        checkOutPageHalil.phone.sendKeys("4679872143");
//        28- User enters 'Email address' ->	halile.test.ng@gmail.com
        //if it s allready written you can check by JavaScript
//        checkOutPage.email.sendKeys("halile.test.ng@gmail.com");

        //extra
        checkOutPageHalil.orderNote.sendKeys("This purchase for test reasons");

//        29- User choose "Payment Methods" ->	Wire transfer/EFT' or 'Pay at door'
        WaitUtils.waitFor(1);
        ActionsUtil.actionsScrollDown();

        WaitUtils.waitFor(3);
        checkOutPageHalil.payAtTheDoorNew.click();

        //if you want to use wire/eft option
//        WaitUtils.waitFor(1);
//        ActionsUtil.actionsScrollUp();
//        WaitUtils.waitFor(3);
//        checkOutPage.wireTransferEFT.click();
//        WaitUtils.waitFor(1);
//        ActionsUtil.actionsScrollDown();

        //30- User cliscks "PLACE ORDER"
        checkOutPageHalil.placeOrderButton.click();

        //31- see alarm for report
        WaitUtils.waitFor(1);
        Assert.assertTrue(checkOutPageHalil.noShippingMethodAlert.isDisplayed());


    }

    @Test
    public void TC_004CheckoutPage(){
        Driver.getDriver().get("https://allovercommerce.com/checkout-2/");
        //2- User clicks on the Sign-in button at home page
        //Create page object for HomePage
        HomePageHalil homePageHalil = new HomePageHalil();
        CheckOutPageHalil checkOutPageHalil = new CheckOutPageHalil();

        homePageHalil.signInOption.click();
        //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys(ConfigReader.getProperty("us_08_username"));
        //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys(ConfigReader.getProperty("us_08_password"));
        //5- User clicks on the Sign-in button at login page
        homePageHalil.rememberMeCheckBox.click();
        //6- User is able to Sign In
        homePageHalil.signInButton.click();

        WaitUtils.waitFor(1);
        checkOutPageHalil.checkOutButton.click();

        //        19- User enters 'First name' ->	Halil
        checkOutPageHalil.firstName.clear();
        checkOutPageHalil.firstName.sendKeys("Halil");
//        20- User enters 'Last name' ->	TestNG
        checkOutPageHalil.lastName.clear();
        checkOutPageHalil.lastName.sendKeys("TestNG");
//        21- User enters 'Company name' ->	TechPro Education
       //?? checkOutPage.companyName.sendKeys("TechPro Education");
//        22- User enters 'Country / Region' ->	Canada
        checkOutPageHalil.countryStateDropdown().selectByVisibleText("Canada");

//        23- User enters 'Street address' ->	999 Java Street
        checkOutPageHalil.streetAddressFirstLine.sendKeys("999 Java Street");
//        24- User enters 'Town/City' ->	Toronto
        checkOutPageHalil.townCity.clear();
        checkOutPageHalil.townCity.sendKeys("Toronto");
//        25- User enters 'Province' ->	Ontario
        checkOutPageHalil.provinceStateDropdown().selectByVisibleText("Ontario");
//        26- User enters 'Postal Code' ->	M5V 3L9
        checkOutPageHalil.postCodeZIP.clear();
        checkOutPageHalil.postCodeZIP.sendKeys("M5V 3L9");
//        27- User enters 'Phone' ->	4679872143
        checkOutPageHalil.phone.clear();
        checkOutPageHalil.phone.sendKeys("4679872143");
//        28- User enters 'Email address' ->	halile.test.ng@gmail.com
        //if it s allready written you can check by JavaScript
//        checkOutPage.email.sendKeys("halile.test.ng@gmail.com");

        //extra
        checkOutPageHalil.orderNote.sendKeys("This purchase for test reasons");

//        29- User choose "Payment Methods" ->	Wire transfer/EFT' or 'Pay at door'
        WaitUtils.waitFor(1);
        ActionsUtil.actionsScrollDown();

        WaitUtils.waitFor(3);
        checkOutPageHalil.payAtTheDoorNew.click();

        //if you want to use wire/eft option
//        WaitUtils.waitFor(1);
//        ActionsUtil.actionsScrollUp();
//        WaitUtils.waitFor(3);
//        checkOutPage.wireTransferEFT.click();
//        WaitUtils.waitFor(1);
//        ActionsUtil.actionsScrollDown();

        //30- User cliscks "PLACE ORDER"
        checkOutPageHalil.placeOrderButton.click();

//31- see alarm for report
        WaitUtils.waitFor(1);
        Assert.assertTrue(checkOutPageHalil.noShippingMethodAlert.isDisplayed());

        Driver.closeDriver();
    }

}
