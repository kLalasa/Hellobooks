package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.OnBoardingPage;
import io.qameta.allure.Description;

import java.io.IOException;

public class TC002_LoginPageTest extends Baseclass {
    @Test(priority = 1)
    @Description( "Login with valid credentials and reach Onboarding page")
    public void Login_validCredentials() throws IOException {

        HomePage hp = new HomePage(driver);

        hp.setWorkingEmail(p.getProperty("valid_WorkingEmail"));
        hp.setPassword(p.getProperty("valid_Password"));
        hp.clickSignIn();


        OnBoardingPage obp = new OnBoardingPage(driver);
        boolean onboardExists = obp.isOnBoardingPageExists();
        captureScreenshot("OnboardingPage");

        Assert.assertTrue(onboardExists, "User reached the Onboarding page after signin.");
        System.out.println("Signup test passed: user reached onboarding page successfully.");



    }
    @Test
    @Description( "Login with Invalid password")

    public void Login_InvalidPassword() throws IOException {

        HomePage hp = new HomePage(driver);

        hp.setWorkingEmail(p.getProperty("Invalid_Email"));
        hp.setPassword(p.getProperty("Invalid_Password"));
        hp.clickSignIn();


       String txt_InvalidEmailMsg=hp.getConfirmationMsg_EnterValidEmail();
        System.out.println("Captured message for Invalid password :" + txt_InvalidEmailMsg);

        Assert.assertEquals(txt_InvalidEmailMsg, "Please enter valid email and password");
        captureScreenshot("AfterSignin");



    }
}
