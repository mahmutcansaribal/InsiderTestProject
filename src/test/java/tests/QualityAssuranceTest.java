package tests;

import org.testng.annotations.Test;
import pages.QualityAssurancePage;

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
