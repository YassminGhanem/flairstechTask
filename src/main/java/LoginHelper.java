import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginHelper
{
    WebDriver driver;
    String validUserName = "Admin";
    String validPassWord = "admin123";
    @FindBy(name = "username")
    WebElement UserName;

    @FindBy(name = "password")
    WebElement PassWord;

    @FindBy(className = "oxd-button")
    WebElement LoginButton;

    public  LoginHelper(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void PressOnLoginButton()
    {
        LoginButton.click();
    }

    public void Login(String userName, String passWord)
    {
        UserName.sendKeys(userName);
        PassWord.sendKeys(passWord);
        PressOnLoginButton();
    }
}
