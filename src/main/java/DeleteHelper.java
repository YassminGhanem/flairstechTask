import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeleteHelper
{
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]")
    WebElement DeleteIcon;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement ConfirmationMessageOfDeleteAction;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement ConfirmActionButton;

    public  DeleteHelper(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void DeleteUser() throws InterruptedException {
        DeleteIcon.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(ConfirmationMessageOfDeleteAction));
        ConfirmActionButton.click();
        Thread.sleep(3000);
    }
}
