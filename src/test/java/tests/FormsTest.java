package tests;

import org.testng.annotations.Test;
import pages.FormsPage;

import java.awt.*;

public class FormsTest extends BaseTest {

    private static FormsPage formsPage;

    @Test(description = "Verification that Automation Practice URL can be successfully opened.")
    public void goToPracticeForm() throws InterruptedException, AWTException {

        formsPage = homePage.goToForms();
        formsPage.setPractiseForm();

        formsPage.setFirstName();
        formsPage.setLastName();
        formsPage.setUserEmail();
        formsPage.setGenderRadio();
        formsPage.setMobile();
        formsPage.setDateOfBirth();
        formsPage.setSubjects();
        formsPage.setHobbiesCheckbox();
        formsPage.setUploadPicture();
        formsPage.setCurrentAddress();
        formsPage.selectState();
        formsPage.selectCity();


    }

}
