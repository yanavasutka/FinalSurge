package pages;

import dto.WorkoutCalculators;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.RadioButton;

@Log4j2
public class IntensityModal extends BasePage{

    public static final By MODAL_TITLE = By.id("//*[@class='w-box-header']//h4[contains(text(), " +
            "'Running Workout Intensity Calculator')]"),
            CALCULATOR_PACES_BUTTON = By.id("saveButtonSettings");

    public IntensityModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(MODAL_TITLE);
    }

    @Step("Filling in the Workout Intensity calculator")
    public void fillInIntensityCalculatorForm(WorkoutCalculators workoutCalculators) {
        log.info("Filling in the form calculator Intensity workout");
        new Input(driver, "TimeHH").write(workoutCalculators.getHoursIntensity());
        new Input(driver, "TimeMM").write(workoutCalculators.getMinutesIntensity());
        new Input(driver, "TimeSS").write(workoutCalculators.getSecondsIntensity());
        new RadioButton(driver, " Mile").selectButton(workoutCalculators.getSelectEvent());
        clickOnTheCalculatorPacesButton();
    }

    public void clickOnTheCalculatorPacesButton() {
        driver.findElement(CALCULATOR_PACES_BUTTON).click();
    }
}
