package pages.stellarburgers.site;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MainPage {
    private WebDriver driver;

    private final By accountEnterButtonLocator = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By arrangeOrderButtonLocator = By.xpath(".//button[text()='Оформить заказ']");
    private final By personalAccButtonLocator = By.xpath(".//p[text()='Личный Кабинет']");
    private final By bunConstructorButtonLocator = By.xpath(".//span[text()='Булки']/parent::div");
    private final By sauseConstructorButtonLocator = By.xpath(".//span[text()='Соусы']/parent::div");
    private final By fillingConstructorButtonLocator = By.xpath(".//span[text()='Начинки']/parent::div");
    private final By ingredientFirstBunLocator = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa6d']");
    private final By ingredientFirstSauceLocator = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa72']");
    private final By ingredientFirstFillingLocator = By.xpath(".//a[@href = '/ingredient/61c0c5a71d1f82001bdaaa6f']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click at Personal Account button")
    public void personalAccButtonClick() {
        driver.findElement(personalAccButtonLocator).click();
    }
    @Step("Click at Enter in Account button")
    public void accEnterButtonClick() {
        driver.findElement(accountEnterButtonLocator).click();
    }
    @Step("Check login test user")
    public void loginIsSuccess() {
        driver.findElement(arrangeOrderButtonLocator).isDisplayed();
    }
    @Step("Check the first of Bun in constructor is displayed")
    public void ingredientFirstBunIsDisplayed() {
        driver.findElement(ingredientFirstBunLocator).isDisplayed();
    }
    @Step("Check transfering by Bun button")
    public void transferingConstructorByBunButton() {
        driver.findElement(bunConstructorButtonLocator).click();
        driver.findElement(ingredientFirstBunLocator).isDisplayed();
    }
    @Step("Check transfering by Sause button")
    public void transferingConstructorBySauseButton() {
        driver.findElement(sauseConstructorButtonLocator).click();
        driver.findElement(ingredientFirstSauceLocator).isDisplayed();
    }
    @Step("Check transfering by Filling button")
    public void transferingConstructorByFillingButton() {
        driver.findElement(fillingConstructorButtonLocator).click();
        driver.findElement(ingredientFirstFillingLocator).isDisplayed();
    }
}
