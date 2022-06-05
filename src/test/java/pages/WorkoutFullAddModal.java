package pages;

import dto.WorkoutFullAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.RadioButton;
import wrappers.TextArea;

@Log4j2
public class WorkoutFullAddModal extends BasePage {
    public static final By MODAL_TITLE = By.cssSelector(".w-box-header"),
            WORKOUT_DATE = By.id("WorkoutDate"),
            MARK_AS_RACE_BUTTON = By.id("IsRace"),
            PLANNED_DIST_DURATION_BUTTON = By.id("PlannedWorkout"),
            WORKOUT_PACE = By.id("Pace"),
            ADD_WORKOUT_BUTTON = By.id("saveButton");

    public WorkoutFullAddModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementPresent(MODAL_TITLE);
    }

    @Step("Filling in the RUN Workout Full Add form")
    public void fillInRunWorkoutFullAddForm (WorkoutFullAdd workoutFullAdd) {
        log.info("Filling in the RUNWorkout Full Add form");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workoutFullAdd.getWorkoutDate());
        new Input(driver, "WorkoutTime").write(workoutFullAdd.getTimeOfDay());
        new Input(driver, "Name").write(workoutFullAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").write(workoutFullAdd.getWorkoutDescription());
        clickOnThePlannedDistanceButton();
        new Input(driver, "PDistance").write(workoutFullAdd.getPlannedDistance());
        new DropDown(driver, "PDistType").select(workoutFullAdd.getPlannedDistanceType());
        new Input(driver, "PDuration").write(workoutFullAdd.getPlannedDuration());
        new Input(driver, "Distance").write(workoutFullAdd.getDistance());
        new DropDown(driver, "DistType").select(workoutFullAdd.getDistanceType());
        new Input(driver, "Duration").write(workoutFullAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").write(workoutFullAdd.getPace());
        new DropDown(driver, "PaceType").select(workoutFullAdd.getPaceType());
        clickOnTheMarkAsRaceButton();
        new Input(driver, "OverallPlace").write(workoutFullAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").write(workoutFullAdd.getAgeGroupPlace());
        new RadioButton(driver, "Normal").selectButton(workoutFullAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").select(workoutFullAdd.getPerceivedEffort());
        new Input(driver, "MinHR").write(workoutFullAdd.getMinHR());
        new Input(driver, "AvgHR").write(workoutFullAdd.getAvgHR());
        new Input(driver, "MaxHR").write(workoutFullAdd.getMaxHR());
        new Input(driver, "kCal").write(workoutFullAdd.getCaloriesBurned());
        clickOnTheAddWorkoutButton();
    }

    @Step("Filling in the BIKE Workout Full Add form")
    public void fillInBikeWorkoutFullAddForm (WorkoutFullAdd workoutFullAdd) {
        log.info("Filling in the BIKE Workout Full Add form");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workoutFullAdd.getWorkoutDate());
        new Input(driver, "WorkoutTime").write(workoutFullAdd.getTimeOfDay());
        new Input(driver, "Name").write(workoutFullAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").write(workoutFullAdd.getWorkoutDescription());
        clickOnThePlannedDistanceButton();
        new Input(driver, "PDistance").write(workoutFullAdd.getPlannedDistance());
        new DropDown(driver, "PDistType").select(workoutFullAdd.getPlannedDistanceType());
        new Input(driver, "PDuration").write(workoutFullAdd.getPlannedDuration());
        new Input(driver, "Distance").write(workoutFullAdd.getDistance());
        new DropDown(driver, "DistType").select(workoutFullAdd.getDistanceType());
        new Input(driver, "Duration").write(workoutFullAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").write(workoutFullAdd.getPace());
        new DropDown(driver, "PaceType").select(workoutFullAdd.getPaceType());
        new Input(driver, "EGain").write(workoutFullAdd.getElevationGain());
        new DropDown(driver, "EGainDistType").select(workoutFullAdd.getElevationGainDistType());
        new Input(driver, "ELoss").write(workoutFullAdd.getElevationLoss());
        new DropDown(driver, "ELossDistType").select(workoutFullAdd.getElevationLossDistType());
        clickOnTheMarkAsRaceButton();
        new Input(driver, "OverallPlace").write(workoutFullAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").write(workoutFullAdd.getAgeGroupPlace());
        new RadioButton(driver, "Normal").selectButton(workoutFullAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").select(workoutFullAdd.getPerceivedEffort());
        new Input(driver, "PowAvg").write(workoutFullAdd.getAvgPower());
        new Input(driver, "PowMax").write(workoutFullAdd.getMaxPower());
        new Input(driver, "CadAvg").write(workoutFullAdd.getAvgCadence());
        new Input(driver, "CadMax").write(workoutFullAdd.getMaxCadence());
        new Input(driver, "MinHR").write(workoutFullAdd.getMinHR());
        new Input(driver, "AvgHR").write(workoutFullAdd.getAvgHR());
        new Input(driver, "MaxHR").write(workoutFullAdd.getMaxHR());
        new Input(driver, "kCal").write(workoutFullAdd.getCaloriesBurned());
        clickOnTheAddWorkoutButton();
    }

    public void clickOnThePlannedDistanceButton() {
        driver.findElement(PLANNED_DIST_DURATION_BUTTON).click();
    }

    public void clickOnTheMarkAsRaceButton() {
        driver.findElement(MARK_AS_RACE_BUTTON).click();
    }

    public void clickOnTheAddWorkoutButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
}
