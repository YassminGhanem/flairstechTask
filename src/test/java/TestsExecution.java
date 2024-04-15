import com.beust.ah.A;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class TestsExecution
{
    WebDriver driver;
    LoginHelper login;
    AddRecordHelper addCycle;
    SearchHelper search;
    DeleteHelper delete;


    @BeforeTest
    public void OpenBrowser()
    {
        driver = new ChromeDriver();
        login = new LoginHelper(driver);
        addCycle = new AddRecordHelper(driver);
        search = new SearchHelper(driver);
        delete = new DeleteHelper(driver);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test (priority = 1)
    public void ValidLoginWithSuccessful_UsernameAndPassword()
    {
        login.Login(login.validUserName, login.validPassWord);
        String expectedResult = "Dashboard";
        String actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span")).getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 2)
    public void AddNewRecord_InAdminSection() throws InterruptedException
    {
        var currentCountOfRecords = addCycle.GetCurrentNumberOfAdminRecords();
        addCycle.AddNewRecord();
        Thread.sleep(2000);
        var newCountOfRecords = addCycle.GetCurrentNumberOfAdminRecords();
        Thread.sleep(6000);

        var expectedResult = currentCountOfRecords +1;
        var actualResult = newCountOfRecords;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test (priority = 3)
    public void SearchOnTheNewUserNameWhichAdded()
    {
        search.SearchOnSpecificUser("Aymaaan");

       String expectedResult = "Aymaaan";
       String actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]")).getText();
       Assert.assertEquals(actualResult, expectedResult);
    }

    @Test (priority = 4)
    public void DeleteTheNewRecord() throws InterruptedException
    {
        delete.DeleteUser();
        var currentCountOfRecordsAfterDelete = addCycle.GetCurrentNumberOfAdminRecords();
    }

    @AfterTest
    public void CloseBrowser()
    {
        driver.quit();
    }
}
