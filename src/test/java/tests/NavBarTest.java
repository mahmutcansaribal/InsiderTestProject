package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.NavBarPage;

@Listeners(utils.Listeners.class)
public class NavBarTest extends BaseTest{


    HomePage homePage;
    NavBarPage navBarPage;

    @Test
    @Description("Navbar'daki 'Company' öğesi seçilmelidir. Açılır menüden 'Careers' seçilmelidir.")
    @Severity(SeverityLevel.NORMAL)
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
