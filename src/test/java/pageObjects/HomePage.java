package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input_password']")
    private WebElement txt_Password;

    @FindBy(xpath = "//input[@id='input_your_working_email']")
    private WebElement txt_workingEmail;

    @FindBy(xpath = "//div[@class='flex ']//button[@type='button']")
    private WebElement btn_signIn;

    @FindBy(xpath = "//div[@class='flex items-center gap-1']")
    private WebElement txt_msgEnterValidEmail;

    @FindBy(xpath = "//button[normalize-space()='Sign up']")
    private WebElement btn_signup;

    // Actions
    public void setWorkingEmail(String email) {
        txt_workingEmail.clear();
        txt_workingEmail.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txt_Password.clear();
        txt_Password.sendKeys(pwd);
    }

    public void clickSignIn() {
        btn_signIn.click();
    }

    public String getConfirmationMsg_EnterValidEmail() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement msg = wait.until(ExpectedConditions.visibilityOf(txt_msgEnterValidEmail));
            return msg.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clickSignup() {
        btn_signup.click();
    }
}
