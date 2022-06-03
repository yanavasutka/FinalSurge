package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class CalendarPage extends BasePage {

    public int theNumberOfWorkouts;
    public static final By TITLE = By.id("dpMonth"),
            QUICK_ADD_BUTTON = By.id("QuickAddToggle"),
            FULL_ADD_BUTTON = By.id("FullAddBtn"),
            WORKOUT = By.cssSelector(".fc-event-activity"),
            ERROR_MESSAGE = By.cssSelector(".alert"),
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

    @Step("Opening calendar page")
    public void open() {
        driver.get(BASE_URL + "Calendar.cshtml");
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    @Step("Adding a workout by clicking on the Quick Add button")
    public void clickOnTheQuickAddButton() {
        driver.findElement(QUICK_ADD_BUTTON).click();
    }

    @Step("Adding a workout by clicking on the Full Add button")
    public void clickOnTheFullAddButton() {
        driver.findElement(FULL_ADD_BUTTON).click();
    }

    @Step("Getting the number of workouts on the calendar")
    public void getTheNumberOfWorkouts() {
        List<WebElement> workouts = driver.findElements(WORKOUT);
        theNumberOfWorkouts = workouts.size();
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
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}


