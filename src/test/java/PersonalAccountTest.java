import io.restassured.RestAssured;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.stellarburgers.site.APIPage;
import pages.stellarburgers.site.MainPage;
import pages.stellarburgers.site.PersonalAccPage;
import java.util.concurrent.TimeUnit;

public class PersonalAccountTest {
    static String email = "dataTest@yandex.ru";
    static String password = "password";
    static String name = "Username";
    static String accessToken;

    private static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        APIPage apiPage = new APIPage();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        apiPage.createUser(email, password, name);
    }
    @Before
    public void setup() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("chrome");
        driver.manage().timeouts().implicitlyWait(1,
                TimeUnit.SECONDS);
        driver.get("https://stellarburgers.nomoreparties.site");
    }
    @Test //Переход в Личный кабинет по кнопке на главной странице
    public void personalAccIsDisplayed() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.enterButtonIsDisplayed();
    }
    @Test //Переход к Конструктору из Личного кабинета
    public void transitionToConstructorFromPersonalAccount() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.constructorButtonClick();
        objMainPage.ingredientFirstBunIsDisplayed();
    }
    @Test //Переход на главную страницу через логотип из Личного кабинета
    public void transitionFromPersonalAccountByLogo() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.logoClick();
        objMainPage.ingredientFirstBunIsDisplayed();
    }
    @Test //Выход из аккаунта успешен
    public void exitAccount() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.accEnterButtonClick();
        objPersAccPage.accLogin(email, password);
        objMainPage.personalAccButtonClick();
        objPersAccPage.exitAccountButtonClick();
        objPersAccPage.loginOutIsSuccess();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @AfterClass
    public static void deleteUser() {
        APIPage apiPage = new APIPage();
        accessToken = apiPage.loginUser(email, password).extract().body().path("accessToken");
        if (accessToken != null) {
            accessToken = accessToken.replace("Bearer ", "");
            apiPage.deleteUser(accessToken);
        }
    }
}

