package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.QualityAssurancePage;

@Listeners(utils.Listeners.class)
public class QualityAssuranceTest extends BaseTest{

    QualityAssurancePage qualityAssurancePage;

    @Test
    public void clickToSeeAllJobs(){
        qualityAssurancePage = new QualityAssurancePage(driver);

        qualityAssurancePage
                .goToQualityAssurancePage()
                .seeAllQAJobs();
    }
}
