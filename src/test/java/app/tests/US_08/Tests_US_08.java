package app.tests.US_08;

import app.pages.*;
import app.utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


//To Do Create @Before and @After annotations (high priority)
//              sign out may need (low priority)
//              for parallel testing, tests may need priority or grouping Because first TC_01 done then the other should come (low priority)

public class Tests_US_08 {

/*
    ADD EXTENT REPORTS CAPABILITY
    1. use createTestReport(String name,String description) first for creating extent report capability
    2. then use any method to mark as pass, info, fail
    3. Then use flush to generate the report
 */

    /*
    ADD LOGGER REPORT CAPABILITY
    1. use any method from LoggerUtils directly.
     */

    //-------TC_001--STARTS-------//
//1- User should navigate to "https://allovercommerce.com/"
//2- User clicks on the Sign-in button at home page
//3- User enters valid Username or email address
//4- User enters valid password
//5- User clicks on the Sign-in button at login page
//6- User is able to Sign In
    ////The Steps Above Repeat Before Each @Test
//7- User clicks on to the 'search box'
//8- User enter a product name
//9- User clicks the 'search icon'
//10- User clicks the 'add to wishlist' icon first product on list
//11- User must see color of 'add to wishlist' icon changed
    @Test
    public void TC_01(){
        LoggerUtils.info("Starting Test US_08 --> TC_01...");
        //1. use createTestReport(String name,String description) first for creating extent report capability
        ExtentReportUtils.createTestReport("US_08 Test Report","Test report for TC_01 Login website");
        //2. then use any method to mark as pass, info, fail
        ExtentReportUtils.pass("Starting Test US_08 --> TC_01...");
        //Create page object for HomePage
        HomePage homePageHalil = new HomePage();
        //1- User should navigate to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        ExtentReportUtils.pass("User At The Home Page...");
        //get the page title
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("allover_commerce_title")));
        //2- User clicks on the Sign-in button at home page
        homePageHalil.signInOption.click();
        ExtentReportUtils.info("User Name is : haliltestng and Password is : *****");
        //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys("haliltestng");
        //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys("testng");
        ExtentReportUtils.passAndCaptureScreenshot("User Name is : haliltestng and Password is : *****");
        //5- User clicks on the Sign-in button at login page
        homePageHalil.rememberMeCheckBox.click();
        ExtentReportUtils.pass("User Enter Credentials...");
        //6- User is able to Sign In
        homePageHalil.signInButton.click();
        //wait may need if the internet connection is slow or website is slow
        Assert.assertTrue(homePageHalil.signOutButton.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User Successfully SignIn...");
        //7- User clicks on to the 'search box'
        homePageHalil.searchBox.click();
        //8- User enter a product name ==> apple
        homePageHalil.searchBox.sendKeys("apple");
        ExtentReportUtils.pass("User Successfully Search...");
        //9- User clicks the 'search icon'
        homePageHalil.searchIcon.click();
        //10- User clicks the 'add to wishlist' icon first product on list
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIcon);
        homePageHalil.searchResult1WishIcon.click();
        //11- User must see color of 'add to wishlist' icon changed
        WaitUtils.waitFor(3);
        JSUtils.JSscrollIntoView(homePageHalil.searchResult1WishIconAdded);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIconAdded);
        ExtentReportUtils.passAndCaptureScreenshot("User Successfully Add The Item On Wish List...");
        Assert.assertTrue(homePageHalil.searchResult1WishIconAdded.isDisplayed());
        Driver.closeDriver();
        ExtentReportUtils.pass("Driver is Closed...Test Completed Successfully...");
        LoggerUtils.info("Driver is Closed...Test Completed Successfully...");

        //3. Then use flush to generate the report
        ExtentReportUtils.flush();
    }

//same with TC_01
    //-------TC_002--STARTS-------//
