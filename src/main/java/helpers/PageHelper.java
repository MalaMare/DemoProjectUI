package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PageHelper extends DriverHelper {


    //PRIVATE waits
    public WebElement waitForElementVisibility(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementVisibility(WebElement webElement) {
        return getWait(getDriver()).until(ExpectedConditions.visibilityOf(webElement));
    }

    private WebElement waitForElementClickability(By locator) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(locator));
    }

    private WebElement waitForElementClickability(WebElement webElement) {
        return getWait(getDriver()).until(ExpectedConditions.elementToBeClickable(webElement));
    }

    //PUBLIC methods
    public void clickOnElement(By locator) throws InterruptedException {
        WebElement target = waitForElementClickability(locator);
        Thread.sleep(10000);
        target.click();
    }

    public void clickOnElement(WebElement webElement) throws InterruptedException {
        WebElement target = waitForElementClickability(webElement);
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

    public String sendEmailOnField(WebElement webElement){
        WebElement inputField = waitForElementVisibility(webElement);
        inputField.clear();
        String text = ActionsHelper.getRandomEmail();
        inputField.sendKeys(text);
        return text;
    }

    public String sendRandomInteger(WebElement webElement, int range){
        WebElement inputField = waitForElementVisibility(webElement);
        inputField.clear();
        int number = ActionsHelper.getRandomInteger(range);
        String stringNumber = Integer.toString(number);
        inputField.sendKeys(stringNumber);
        return stringNumber;
    }

}
