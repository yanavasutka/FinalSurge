package pages;

import dto.WorkoutCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.Input;
import wrappers.RadioButton;

import static org.testng.Assert.assertEquals;

@Log4j2
public class WorkoutCalculatorModal extends BasePage{

    public static final By MODAL_TITLE = By.id("dpMonth"),
            CALCULATOR_PACES_BUTTON = By.id("saveButtonSettings"),
            ERROR_MESSAGE = By.xpath("//div[@class = 'alert alert-error']"),
            FIVE_K_PR = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[1]"),
            MARATHON_PR = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[2]"),
            MARATHON_PACE = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[3]"),
            LONG_RUN_PACE = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[4]"),
            ANAEROBIC_THRESHOLD = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[5]"),
            VO_MAX_SLOW = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[6]"),
            VO_MAX_FAST = By.xpath("//table[@class = 'table table-condensed table-hover']//tr[1]//td[7]");

    String calculator = "//a[contains(text(), '%s')]";
    public static final String IFRAME = "IntensityCalciFrame";

    public WorkoutCalculatorModal(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(MODAL_TITLE);
    }

    /*@Step("Selecting the Calculator '{calculator}'")
    public WorkoutCalculatorsModal selectCalculator(String calculator) {
        log.info("Selecting the Calculator {}", calculator);
        driver.switchTo().frame(IFRAME);
        driver.findElement(By.xpath(String.format(calculator))).click();
        return this;
    }*/

    @Step("Filling in the Workout Intensity calculator")
    public void fillInIntensityCalculatorForm(WorkoutCalculator workoutCalculators) {
        log.info("Filling in the form calculator Intensity workout");
        driver.switchTo().frame(IFRAME);
        new Input(driver, "TimeHH").write(workoutCalculators.getHoursIntensity());
        new Input(driver, "TimeMM").write(workoutCalculators.getMinutesIntensity());
        new Input(driver, "TimeSS").write(workoutCalculators.getSecondsIntensity());
        new RadioButton(driver, " Mile").selectButton(workoutCalculators.getSelectEvent());
        clickOnTheCalculatorPacesButton();
    }

    @Step("Clicking on the Calculator Paces Button")
    public void clickOnTheCalculatorPacesButton() {
        log.info("Clicking on the Calculator Paces Button {}", CALCULATOR_PACES_BUTTON);
        driver.findElement(CALCULATOR_PACES_BUTTON).click();
    }

    @Step("Getting the error message")
    public String getErrorMessage() {
        log.info("Getting the error message {}", ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Validation of the error message when adding a workout with invalid data")
    public void validateErrorMessage(String correctErrorMessage) {
        log.info("Validation of the error message {} when adding a workout with invalid data", ERROR_MESSAGE );
        assertEquals(getErrorMessage(), correctErrorMessage, "The error message isn't correct");
    }

    @Step("Getting the 5K PR result")
    public String get5KPR() {
        log.info("Getting the 5K PR result {}", FIVE_K_PR);
        return driver.findElement(FIVE_K_PR).getText();
    }

    @Step("Getting the Marathon PR result")
    public String getMarathonPR() {
        log.info("Getting the Marathon PR result {}", MARATHON_PR);
        return driver.findElement(MARATHON_PR).getText();
    }

    @Step("Getting the Marathon Pace result")
    public String getMarathonPace() {
        log.info("Getting the Marathon Pace result {}", MARATHON_PACE);
        return driver.findElement(MARATHON_PACE).getText();
    }

    @Step("Getting the Long Run Pace result")
    public String getLongRunPace() {
        log.info("Getting the Long Run Pace result {}", LONG_RUN_PACE);
        return driver.findElement(LONG_RUN_PACE).getText();
    }

    @Step("Getting the Anaerobic Threshold result")
    public String getAnaerobicThreshold() {
        log.info("Getting the Anaerobic Threshold result {}", ANAEROBIC_THRESHOLD);
        return driver.findElement(ANAEROBIC_THRESHOLD).getText();
    }

    @Step("Getting the VO2 Max Slow result")
    public String getVO2MaxSlow() {
        log.info("Getting the VO2 Max Slow result {}", VO_MAX_SLOW);
        return driver.findElement(VO_MAX_SLOW).getText();
    }

    @Step("Getting the VO2 Max Fast result")
    public String getVO2MaxFast() {
        log.info("Getting the VO2 Max Fast result {}", VO_MAX_FAST);
        return driver.findElement(VO_MAX_FAST).getText();
    }

    @Step("Validation of the Intensity calculator results")
    public void validateResults(String correct5KPR, String correctMarathonPR, String correctMarathonPace,
                                String correctLongRunPace, String correctAnaerobicThreshold, String correctVO2MaxSlow, String correctVO2MaxFast) {
        log.info("Validation of the Intensity calculator results");
        assertEquals(get5KPR(), correct5KPR, "The 5K PR result isn't correct");
        assertEquals(getMarathonPR(), correctMarathonPR, "The Marathon PR result isn't correct");
        assertEquals(getMarathonPace(), correctMarathonPace, "The Marathon Pace result isn't correct");
        assertEquals(getLongRunPace(), correctLongRunPace, "The Long Run Pace result isn't correct");
        assertEquals(getAnaerobicThreshold(), correctAnaerobicThreshold, "The Anaerobic Threshold result isn't correct");
        assertEquals(getVO2MaxSlow(), correctVO2MaxSlow, "The VO2 Max Slow result isn't correct");
        assertEquals(getVO2MaxFast(), correctVO2MaxFast, "The VO2 Max Fast result isn't correct");
    }
}
