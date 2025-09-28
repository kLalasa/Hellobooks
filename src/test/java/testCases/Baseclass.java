package testCases;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.*;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;


public class Baseclass {
    public static WebDriver driver;
    public Properties p;
    @BeforeMethod


    public void setUp() throws IOException {


        //loading config.properties file
        FileReader file=new FileReader("./src/main/resources/config.properties");
        p=new Properties();
        p.load(file);


        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("baseURL"));//reading URL from properties file
        driver.manage().window().maximize();



    }
    @AfterMethod


    public void  tearDown(){
        if(driver != null){
            driver.quit();
        }

    }

    public String captureScreenshot(String tname)throws IOException{
        String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        File sourcefile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+ "" +timeStamp+".png";
        File targetFile=new File(targetFilePath);
        sourcefile.renameTo(targetFile);
        return targetFilePath;
    }

}