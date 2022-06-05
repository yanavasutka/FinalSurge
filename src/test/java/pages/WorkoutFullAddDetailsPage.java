package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutFullAddDetailsPage extends BasePage {

    public static final By SHARE_BUTTON = By.cssSelector("[data-target='#ShareDiv']"),
            UPDATE_BUTTON = By.id("WorkoutEditLink");

    public WorkoutFullAddDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(SHARE_BUTTON);
    }

    @Step("Editing a workout using the EDIT button")
    public void updateWorkout () {
        driver.findElement(UPDATE_BUTTON).click();
    }
}
