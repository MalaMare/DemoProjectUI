package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageHelper extends DriverHelper {


    //PRIVATE waits
    public WebElement waitForElementVisibility(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementClickability(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(locator));
    }

    //PUBLIC methods
    public void clickOnElement(By locator) throws InterruptedException {
        WebElement target = waitForElementClickability(locator);
        Thread.sleep(10000);
        target.click();
    }

    public String sendTextOnField(By locator) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        String text = ActionsHelper.getRandomText();
        inputField.sendKeys(text);
        return text;
    }

    public void sendTextOnField(By locator, String text) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        inputField.sendKeys(text);
    }

    public String sendUrlOnField(By locator) {
        WebElement inputField = waitForElementVisibility(locator);
        inputField.clear();
        String text = ActionsHelper.getRandomUrl();
        inputField.sendKeys(text);
        return text;
    }

}
