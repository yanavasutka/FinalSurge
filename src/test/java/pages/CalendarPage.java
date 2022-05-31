package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

@Log4j2
public class CalendarPage extends BasePage {

    //TODO НЕ КОМПИЛИТСЯ
    public static final By TITLE = By.id("dpMonth"),
            QUICK_ADD_BUTTON = By.id("QuickAddToggle"),
            WORKOUT_LIBRARY_BUTTON = By.id("WorkoutLibAdd"),
            FULL_ADD_BUTTON = By.id("FullAddBtn"),


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

}


