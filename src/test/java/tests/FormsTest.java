package tests;

import org.testng.annotations.Test;
import pages.FormsPage;

public class FormsTest extends BaseTest {

    private static FormsPage formsPage;

    @Test(description = "Verification that Automation Practice URL can be successfully opened.")
    public void goToPracticeForm() throws InterruptedException {

        formsPage = homePage.goToForms();
        formsPage.setPractiseForm();

        formsPage.selectDateOfBirth();
        formsPage.selectState();
        formsPage.selectCity();

    }

}
