package myapp.US_02;

import myapp.pages.AlloverHomePage;
import myapp.pages.AlloverLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 {
    /*
          US001:It should not be possible for the user (Customer) to register to the site with the same e-mail address.
            AC001TC01:A registered Username must be entered
            AC001TC02:A registered e-mail address must be entered
            AC001TC03: Password must be entered.
            AC001TC04: The SIGN UP button should be clicked
            AC001TC05: An account is already registered with your email address.
            (Warning text and "Please log in." message must be seen)
     */


    @Test
    public void RegistrationTest() {

        //Go to https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_url"));

        // Click Register Button
        AlloverHomePage alloverHomePage = new AlloverHomePage();
        alloverHomePage.userIcon.click();
        AlloverLoginPage alloverLoginPage = new AlloverLoginPage();

        //User enters a username
        alloverLoginPage.userName.sendKeys("Team-01");
        WaitUtils.waitFor(2);
        //User enters a valid email address
        alloverLoginPage.eMail.sendKeys("team@team.com");
        WaitUtils.waitFor(2);
        //User enters a valid password
        alloverLoginPage.Password.sendKeys("Team12345678*");
        WaitUtils.waitFor(2);
        //Click on  the policy button
        alloverLoginPage.policyButton.click();
        WaitUtils.waitFor(2);
        //Click on  the register button
        alloverLoginPage.registerButton.click();
        WaitUtils.waitFor(2);

        Assert.assertTrue(alloverLoginPage.eMail.isDisplayed());
        WaitUtils.waitFor(2);


        Driver.getDriver().close();
    }
}