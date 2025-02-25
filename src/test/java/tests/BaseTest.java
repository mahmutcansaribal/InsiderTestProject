package tests;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest {

    public WebDriver driver;
    private String baseUrl = "https://useinsider.com/";

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }
    @AfterMethod
    public void tearDown(ITestResult result){
        if (ITestResult.FAILURE == result.getStatus()) {
            takeScreenshot(result.getName());
        }
        driver.quit();
    }

    public void takeScreenshot(String testName){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String folderPath = "test-outputs/screenshots/";

        String timeStamp =  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = "test-outputs/screenshots/" + testName + "_" + timeStamp + ".png";

        try{
            File directory = new File(folderPath);
            if(!directory.exists()){
                directory.mkdirs();
            }
            FileUtils.copyFile(srcFile, new File(filePath));
            attachScreenshotToAllure(srcFile);
            System.out.println("Screenshot saved : "+filePath);
        }catch (IOException e){
            System.out.println("Screenshot could not be saved!");
            e.printStackTrace();
        }
    }

    @Attachment(value = "Failure Screenshot", type = "image/png")
    public byte[] attachScreenshotToAllure(File file) {
        try {
            return FileUtils.readFileToByteArray(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
