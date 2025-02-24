package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import pages.NavBarPage;

public class NavBarTest extends BaseTest{


    HomePage homePage;
    NavBarPage navBarPage;

    @Test
    public void navBarSelectionTest(){
        homePage = new HomePage(driver);
        navBarPage = new NavBarPage(driver);

        homePage
                .getHomePageTitle();

        navBarPage
                .moveToNavbarItem()
                .hoverOverTabNavBarItem();
    }

}
