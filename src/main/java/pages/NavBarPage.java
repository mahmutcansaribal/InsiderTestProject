package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavBarPage extends BasePage{

    @FindBy(xpath = "(//a[normalize-space()='Company'])[1]")
    WebElement navCompanyDropDown;

    @FindBy(xpath = "//a[normalize-space()='Careers']")
    WebElement navCompanyCareersItem;

    public NavBarPage(WebDriver driver){
        super(driver);
        this.actions = new Actions(driver);
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public NavBarPage moveToNavbarItem(){
        waitForVisibility(navCompanyDropDown);
        actions.moveToElement(navCompanyDropDown).perform();
        return this;
    }
    public NavBarPage hoverOverTabNavBarItem(){
        waitForVisibility(navCompanyCareersItem);
        waitForClickability(navCompanyCareersItem).click();
        return this;
    }
}
