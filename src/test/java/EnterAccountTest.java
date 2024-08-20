import PageObject.*;
import io.restassured.RestAssured;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.stellarburgers.site.*;

public class EnterAccountTest {
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
        driver.get("https://stellarburgers.nomoreparties.site");
    }

    @Test //Вход на сайт через кнопку Войти в аккаунт на главной странице
    public void loginFromMainPage() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.accEnterButtonClick();
        objPersAccPage.accLogin(email, password);
        objMainPage.loginIsSuccess();
    }
    @Test //Вход на сайт через личный кабинет
    public void loginFromPersonalAcc() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.accLogin(email, password);
        objMainPage.loginIsSuccess();
    }
    @Test //Вход на сайт через страницу регистрации
    public void loginFromRegistrationPage() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        RegistrationPage objRegPage = new RegistrationPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.registrationLinkClick();
        objRegPage.clickLoginLink();
        objPersAccPage.accLogin(email, password);
        objMainPage.loginIsSuccess();
    }
    @Test //Вход на сайт через страницу восстановления пароля
    public void loginFromRecoverPassPage() {
        MainPage objMainPage = new MainPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        RecoverPassPage objRecPassPage = new RecoverPassPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.recoverPassLinkClick();
        objRecPassPage.loginButtonClick();
        objPersAccPage.accLogin(email, password);
        objMainPage.loginIsSuccess();
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
