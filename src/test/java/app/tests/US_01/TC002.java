package myapp.US_01;

import myapp.pages.AlloverHomePage;
import myapp.pages.AlloverLoginPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.WaitUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC002 {
/*
      US002: The user of the site must make his password strong by taking the necessary steps.
            AC001TC01: Go to homepage
            AC001TC02: Enter a valid username into username field
            (can contain lowercase letters, uppercase letters, numbers and special characters)
            AC001TC03: e-mail should be entered
            (with the format of abc@abc.com )
            AC001TC04: Password should be entered.
            (The password must be at least 12 characters long. To make it stronger, upper and lower case letters, numbers and ! " ? $ % ^ & should be used. )
            AC001TC05: Click on the checkbox  "I agree to the privacy policy"
            AC001TC06: Click on SIGN UP button
            (Warning text and "Very weak - Please enter a stronger password." message must be seen)



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
        alloverLoginPage.userName.sendKeys("techpro1234");
        WaitUtils.waitFor(2);
        //User enters a valid email address
        alloverLoginPage.eMail.sendKeys("allover123@allover123.com");
        WaitUtils.waitFor(2);
        //User enters a valid password
        alloverLoginPage.Password.sendKeys("team");
        WaitUtils.waitFor(2);
        //Click on  the policy button
        alloverLoginPage.policyButton.click();
        WaitUtils.waitFor(2);
        //Click on  the register button
        alloverLoginPage.registerButton.click();
        WaitUtils.waitFor(2);

        Assert.assertTrue(alloverLoginPage.Password.isDisplayed());
        WaitUtils.waitFor(2);


        Driver.getDriver().close();







    }
}
