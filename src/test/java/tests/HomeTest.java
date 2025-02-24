package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeTest extends BaseTest{

    HomePage homePage;


    @Test
    public void homePageIsLoadedTest(){
        homePage = new HomePage(driver);
        String actualTitle = homePage.getHomePageTitle();
        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";

        Assert.assertEquals(actualTitle,expectedTitle,"Ana sayfa  beklenenden farklı!");
    }
}
