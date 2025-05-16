package webtest.stepdef;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import webtest.page.LoginPage;
import webtest.base.BaseStepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepdef {

    private LoginPage loginPage;

    @Given("user is on login page")
    public void userIsOnLoginPage() {
        BaseStepdef.driver = new ChromeDriver();
        BaseStepdef.driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(BaseStepdef.driver);
    }

    @And("user input username with {string}")
    public void userInputUsernameWith(String username) {
        loginPage.textUsername(username);
    }

    @And("user input password with {string}")
    public void userInputPasswordWith(String password) {
        loginPage.textPassword(password);
    }

    @When("user click login button")
    public void userClickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("user is on homepage")
    public void userIsOnHomepage() {

        WebElement productElement = BaseStepdef.driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div"));
        assertTrue(productElement.isDisplayed());
        assertEquals("Sauce Labs Backpack", productElement.getText());
    }

    @Then("user able to see error message {string}")
    public void userAbleToSeeErrorMessage(String errorMessage) {
        loginPage.validateError(errorMessage);
    }
}
