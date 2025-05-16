package webtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {

    private WebDriver driver;

    private By inputUsername = By.id("user-name");
    private By inputPassword = By.id("password");
    private By loginButton = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void textUsername(String username) {
        driver.findElement(inputUsername).sendKeys(username);
    }

    public void textPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void validateError(String errorMessage) {
        assertTrue(driver.getPageSource().contains(errorMessage));
    }
}
