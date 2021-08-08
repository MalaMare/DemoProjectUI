package tests;

import helpers.ConfigurationHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

import java.io.IOException;

public class BaseTest {

    public static HomePage homePage;

    @BeforeClass
    public static void setUpClass() throws IOException {
        ConfigurationHelper.init();
        homePage = new HomePage();
        homePage.open();
    }

    @AfterClass
    public static void tearDownClass() throws InterruptedException {
        Thread.sleep(3000);
        homePage.quitDriver();
    }


}
