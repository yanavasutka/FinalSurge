package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public static final By
            EMAIL_INPUT = By.id("login_name"),
            PASSWORD_INPUT = By.id("login_password"),
            LOGIN_BUTTON = By.cssSelector("[type = 'submit']"),
    //TODO css?
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
        driver.get(BASE_URL + "login.cshtml");
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
    }

    @Step("Log in by user {user} using password {password}")
    public void login (String user, String password) {
        driver.findElement(EMAIL_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Getting the error message about invalid data")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Getting the error message about the empty email field")
    public String getEmptyEmailMessage() {
        return driver.findElement(EMPTY_EMAIL_MESSAGE).getText();
    }

    @Step("Getting the error message about the empty password field")
    public String getEmptyPasswordMessage() {
        return driver.findElement(EMPTY_PASSWORD_MESSAGE).getText();
    }

    @Step("Checking if the LOGIN button is displayed")
    public boolean loginButtonIsDisplayed() {
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }
}

