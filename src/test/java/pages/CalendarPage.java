package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;

import static org.testng.Assert.assertEquals;


@Log4j2
public class CalendarPage extends BasePage {

    public static final By TITLE = By.id("dpMonth"),
            QUICK_ADD_BUTTON = By.id("QuickAddToggle"),
            FULL_ADD_BUTTON = By.id("FullAddBtn"),
            QUICK_MESSAGE = By.cssSelector(".alert"),
            SUCCESS_QUICK_ADD_WORKOUT_TEXT = By.xpath("//div[@class='alert alert-success']"),
            OK_DELETE_BUTTON = By.xpath("//a[contains(.,'OK')]");
    public static final String WORKOUT_BUTTON = "//div[contains(text(),'%s')]";
    public static final String DELETE_BUTTON = "//div[contains(text(),'%s')]/ancestor::div[contains(@class , 'dropdown')]/ul//li/a[contains(@class, 'quick-delete')]";

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(TITLE);
    }

    @Step("Adding a workout by clicking on the Quick Add button")
    public void clickOnTheQuickAddButton() {
        driver.findElement(QUICK_ADD_BUTTON).click();
    }

    @Step("Adding a workout by clicking on the Full Add button")
    public void clickOnTheFullAddButton() {
        driver.findElement(FULL_ADD_BUTTON).click();
    }

    @Step("Deleting a workout")
    public void deleteWorkout(String workout) {
        driver.findElement(By.xpath(String.format(WORKOUT_BUTTON, workout))).click();
        driver.findElement(By.xpath(String.format(DELETE_BUTTON, workout))).click();
        try {
            driver.findElement(OK_DELETE_BUTTON).click();
        } catch (ElementClickInterceptedException ex) {
            WebElement element = driver.findElement(OK_DELETE_BUTTON);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);
        }
    }

    @Step("Getting the error message")
    public String getMessage() {
        log.info("Getting the error message {}", QUICK_MESSAGE);
        return driver.findElement(QUICK_MESSAGE).getText();
    }

    @Step("Getting the message about successful the successful saving of the workout to the library")
    public WebElement successQuickAddWorkoutToLibraryText() {
        return driver.findElement(SUCCESS_QUICK_ADD_WORKOUT_TEXT);
    }

    @Step("Validation of the error message when adding a workout with invalid data")
    public void validateMessage (String correctMessage){
        log.info("Validation of the error message {} when adding a workout with invalid data", QUICK_MESSAGE);
        assertEquals(getMessage(), correctMessage, "The error message isn't correct");
        }
    }


