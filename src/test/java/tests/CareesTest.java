package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareesPage;
import pages.HomePage;
import pages.NavBarPage;

public class CareesTest extends BaseTest{

    HomePage homePage;
    NavBarPage navBarPage;
    CareesPage careesPage;

    @Test
    public void verifyCareesPage(){
        homePage = new HomePage(driver);
        navBarPage = new NavBarPage(driver);
        careesPage = new CareesPage(driver);

        homePage
                .getHomePageTitle();

        navBarPage
                .moveToNavbarItem()
                .hoverOverTabNavBarItem();

        String actualTitle = careesPage.getCareersTitle();
        String expectedTitle = "Ready to disrupt? | Insider Careers";

        Assert.assertEquals(actualTitle,expectedTitle,"Kariyer sayfası başlığı beklenenden farklı");
        Assert.assertTrue(careesPage.verifyLocationsSectionVisible(),"Location section is not visible!");
        Assert.assertTrue(careesPage.verifyOurCallingSectionVisible(),"Our Calling section is not visible!");
        Assert.assertTrue(careesPage.verifyLifeAtInsiderSectionVisible(),"Life At Insider section is not visible!");

    }
}
