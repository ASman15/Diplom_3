package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoverPassPage {

    public RecoverPassPage(WebDriver driver) {this.driver = driver;}
    private final By loginLinkLocator = By.linkText("Войти");
    private WebDriver driver;
    public void loginButtonClick() {
        driver.findElement(loginLinkLocator).click();
    }
}
