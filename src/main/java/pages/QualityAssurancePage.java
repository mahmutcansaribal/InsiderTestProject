package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class QualityAssurancePage extends BasePage{

    @FindBy(xpath = "//a[normalize-space()='See all QA jobs']")
    WebElement seeAllQAJobsBtn;

    public QualityAssurancePage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        this.actions = new Actions(driver);
    }

    public QualityAssurancePage goToQualityAssurancePage(){
        navigateToQualityAssurancePage();
        return  this;
    }

    public QualityAssurancePage seeAllQAJobs(){
        waitForVisibility(seeAllQAJobsBtn);
        actions.moveToElement(seeAllQAJobsBtn).click().perform();
        return this;
    }

}
