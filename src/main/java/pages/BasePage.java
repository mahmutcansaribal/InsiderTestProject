package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    private String qualityAssuranceURL = "https://useinsider.com/careers/quality-assurance/";

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement waitForVisibility(WebElement webElement){
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }
    public WebElement waitForClickability(WebElement webElement){
        return  wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
    public void navigateToQualityAssurancePage(){
        driver.get(qualityAssuranceURL);
    }
    public List<WebElement> waitForAllVisibility(List<WebElement> element){
        return wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }
}
