package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.QualityAssurancePage;

@Listeners(utils.Listeners.class)
public class QualityAssuranceTest extends BaseTest{

    QualityAssurancePage qualityAssurancePage;

    @Test
    @Description("Quality Assurance sayfasına gidilmeli ve 'See All QA Jobs' butonuna tıklanmalıdır.")
    @Severity(SeverityLevel.NORMAL)
    public void clickToSeeAllJobs(){
        qualityAssurancePage = new QualityAssurancePage(driver);

        qualityAssurancePage
                .goToQualityAssurancePage()
                .seeAllQAJobs();
    }
}
