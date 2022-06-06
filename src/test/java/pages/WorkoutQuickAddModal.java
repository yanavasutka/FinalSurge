package pages;

import dto.WorkoutQuickAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import wrappers.DropDown;
import wrappers.Input;
import wrappers.TextArea;

@Log4j2
public class WorkoutQuickAddModal extends BasePage {

    public static final By MODAL_TITLE = By.id("WorkoutAddHeader"),
            SAVE_TO_LIBRARY_BUTTON = By.id("SaveLibrary"),
            WORKOUT_DATE = By.id("WorkoutDate"),
            MARK_AS_RACE_BUTTON = By.id("IsRace"),
            PLANNED_DIST_DURATION_BUTTON = By.id("PlannedWorkout"),
            WORKOUT_PACE = By.id("Pace"),
            ADD_WORKOUT_BUTTON = By.id("saveButton");
    
    public WorkoutQuickAddModal(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        return isElementPresent(MODAL_TITLE);
    }

    @Step("Filling in the Workout Quick Add form")
    public void fillInWorkoutAddForm(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Filling in the Workout Quick Add form");
        driver.findElement(WORKOUT_DATE).clear();
        new Input(driver, "WorkoutDate").write(workoutQuickAdd.getWorkoutDate());
        new Input(driver, "WorkoutTime").write(workoutQuickAdd.getTimeOfDay());
        new DropDown(driver, "ActivityType").select(workoutQuickAdd.getActivityType());
        new Input(driver, "Name").write(workoutQuickAdd.getWorkoutName());
        new TextArea(driver, "Workout Description").write(workoutQuickAdd.getWorkoutDescription());
        clickOnThePlannedDistanceButton();
        new Input(driver, "PDistance").write(workoutQuickAdd.getPlannedDistance());
        new DropDown(driver, "PDistType").select(workoutQuickAdd.getPlannedDistanceType());
        new Input(driver, "PDuration").write(workoutQuickAdd.getPlannedDuration());
        new Input(driver, "Distance").write(workoutQuickAdd.getDistance());
        new DropDown(driver, "DistType").select(workoutQuickAdd.getPlannedDistanceType());
        new Input(driver, "Duration").write(workoutQuickAdd.getDuration());
        driver.findElement(WORKOUT_PACE).clear();
        new Input(driver, "Pace").write(workoutQuickAdd.getPace());
        new DropDown(driver, "PaceType").select(workoutQuickAdd.getPaceType());
        new DropDown(driver, "HowFeel").select(workoutQuickAdd.getHowIFelt());
        new DropDown(driver, "PerEffort").select(workoutQuickAdd.getPerceivedEffort());
        new TextArea(driver, "Post Workout Notes/Results").write(workoutQuickAdd.getPostWorkoutNotesResults());
        clickOnTheSaveToLibraryButton();
        clickOnTheMarkAsRaceButton();
        new Input(driver, "OverallPlace").write(workoutQuickAdd.getOverallPlace());
        new Input(driver, "AgeGroupPlace").write(workoutQuickAdd.getAgeGroupPlace());
        clickOnTheAddWorkoutButton();
    }

    public void clickOnTheSaveToLibraryButton() {
        log.info("Clicking on the Save To Library Button {}", SAVE_TO_LIBRARY_BUTTON);
        driver.findElement(SAVE_TO_LIBRARY_BUTTON).click();
    }

    public void clickOnThePlannedDistanceButton() {
        log.info("Clicking on the Planned Distance Button {}", PLANNED_DIST_DURATION_BUTTON);
        driver.findElement(PLANNED_DIST_DURATION_BUTTON).click();
    }

    public void clickOnTheMarkAsRaceButton() {
        log.info("Clicking on the Mark As Race Button {}", MARK_AS_RACE_BUTTON);
        driver.findElement(MARK_AS_RACE_BUTTON).click();
    }

    public void clickOnTheAddWorkoutButton() {
        log.info("Clicking on the Add Workout Button {}", ADD_WORKOUT_BUTTON);
        driver.findElement(ADD_WORKOUT_BUTTON).click();
    }
}
