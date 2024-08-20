package pages.stellarburgers.site;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassPage {
    private final By loginLinkLocator = By.linkText("Войти");
    private WebDriver driver;
    public RecoverPassPage(WebDriver driver) {this.driver = driver;}
    @Step("Click on button Login")
    public void loginButtonClick() {
        driver.findElement(loginLinkLocator).click();
    }
}
