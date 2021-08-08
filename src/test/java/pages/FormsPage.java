package pages;

import helpers.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FormsPage extends DriverHelper {

    Actions actions = new Actions(getDriver());

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


    public void setPractiseForm() throws InterruptedException {
        practiseForm.click();
        Thread.sleep(10000);
    }

    public void selectDateOfBirth(){
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


}
