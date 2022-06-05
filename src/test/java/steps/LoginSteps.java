package steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginSteps {

    LoginPage loginPage;

    public LoginSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }

    @Step("Log in with: user - '{user}', password - '{password}'")
    public void login(String user, String password) {
        loginPage.open();
        assertTrue(loginPage.isPageOpened(), "Login page hasn't been opened");
        loginPage.login(user, password);
    }
}
