package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenPositionsPage extends BasePage{
    @FindBy(id = "select2-filter-by-location-container")
    WebElement filterLocation;

    @FindBy(id="select2-filter-by-department-container")
    WebElement filterDepartment;

    @FindBy(xpath = "//li[contains(text(), 'Istanbul, Turkiye')]")
    WebElement selectOptionLocation;

    // "(//div[@data-location='istanbul-turkiye'])"
    @FindBy(xpath = "(//div[@class='position-location text-large'][normalize-space()='Istanbul, Turkiye'])")
    List<WebElement> jobLocationList;

    @FindBy(xpath = "(//span[@class='position-department text-large font-weight-600 text-primary'][normalize-space()='Quality Assurance'])")
    List<WebElement> jobDeparmentList;

    @FindBy(xpath = "(//a[@class='btn btn-navy rounded pt-2 pr-5 pb-2 pl-5'][normalize-space()='View Role'])[1]")
    WebElement viewRole;

    public OpenPositionsPage(WebDriver driver){
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver,this);
        this.actions = new Actions(driver);
    }

    public OpenPositionsPage setFilterLocation(){
        waitForVisibility(filterLocation);
        actions.moveToElement(filterLocation).click().perform();
        waitForVisibility(selectOptionLocation);
        actions.moveToElement(selectOptionLocation).click().perform();
        return this;
    }
    public OpenPositionsPage setFilterDepartment(){
        waitForVisibility(filterDepartment);
        wait.until(ExpectedConditions.textToBePresentInElement(filterDepartment,"Quality Assurance"));
        return this;
    }

    public List<String> getJobLocations(){
        waitForAllVisibility(jobLocationList);
        List<String> locationList = new ArrayList<>();
        for(WebElement element : jobLocationList){
            locationList.add(element.getText());
        }
        return locationList;
    }
    public List<String> getDepartmentLocations(){
        waitForAllVisibility(jobDeparmentList);
        List<String> departmentList = new ArrayList<>();
        for(WebElement element : jobDeparmentList){
            departmentList.add(element.getText());
        }
        return departmentList;
    }

    public OpenPositionsPage clickViewRole(){
        actions.moveToElement(viewRole).perform();
        waitForClickability(viewRole).click();
        return this;
    }

    //Yeni öğrendiğim bir şey sekme değiştirme
    public OpenPositionsPage switchToNewTab(){
        String currentWindow = driver.getWindowHandle();
        //Benzesiz ID tutmak için burada SET kullanacağım eğer List kullansaydın aynı pencere ID birden fazla gelebilirdi.
        Set<String> windowHandles = driver.getWindowHandles();

        for(String window : windowHandles){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        return this;
    }

    public String getLeverPageTitle(){
        return driver.getTitle();
    }
}
