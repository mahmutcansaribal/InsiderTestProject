package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {

    @FindBy(id="wt-cli-accept-all-btn")
    WebElement cookiesAccept;

    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public String getHomePageTitle(){
        waitForVisibility(cookiesAccept);
        waitForClickability(cookiesAccept).click();
        return driver.getTitle();
    }

}
