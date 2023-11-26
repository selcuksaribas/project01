package app.tests.US_01;

import app.pages.*;
import app.utilities.ConfigReader;
import app.utilities.Driver;
import app.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC001 {
       /*
      US001: It should be possible to register as a user (Customer) on the site.
            AC001TC01: Go to homepage
            AC001TC02: Enter a valid username into username field
            (can contain lowercase letters, uppercase letters, numbers and special characters)
            AC001TC03: e-mail should be entered
            (with the format of abc@abc.com )
            AC001TC04: Password should be entered.
            (The password must be at least 12 characters long. To make it stronger, upper and lower case letters, numbers and ! " ? $ % ^ & should be used. )
            AC001TC05: Click on the checkbox  "I agree to the privacy policy"
            AC001TC06: Click on SIGN UP button



     */

    @Test
    public void RegistrationTest() {

        //Go to https://allovercommerce.com/"
        Driver.getDriver().get(ConfigReader.getProperty("allover_url"));

        // Click Register Button
        AlloverHomePage alloverHomePage=new AlloverHomePage();
        alloverHomePage.userIcon.click();
        AlloverLoginPage alloverLoginPage=new AlloverLoginPage();

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