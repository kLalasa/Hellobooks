package testCases;


import io.qameta.allure.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.OnBoardingPage;
import pageObjects.SignUp_page;
import pageObjects.VerifyPage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TC001_SignupTest extends Baseclass {




    @Test(priority = 1)
    @Description("SignUp with new User")
    public void verify_signUp() throws IOException {

        HomePage hp = new HomePage(driver);
        hp.clickSignup();

        SignUp_page sp = new SignUp_page(driver);
        sp.setFirstname(p.getProperty("testFirstname"));
        sp.setLastname(p.getProperty("testLastname"));
        sp.setEmail(p.getProperty("testEmail"));
        sp.setPassword(p.getProperty("testPassword"));
        sp.setConfmpwd(p.getProperty("testPassword"));
        sp.click_checkbox();
        sp.click_submit();

        // Take screenshot after signup form submission
        captureScreenshot("AfterSignupForm");

        VerifyPage vp = new VerifyPage(driver);
        if(vp.isVerifyScreenExists()){
            vp.enterOTP(p.getProperty("otp"));   // stubbed OTP
            captureScreenshot("AfterOTP");
        }

        OnBoardingPage obp = new OnBoardingPage(driver);
        boolean onboardExists = obp.isOnBoardingPageExists();
        captureScreenshot("OnboardingPage");

        Assert.assertTrue(onboardExists, "User did not reach the Onboarding page after signup.");
        System.out.println("Signup test passed: user reached onboarding page successfully.");
    }
    @Test(priority = 2)
    @Description("SignUp with DuplicateEmail")

    public void duplicateEmail_verify() throws IOException {

        HomePage hp = new HomePage(driver);
        hp.clickSignup();

        SignUp_page sp = new SignUp_page(driver);
        sp.setFirstname(p.getProperty("testFirstname"));
        sp.setLastname(p.getProperty("testLastname"));
        sp.setEmail(p.getProperty("duplicateEmail"));
        sp.setPassword(p.getProperty("testPassword"));
        sp.setConfmpwd(p.getProperty("testPassword"));
        sp.click_checkbox();
        sp.click_submit();




        String text_duplicateEmail=sp.getConfirmationMsg_duplicateEmail();
        System.out.println("Captured Duplicate Email Message: " + text_duplicateEmail);

        Assert.assertEquals(text_duplicateEmail, "E-Mail already exists, please pick a different one.");

    }
    // Utility method to capture screenshot
    @Test(priority = 2)
    @Description("Signup with weak password")

    public void weakPassword_verify() throws IOException {

        HomePage hp = new HomePage(driver);
        hp.clickSignup();

        SignUp_page sp = new SignUp_page(driver);
        sp.setFirstname(p.getProperty("testFirstname"));
        sp.setLastname(p.getProperty("testLastname"));
        sp.setEmail(p.getProperty("duplicateEmail"));
        sp.setPassword(p.getProperty("weakPassword"));
        sp.setConfmpwd(p.getProperty("weakPassword"));
        sp.click_checkbox();
        sp.click_submit();

        // Take screenshot after signup form submission



        String text_msg_weakPassword=sp.getConfirmationMsg_weakPassword();
        System.out.println("Captured Duplicate Email Message: " + text_msg_weakPassword);

        Assert.assertEquals(text_msg_weakPassword, "Password must include at least 8 characters, 1 uppercase letter, 1 number and 1 symbol");

    }

}
