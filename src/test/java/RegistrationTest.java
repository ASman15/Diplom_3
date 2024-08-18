import PageObject.APIPage;
import PageObject.MainPage;
import PageObject.PersonalAccPage;
import PageObject.RegistrationPage;
import io.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.Matchers.is;

public class RegistrationTest {
    static String email = "dataTest@yandex.ru";
    static String password = "password";
    String name = "Username";
    static String accessToken;

    private static WebDriver driver;

    @Test // Проверка возможности регистрации нового пользователя
    public void createNewUser() {
        APIPage apiPage = new APIPage();
        RestAssured.baseURI = "https://stellarburgers.nomoreparties.site/";
        apiPage.createUser(email, password, name).statusCode(200).body("success", is(true));
    }

    @Test //Проверка регистрации с паролем менее 6 символов
    public void registrUserWithIncorrPassIsNotSuccess() {
        Browser browser = new Browser();
        driver = browser.getWebDriver("chrome");
        driver.get("https://stellarburgers.nomoreparties.site");
        MainPage objMainPage = new MainPage(driver);
        RegistrationPage objRegPage = new RegistrationPage(driver);
        PersonalAccPage objPersAccPage = new PersonalAccPage(driver);
        objMainPage.personalAccButtonClick();
        objPersAccPage.registrationLinkClick();
        objRegPage.passIsIncorrect();
        driver.quit();
    }

    @AfterClass
    public static void tearDown() {
        APIPage apiPage = new APIPage();
        accessToken = apiPage.loginUser(email, password).extract().body().path("accessToken");
        if (accessToken != null) {
            accessToken = accessToken.replace("Bearer ", "");
            apiPage.deleteUser(accessToken);
        }
    }
}
