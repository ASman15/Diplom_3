import PageObject.MainPage;
import PageObject.PersonalAccPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConstructorTest {
    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test //Переход к конструктору через "Булки"
    public void transitionByButtonBun() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.transferingConstructorByBunButton();
    }
    @Test //Переход к конструктору через "Соус"
    public void transitionByButtonSause() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.transferingConstructorBySauseButton();
    }
    @Test //Переход к конструктору через "Начинки"
    public void transitionByButtonFilling() {
        MainPage objMainPage = new MainPage(driver);
        objMainPage.transferingConstructorByFillingButton();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