//10- User clicks the 'add to wishlist' icon first three product on list
//11- User must see color of 'add to wishlist' icons changed for each products
//12- User clicks 'wishlist' icon top on the page
//13- User must see all chosen product on the wishlist page
    @Test
    public void TC_02(){
        LoggerUtils.info("Starting Test US_08 --> TC_02...");
        //1. use createTestReport(String name,String description) first for creating extent report capability
        ExtentReportUtils.createTestReport("US_08 Test Report","Test report for TC_02 Login website");
        //2. then use any method to mark as pass, info, fail
        ExtentReportUtils.pass("Starting Test US_08 --> TC_02...");
        //Create page object for HomePage
        HomePage homePageHalil = new HomePage();
        WaitUtils.waitFor(3);
        //1- User should navigate to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        WaitUtils.waitFor(3);
        //get the page title
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("allover_commerce_title")));
        //2- User clicks on the Sign-in button at home page
        WaitUtils.waitFor(15);
        homePageHalil.signInOption.click();
        //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys("haliltestng");
        //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys("testng");
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
        //9- User clicks the 'search icon'
        homePageHalil.searchIcon.click();
        ////10- User clicks the 'add to wishlist' icon first three product on list
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.searchResult1WishIcon);
        homePageHalil.searchResult1WishIcon.click();
        WaitUtils.waitFor(5);
        //12- User clicks 'wishlist' icon top on the page
        homePageHalil.wishListPageButton.click();
        //13- User must see all chosen products on the wishlist page
        WaitUtils.waitFor(5);
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.wishAddedTableQuickView);
        ExtentReportUtils.passAndCaptureScreenshot("User Able to Click Quick View");
        Assert.assertTrue(homePageHalil.wishAddedTable.isDisplayed());

        Driver.closeDriver();
        ExtentReportUtils.pass("Driver is Closed...Test Completed Successfully...");
        LoggerUtils.info("Driver is Closed...Test Completed Successfully...");

        //3. Then use flush to generate the report
        ExtentReportUtils.flush();
    }

//same with TC_01
//same with TC_02
    //-------TC_003--STARTS-------//
//14- User clicks first 'QUICK VIEW' button
//15- User able to see the properties of the product for first product
    @Test
    public void TC_03(){
        LoggerUtils.info("Starting Test US_08 --> TC_03...");
        //1. use createTestReport(String name,String description) first for creating extent report capability
        ExtentReportUtils.createTestReport("US_08 Test Report","Test report for TC_03 Login website");
        //2. then use any method to mark as pass, info, fail
        ExtentReportUtils.pass("Starting Test US_08 --> TC_03...");
        //Create page object for HomePage
        HomePage homePageHalil = new HomePage();
        //1- User should navigate to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        //get the page title
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("allover_commerce_title")));
        //2- User clicks on the Sign-in button at home page
        homePageHalil.signInOption.click();
        //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys("haliltestng");
        //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys("testng");
        //5- User clicks on the Sign-in button at login page
        homePageHalil.rememberMeCheckBox.click();
        //6- User is able to Sign In
        homePageHalil.signInButton.click();
        //wait may need if the internet connection is slow or website is slow
        Assert.assertTrue(homePageHalil.signOutButton.isDisplayed());
        //12- User clicks 'wishlist' icon top on the page
        homePageHalil.wishListPageButton.click();
        //13- User must see all chosen products on the wishlist page
        WaitUtils.waitFor(5);
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(5);
        ActionsUtil.actionsHoverOverOnElement(homePageHalil.wishAddedTableQuickView);
        Assert.assertTrue(homePageHalil.wishAddedTable.isDisplayed());
        //14- User clicks first 'QUICK VIEW' button
        homePageHalil.wishAddedTableQuickView.click();
        ExtentReportUtils.passAndCaptureScreenshot("User Able to See Item Features");
        //15- User able to see the properties of the product for first product
        WaitUtils.waitFor(5);
        Assert.assertTrue(homePageHalil.wishAddedTableQuickViewProperties.isDisplayed());

        Driver.closeDriver();
        ExtentReportUtils.pass("Driver is Closed...Test Completed Successfully...");
        LoggerUtils.info("Driver is Closed...Test Completed Successfully...");

        //3. Then use flush to generate the report
        ExtentReportUtils.flush();
    }

