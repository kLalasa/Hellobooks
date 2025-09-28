package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnBoardingPage extends BasePage {
    public OnBoardingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Onboarding Process']")
    WebElement msg_onboarding;

    public boolean isOnBoardingPageExists() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(msg_onboarding));
            return msg_onboarding.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

