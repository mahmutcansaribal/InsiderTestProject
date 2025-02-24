package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CareesPage extends  BasePage{

    @FindBy(id = "career-our-location")
    WebElement locationSection;

    @FindBy(id = "career-find-our-calling")
    WebElement ourCallingSection;

    @FindBy(xpath = "//section[@class='elementor-section elementor-top-section elementor-element elementor-element-a8e7b90 elementor-section-full_width elementor-section-height-default elementor-section-height-default']//div[@class='elementor-container elementor-column-gap-default']")
    WebElement lifeAtInsiderSection;


    public CareesPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        this.actions = new Actions(driver);
    }

    public String getCareersTitle(){
        return driver.getTitle();
    }

    public boolean verifyLocationsSectionVisible(){
        actions.moveToElement(locationSection).perform();
        waitForVisibility(locationSection);
        return locationSection.isDisplayed();
    }
    public boolean verifyOurCallingSectionVisible(){
        actions.moveToElement(ourCallingSection).perform();
        waitForVisibility(ourCallingSection);
        return  ourCallingSection.isDisplayed();
    }
    public boolean verifyLifeAtInsiderSectionVisible(){
        actions.moveToElement(lifeAtInsiderSection).perform();
        waitForVisibility(lifeAtInsiderSection);
        return  lifeAtInsiderSection.isDisplayed();
    }
}
