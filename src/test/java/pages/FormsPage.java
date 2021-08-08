package pages;

import helpers.DriverHelper;
import helpers.PageHelper;
import jline.internal.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

public class FormsPage extends DriverHelper {

    Actions actions = new Actions(getDriver());
    Robot robot = new Robot();
    JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
    PageHelper pageHelper = new PageHelper();

    @FindBy(xpath = "//*[@id=\"item-0\"]/span[contains(text(),'Practice Form')]")
    private WebElement practiseForm;

    @FindBy(id ="firstName")
    private WebElement firstName;

    @FindBy(id="lastName")
    private WebElement lastName;

    @FindBy(id="userEmail")
    private WebElement userEmail;

    @FindBy(id="gender-radio-3")
    private WebElement genderOther;

    @FindBy(id="userNumber")
    private WebElement userNumber;

    @FindBy(id="dateOfBirthInput")
    private WebElement dateOfBirthInput;

    @FindBy(className = "react-datepicker__month-select")
    private WebElement birthMonth;

    @FindBy(className = "react-datepicker__year-select")
    private WebElement birthYear;

    @FindBy(className = "react-datepicker__month")
    private WebElement dateTable;

    @FindBy(id="subjectsContainer")
    private WebElement subjects;

    @FindBy(id="hobbies-checkbox-3")
    private WebElement hobbiesCheckboxMusic;

    @FindBy(id="uploadPicture")
    private WebElement uploadPicture;

    @FindBy(id="currentAddress")
    private  WebElement currentAddress;

    @FindBy(id="state")
    private WebElement stateDropdown;

    @FindBy(id="city")
    private WebElement cityDropdown;

    @FindBy(id="submit")
    private WebElement submitButton;

    @FindBy(id="closeLargeModal")
    private WebElement closeButton;

    private static String FIRST_NAME = "Marija";
    private static String LAST_NAME = "Kovacic";
    private static String PICTURE_PATH = "D:\\Users\\MAJA\\Pictures\\TestPic\\IMG_6625.JPG";
    private static String ADDRESS = "Belgrade\nSerbia";

    public FormsPage() throws AWTException {
    }


    public void setPractiseForm() throws InterruptedException {
        practiseForm.click();
        Thread.sleep(10000);
    }

    public void setFirstName(){
        firstName.sendKeys(FIRST_NAME);
    }

    public void setLastName(){
        lastName.sendKeys(LAST_NAME);
    }

    public void setUserEmail(){
        pageHelper.sendEmailOnField(userEmail);
    }

    public void setGenderRadio() throws InterruptedException {
        for (int i=1; i<=3; i++){
//            WebElement gender = getDriver().findElement(By.cssSelector("div>input#gender-radio-"+i));
//            WebElement gender = getDriver().findElement(By.cssSelector("input[id='gender-radio-1']"));

            WebElement gender = getDriver().findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div["+i+"]"));

            //*[@id="genterWrapper"]/div[2]/div[1]

//            pageHelper.clickOnElement(gender);
            gender.click();
        }
//        genderOther.click();
    }

    public void setMobile(){
//        pageHelper.sendRandomInteger(userNumber, 1000000);
        userNumber.sendKeys("1234567890");
    }

    public void setSubjects() throws InterruptedException {

        WebElement subjectField = getDriver().findElement(By.xpath("//*[@id=\"subjectsContainer\"]"));

//        subjectField.sendKeys("maths");

        javascriptExecutor.executeScript("arguments[0].click();", subjectField);
        javascriptExecutor.executeScript("arguments[0].value='maths';", subjectField);
//        javascriptExecutor.executeScript("document.getElementById('subjectsContainer').value='maths';");
//        javascriptExecutor.executeScript("document.getElementById('subjectsContainer').sendKeys('maths', Key.ENTER);");
        actions.sendKeys(Keys.TAB).perform();
        Thread.sleep(5000);

//        subjects.sendKeys(SUBJECT);
    }

    public void setHobbiesCheckbox(){
        for (int i=1; i<=3; i++){
//            WebElement hobby = getDriver().findElement(By.id("hobbies-checkbox-"+i));
//            hobbiesCheckboxMusic.click();
            WebElement hobby = getDriver().findElement(By.xpath("//*[@id=\"hobbiesWrapper\"]/div[2]/div["+i+"]"));
            hobby.click();

        }
    }

    public void setUploadPicture() throws AWTException, InterruptedException {

//        uploadPicture.click();

//        Alert alert = getDriver().switchTo().alert();
//        alert.sendKeys(PICTURE_PATH);

        WebElement picture = getDriver().findElement(By.cssSelector("input#uploadPicture.form-control-file"));
        javascriptExecutor.executeScript("arguments[0].click();", picture);

        StringSelection filePath = new StringSelection(PICTURE_PATH);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);
        robot.keyPress(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(1000);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(1000);

//        actions.moveToElement(picture).click().build();
//        picture.click();

//        getDriver().switchTo().activeElement().sendKeys(PICTURE_PATH);
//
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
    }

    public void setCurrentAddress(){
        ADDRESS = ADDRESS.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
        currentAddress.sendKeys(ADDRESS);
    }


    public void setDateOfBirth(){
        dateOfBirthInput.click();
        Select month = new Select(birthMonth);
        month.selectByIndex(0);

        Select year = new Select(birthYear);
        year.selectByValue("1982");

        List<WebElement> columns = dateTable.findElements(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div/div"));
        for (WebElement cell: columns){
            if(cell.getText().equals("6")){
                cell.findElement(By.xpath("//*[@id=\"dateOfBirth\"]//div[contains(text(),'6')]")).click();
                break;
            }
        }

    }

    public void selectState() throws InterruptedException {
        stateDropdown.click();
        actions.sendKeys(Keys.ENTER).perform();
//        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
        Thread.sleep(5000);
    }

    public void selectCity(){
        cityDropdown.click();
        actions.sendKeys(Keys.ENTER).perform();
//        actions.sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).perform();
    }

    public void clickSubmit(){
        submitButton.click();
    }

    public void submitSuccesful(){
        Assert.assertEquals(true, closeButton.isDisplayed());
        Log.info("Test passed");
        closeButton.click();


    }


}
