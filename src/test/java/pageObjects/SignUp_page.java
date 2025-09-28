package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUp_page extends BasePage {
    public SignUp_page(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='input_last_name']")
    WebElement txt_lastname;

    @FindBy(xpath = "//input[@id='input_first_name']")
    WebElement txt_firstname;
    @FindBy(xpath = "//input[@id='input_your_working_email']")
    WebElement txt_email;
    @FindBy(xpath = "//input[@id='input_password']")
    WebElement txt_password;

    @FindBy(xpath = "//input[@id='input_confirm_password']")
    WebElement txt_confirmpwd;

    @FindBy(xpath = "//input[@id='terms']")
    WebElement terms_chkbox;

    @FindBy(xpath = "//div[@class='MuiAlert-message css-1xsto0d']")
    WebElement txt_duplicateEmail;

    @FindBy(xpath ="//p[@id='input_password-error']")
    WebElement txt_weakPassword;


    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit_btn;

    public void setFirstname(String fname) {
        txt_firstname.sendKeys(fname);
    }

    public void setLastname(String lname) {
        txt_lastname.sendKeys(lname);
    }

    public void setEmail(String email) {
        txt_email.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txt_password.sendKeys(pwd);
    }

    public void setConfmpwd(String confpwd) {
        txt_confirmpwd.sendKeys(confpwd);
    }

    public void click_checkbox() {
        terms_chkbox.click();
    }

    public void click_submit() {
        submit_btn.click();
    }

    public String getConfirmationMsg_duplicateEmail() {

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement msg = wait.until(ExpectedConditions.visibilityOf(txt_duplicateEmail));
            return msg.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }


    public String getConfirmationMsg_weakPassword(){

        try{
            return (txt_weakPassword.getText());
        }catch (Exception e){

            return (e.getMessage());
        }
    }

}