//same with TC_01
//same with TC_02
//same with TC_03
    //-------TC_004--STARTS------//
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
    public void TC_04(){
        LoggerUtils.info("Starting Test US_08 --> TC_04...");
        //1. use createTestReport(String name,String description) first for creating extent report capability
        ExtentReportUtils.createTestReport("US_08 Test Report","Test report for TC_04 Login website");
        //2. then use any method to mark as pass, info, fail
        ExtentReportUtils.pass("Starting Test US_08 --> TC_04...");
        //Create page object for HomePage
        HomePage homePageHalil = new HomePage();
        //Create page object for CheckOutPage
        CheckoutPage checkOutPageHalil = new CheckoutPage();
        //1- User should navigate to "https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_commerce_url"));
        //get the page title
        String title = Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains(ConfigReader.getProperty("allover_commerce_title")));
        //2- User clicks on the Sign-in button at home page
        homePageHalil.signInOption.click();
        //3- User enters valid Username or email address ==> property=>us_08_username (haliltestng)
        homePageHalil.emailOrUsername.sendKeys("haliltestng");
        //4- User enters valid password ==> property=>us_08_password (testng)
        homePageHalil.password.sendKeys("testng");
        //5- User clicks on the Sign-in button at login page
        homePageHalil.rememberMeCheckBox.click();
        //6- User is able to Sign In
        homePageHalil.signInButton.click();
        //wait may need if the internet connection is slow or website is slow
        Assert.assertTrue(homePageHalil.signOutButton.isDisplayed());
        //12- User clicks 'wishlist' icon top on the page
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
            WaitUtils.waitFor(12);
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
        //19- User enters 'First name' ->	Halil
        checkOutPageHalil.firstName.clear();
        ExtentReportUtils.info("User Enter firstName: Halil");
        checkOutPageHalil.firstName.sendKeys("Halil");
        //20- User enters 'Last name' ->	TestNG
        checkOutPageHalil.lastName.clear();
        ExtentReportUtils.info("User Enter lastName: TestNG");
        checkOutPageHalil.lastName.sendKeys("TestNG");
        //21- User enters 'Company name' ->	TechPro Education
        //22- User enters 'Country / Region' ->	Canada
        ExtentReportUtils.info("User Drop Down Region: Canada");
        BrowserUtils.dropdownSelectByVisibleText(checkOutPageHalil.countryRegionDropdown,"Canada");
        //23- User enters 'Street address' ->	999 Java Street
        checkOutPageHalil.streetAddressFirstLine.clear();
        ExtentReportUtils.info("User Enter Street Address: 999 Java Street");
        checkOutPageHalil.streetAddressFirstLine.sendKeys("999 Java Street");
        //24- User enters 'Town/City' ->	Toronto
        checkOutPageHalil.townCity.clear();
        ExtentReportUtils.info("User Enter City: Toronto");
        checkOutPageHalil.townCity.sendKeys("Toronto");
        //25- User enters 'Province' ->	Ontario
        ExtentReportUtils.info("User Drop Down Province: Ontario");
        BrowserUtils.dropdownSelectByVisibleText(checkOutPageHalil.provinceStateDropdown,"Ontario");
        //26- User enters 'Postal Code' ->	M5V 3L9
        checkOutPageHalil.postCodeZIP.clear();
        ExtentReportUtils.info("User Enter Post Code: M5V 3L9");
        checkOutPageHalil.postCodeZIP.sendKeys("M5V 3L9");
        //27- User enters 'Phone' ->	4679872143
        checkOutPageHalil.phone.clear();
        ExtentReportUtils.info("User Enter Phone: 4679872143");
        checkOutPageHalil.phone.sendKeys("4679872143");
        //28- User enters 'Email address' ->	halile.test.ng@gmail.com
        //extra step
        ExtentReportUtils.info("User Enter Order Note: This purchase for test reasons");
        checkOutPageHalil.orderNote.sendKeys("This purchase for test reasons");
        ExtentReportUtils.passAndCaptureScreenshot("User Entered Information...");
        //29- User choose "Payment Methods" ->	Wire transfer/EFT' or 'Pay at door'
        WaitUtils.waitFor(1);
        ActionsUtil.actionsScrollDown();
        WaitUtils.waitFor(3);
        checkOutPageHalil.payAtTheDoorNew.click();
        ExtentReportUtils.pass("User Click Pay At The Door Option...");
        //30- User clicks "PLACE ORDER"
        checkOutPageHalil.placeOrderButton.click();
        //31- see alarm for report
        WaitUtils.waitFor(1);
        Assert.assertTrue(checkOutPageHalil.noShippingMethodAlert.isDisplayed());
        WaitUtils.waitFor(2);
        ExtentReportUtils.fail("User Not Able To Complete Purchase...");
        ExtentReportUtils.passAndCaptureScreenshot("User Not Able To Complete Purchase...");
        //We want to take a screenshot of failure
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
            LoggerUtils.warn("User Not Able to Complete Purchase and Screen Shoot Taken By Media Utils");
        } catch (IOException e) {
            LoggerUtils.error("User Not Able to Complete Purchase and Screen Shoot Could Not Taken By Media Utils");
            throw new RuntimeException(e);
        }

        Driver.closeDriver();
        ExtentReportUtils.pass("Driver is Closed...Test Completed Successfully...");
        LoggerUtils.info("Driver is Closed...Test Completed Successfully...");

        //3. Then use flush to generate the report
        ExtentReportUtils.flush();
    }
}
