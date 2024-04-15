import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddRecordHelper
{
    WebDriver driver;

    @FindBy(className = "oxd-main-menu-item")
    WebElement AdminLink;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement AddRecordButton;

    @FindBy(css = ".oxd-select-wrapper")
    WebElement UserRoleField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]")
    WebElement UserRoleOption;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")
    WebElement EmpNameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]")
    WebElement AvaliableEmpName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div")
    WebElement StatusField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]")
    WebElement StatusValue;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    WebElement UserNameField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    WebElement PasswordField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    WebElement ConfirmPasswordField;

    @FindBy(css = ".oxd-button.oxd-button--medium.oxd-button--secondary.orangehrm-left-space")
    WebElement SaveButton;

    By AdminRecordsPath()
    {
        return By.className("oxd-table-body");
    }

    By RecordPath()
    {
        return By.className ("oxd-table-card");
    }

    public  AddRecordHelper(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int GetCurrentNumberOfAdminRecords()
    {
        AdminLink.click();
        var adminRecordsPath = driver.findElement(AdminRecordsPath());
        var currentTotalRecords = adminRecordsPath.findElements(RecordPath());
        int totalRecords = currentTotalRecords.size();
        System.out.println("Number of records = " + " " + totalRecords);
        return totalRecords;
    }

    public void AddNewRecord() throws InterruptedException {
        AddRecordButton.click();
        UserRoleField.click();
        UserRoleOption.click();
        UserNameField.click();
        EmpNameField.sendKeys("Ranga");
        Thread.sleep(2000);
        AvaliableEmpName.click();
        StatusField.click();
        StatusValue.click();
        UserNameField.sendKeys("Aymaaan");
        PasswordField.sendKeys("Test@246810");
        ConfirmPasswordField.sendKeys("Test@246810");
        Thread.sleep(2000);
        SaveButton.click();
        Thread.sleep(2000);

    }




}
