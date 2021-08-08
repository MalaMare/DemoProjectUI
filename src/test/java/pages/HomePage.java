package pages;

import helpers.PageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import static helpers.ConfigurationHelper.mainSiteUrl;

public class HomePage extends PageHelper {


    public HomePage open(){
       getDriver().get(mainSiteUrl);
       return this;
    }

    public ElementsPage goToElements() throws InterruptedException {
        clickOnElement(By.xpath("//*[@id=\"app\"]//div[1]//h5"));
        return PageFactory.initElements(getDriver(), ElementsPage.class);

    }

    public FormsPage goToForms() throws InterruptedException {
        clickOnElement(By.xpath("//*[@id=\"app\"]//div[2]//h5[contains(text(),'Forms')]"));
        return PageFactory.initElements(getDriver(), FormsPage.class);

    }

    public AlertsPage goToAlerts() throws InterruptedException {
        clickOnElement(By.xpath("//*[@id=\"app\"]//div[3]//h5"));
        return PageFactory.initElements(getDriver(), AlertsPage.class);

    }

    public WidgetsPage goToWidgets() throws InterruptedException {
        clickOnElement(By.xpath("//*[@id=\"app\"]//div[3]//h5"));
        return PageFactory.initElements(getDriver(), WidgetsPage.class);

    }


}
