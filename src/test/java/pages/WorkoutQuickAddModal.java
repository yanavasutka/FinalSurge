package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.WorkoutQuickAdd;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class WorkoutQuickAddModal extends BasePage {

    public static final By MODAL_TITLE = By.id("WorkoutAddHeader"),
            WORKOUT_DATE = By.id("WorkoutDate"),
            WORKOUT_PACE = By.id("Pace"),
            PLANNED_DISTANCEDURATION_BUTTON = By.id("PlannedWorkout"),
            SELECT_ACTIVITY_TYPE = By.id("ActivityType"),
            MARK_AS_RACE_BUTTON = By.id("IsRace"),
            SAVE_TO_LIBRARY_BUTTON = By.id("SaveLibrary"),
            ADD_WORKOUT_BUTTON = By.id("saveButton"),
            CANCEL_BUTTON = By.id("CancelClose");

    public WorkoutQuickAddModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementPresent(MODAL_TITLE);
    }

    @Step("Filling in the Workout Quick Add form")
    public void fillInWorkoutQuickAddForm(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Filling in the Workout Quick Add form");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workoutQuickAdd.getDate());
        new Input(driver, "WorkoutTime").write(workoutQuickAdd.getTimeOfDay());
        new DropDown(driver, "ActivityType").select(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").write(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").write(workoutQuickAdd.getWorkoutDescription());
        clickOnThePlannedDistanceButton();
        new Input(driver, "PlannedDistance").write(workoutQuickAdd.getPlannedDistance());
        new DropDown(driver, "PlannedDistanceType").select(workoutQuickAdd.getPlannedDistanceType());
        new Input(driver, "PlannedDuration").write(workoutQuickAdd.getPlannedDuration());
        new Input(driver, "Distance").write(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistanceType").select(workoutQuickAdd.getPlannedDistanceType());
        new Input(driver, "Duration").write(workoutQuickAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").write(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").select(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").select(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerceivedEffort").select(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "Post Workout Notes/Results").write(workoutQuickAdd.getPostWorkoutNotesResults());
        clickOnTheSaveToLibraryButton();
        clickOnTheMarkAsRaceButton();
        new Input(driver, "OverallPlace").write(workoutQuickAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").write(workoutQuickAdd.getAgeGroupPlace());
        clickOnTheAddWorkoutButton();
    }

    public void clickOnThePlannedDistanceButton() {
        driver.findElement(PLANNED_DISTANCEDURATION_BUTTON).click();
    }

    public void clickOnTheSaveToLibraryButton() {
        driver.findElement(SAVE_TO_LIBRARY_BUTTON).click();
    }

    public void clickOnTheMarkAsRaceButton() {
        driver.findElement(MARK_AS_RACE_BUTTON).click();
    }

    public void clickOnTheAddWorkoutButton() {
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }

    public void clickOnTheCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

}
