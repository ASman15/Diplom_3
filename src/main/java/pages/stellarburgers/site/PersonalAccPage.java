package pages.stellarburgers.site;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccPage {
    private WebDriver driver;

    private final By constructorButtonLocator = By.xpath(".//p[text()='Конструктор']/parent::a");
    private final By mainLogotipLocator = By.xpath(".//div[contains(@class, 'AppHeader')]/a");
    private final By enterTitleLocator = By.xpath(".//h2[text()='Вход']");
    private final By emailFieldLocator = By.xpath(".//input[@name='name']");
    private final By passwordFieldLocator = By.xpath(".//input[@name='Пароль']");
    private final By enterButtonLocator = By.xpath(".//button[text()='Войти']");
    private final By registrationLinkLocator = By.linkText("Зарегистрироваться");
    private final By recoverPasswordLinkLocator = By.linkText("Восстановить пароль");
    private final By exitFromAccAfterLoginButtonLocator = By.xpath(".//button[text()='Выход']");
    public PersonalAccPage(WebDriver driver) {this.driver = driver;}
    @Step("Click on link Registration")
    public void registrationLinkClick() {
        driver.findElement(registrationLinkLocator).click();
    }
    @Step("Click on Constructor button")
    public void constructorButtonClick() {
        driver.findElement(constructorButtonLocator).click();
    }
    @Step("Click on logo")
    public void logoClick() {
        driver.findElement(mainLogotipLocator).click();
    }
    @Step("Click on Exit account button")
    public void exitAccountButtonClick() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(exitFromAccAfterLoginButtonLocator));
        driver.findElement(exitFromAccAfterLoginButtonLocator).click();
    }
    @Step("Ckeck the button Enter is displayed")
    public void enterButtonIsDisplayed() {
        driver.findElement(enterButtonLocator).isDisplayed();
    }
    public void loginOutIsSuccess() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(enterTitleLocator));
        driver.findElement(enterTitleLocator).isDisplayed();
    }
    @Step("Click on link Recover password")
    public void recoverPassLinkClick() {
        WebElement linkRecoverPass = driver.findElement(recoverPasswordLinkLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", linkRecoverPass);
        driver.findElement(recoverPasswordLinkLocator).click();
    }
    @Step("Login in test account")
    public void accLogin(String email, String password) {
        driver.findElement(emailFieldLocator).sendKeys(email);
        driver.findElement(passwordFieldLocator).sendKeys(password);
        driver.findElement(enterButtonLocator).click();
    }


}
