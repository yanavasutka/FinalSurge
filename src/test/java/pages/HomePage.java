package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HomePage extends BasePage{

    public static final By TITLE = By.xpath("//*[contains(text(), 'Welcome, ')]"),
            WORKOUT_CALCULATORS_BUTTON = By.xpath("//*[@class='icsw16-stop-watch']"),
            LOGOUT_BUTTON = By.xpath("//a[text()='Logout']"),
            LOGOUT_MESSAGE = By.cssSelector("[class^='alert']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE);
    }

    @Step("Logout by clicking on the LOGOUT button")
    public void clickOnTheLogoutButton() {
        log.info("Logout by clicking on the LOGOUT button {}", LOGOUT_BUTTON);
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step("Getting the successful logout message")
    public String getLogoutMessage() {
        log.info("Getting the successful logout message {}", LOGOUT_MESSAGE);
        return driver.findElement(LOGOUT_MESSAGE).getText();
    }

    @Step("Opening the Workout Calculators modal")
    public void clickOnTheWorkoutCalculatorsButton() {
        log.info("Opening the Workout Calculators modal");
        driver.findElement(WORKOUT_CALCULATORS_BUTTON).click();
    }
}
