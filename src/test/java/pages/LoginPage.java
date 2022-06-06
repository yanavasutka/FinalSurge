package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class LoginPage extends BasePage {

    public static final By EMAIL_INPUT = By.id("login_name"),
            PASSWORD_INPUT = By.id("login_password"),
            LOGIN_BUTTON = By.cssSelector("[type ='submit']"),
            ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']"),
            EMPTY_EMAIL_MESSAGE = By.xpath("//div[@class='formpad']//label[contains(text(), 'e-mail')]"),
            EMPTY_PASSWORD_MESSAGE = By.xpath("//div[@class='formpad']//label[contains(text(), 'password.')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementPresent(LOGIN_BUTTON);
    }

    @Step("Opening login page")
    public void open() {
        log.info("Opening login page {}", BASE_URL + "login.cshtml");
        driver.get(BASE_URL + "login.cshtml");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Log in by user {user} using password {password}")
    public void login (String user, String password) {
        log.info("Log in by user {} using password {}", user, password);
        driver.findElement(EMAIL_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting the error message about invalid data")
    public String getErrorMessage() {
        log.info("Getting the error message {} about invalid data", ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Getting the error message about the empty email field")
    public String getEmptyEmailMessage() {
        log.info("Getting the error message {} about the empty email field", EMPTY_EMAIL_MESSAGE);
        return driver.findElement(EMPTY_EMAIL_MESSAGE).getText();
    }

    @Step("Getting the error message about the empty password field")
    public String getEmptyPasswordMessage() {
        log.info("Getting the error message {} about the empty password field", EMPTY_PASSWORD_MESSAGE);
        return driver.findElement(EMPTY_PASSWORD_MESSAGE).getText();
    }
}

