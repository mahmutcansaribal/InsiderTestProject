package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.OpenPositionsPage;
import pages.QualityAssurancePage;

import java.util.List;

@Listeners(utils.Listeners.class)
public class OpenPositionsTest extends BaseTest{

    HomePage homePage;
    QualityAssurancePage qualityAssurancePage;
    OpenPositionsPage openPositionsPage;


    @Test
    public void selectQAJobsWithFilter(){
        homePage = new HomePage(driver);
        qualityAssurancePage = new QualityAssurancePage(driver);
        openPositionsPage = new OpenPositionsPage(driver);

        homePage.getHomePageTitle();

        qualityAssurancePage
                .goToQualityAssurancePage()
                .seeAllQAJobs();
        openPositionsPage
                .setFilterDepartment()
                .setFilterLocation();

        List<String> actualLocations = openPositionsPage.getJobLocations();
        List<String> actualDeparments = openPositionsPage.getDepartmentLocations();

        String expectedLocations = "Istanbul, Turkiye";
        String expectedDeparments = "Quality Assurance";

        for (String location : actualLocations){
            Assert.assertEquals(location,expectedLocations,"Lokasyonlar eşleşmiyor!");
        }
        for(String department : actualDeparments){
            Assert.assertEquals(department,expectedDeparments,"Deparmantlar eşleşmiyor!");
        }

        String expectedTitle = "Insider. - Senior Software Quality Assurance Engineer";

        openPositionsPage
                .clickViewRole()
                .switchToNewTab();
        String actualTitle = openPositionsPage.getLeverPageTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(actualTitle,expectedTitle,"Lever sayfasının başlığı beklenenden farklı");

    }
}
