package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;

@Listeners(utils.Listeners.class)
public class HomeTest extends BaseTest{

    HomePage homePage;


    @Test
    @Description("Anasayfanın beklendiği gibi yüklendiğini doğrulayan test.")
    @Severity(SeverityLevel.CRITICAL)
    public void homePageIsLoadedTest(){
        homePage = new HomePage(driver);
        String actualTitle = homePage.getHomePageTitle();
        String expectedTitle = "1 Leader in Individualized, Cross-Channel CX — Insider";

        Assert.assertEquals(actualTitle,expectedTitle,"Ana sayfa başlığı beklenenden farklı!");
    }
}
