package pages.stellarburgers.site;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {
    private WebDriver driver;
    private final By nameFieldLocator = By.xpath(".//label[text()='Имя']");
    private final By passFieldLocator = By.xpath(".//input[@name='Пароль']");
    private final By incorrectPassTitle = By.xpath(".//p[text()='Некорректный пароль']");
    private final By enterLinkLocator = By.linkText("Войти");
    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on link Login")
    public void clickLoginLink() {
        WebElement linkEnter = driver.findElement(enterLinkLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", linkEnter);
        driver.findElement(enterLinkLocator).click();
    }
    @Step("Check enter incorrect password")
    public void passIsIncorrect () {
        driver.findElement(passFieldLocator).sendKeys("passw");
        driver.findElement(nameFieldLocator).click();
        driver.findElement(incorrectPassTitle).isDisplayed();
    }
}
