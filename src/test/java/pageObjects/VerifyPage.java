package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VerifyPage extends BasePage{
    public VerifyPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Enter the code']")
    WebElement msg_code;

    @FindBy(xpath = "//input[@type='text']")
    List<WebElement> otpBoxes;

    @FindBy(xpath = "//div[text()='Verify']")
    WebElement btn_verify;


    public boolean isVerifyScreenExists(){
        try
        {
            return (msg_code.isDisplayed());


        }catch (Exception e){
            return false;
        }

    }

    public void enterOTP(String otp){
        for (int i = 0; i < otpBoxes.size(); i++) {
            otpBoxes.get(i).sendKeys(String.valueOf(otp.charAt(i)));
        }
    }





}
