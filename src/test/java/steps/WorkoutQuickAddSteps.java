package steps;

import dto.WorkoutQuickAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.WorkoutQuickAddModal;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutQuickAddSteps {

    CalendarPage calendarPage;
    WorkoutQuickAddModal workoutQuickAddModal;

    public WorkoutQuickAddSteps (WebDriver driver) {
        calendarPage = new CalendarPage(driver);
        workoutQuickAddModal = new WorkoutQuickAddModal(driver);
    }

    @Step("Adding of a new workout with valid data to the library")
    public void addWorkoutWithValidData(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Adding of a new workout to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheQuickAddButton();
        assertTrue(workoutQuickAddModal.isPageOpened(), "Workout Quick Add modal hasn't been opened");
        workoutQuickAddModal.fillInWorkoutQuickAddForm(workoutQuickAdd);
        String error = calendarPage.getErrorMessage();
        assertEquals(error, "×\n" + "*The workout was successfully saved to your Workout Library.", "The workout hasn't been added to the workout library");;
    }

    @Step("Adding of a new workout with invalid data to the library")
    public void addWorkoutWithInvalidData(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Adding of a new workout  with invalid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheQuickAddButton();
        assertTrue(workoutQuickAddModal.isPageOpened(), "Workout Quick Add modal hasn't been opened");
        workoutQuickAddModal.fillInWorkoutQuickAddForm(workoutQuickAdd);
        String error = calendarPage.getErrorMessage();
        assertEquals(error, "×\n" + "Please fix the following errors:\n" +
                "*Please select a valid Activity Type.\n" +
                "*Please enter a value for Workout Date.\n" +
                "*Please enter a valid Time of Day.\n" +
                "*The Workout Name cannot be more than 200 characters.\n" +
                "*Please enter a valid Planned Distance.\n" +
                "*Please enter a valid Distance.\n" +
                "*Please enter a valid Pace in the format minutes:seconds (mm:ss).\n" +
                "*Please enter a valid Integer for Overall Place (no decimals).\n" +
                "*Please enter a valid Integer for Age Group Place (no decimals).", "The workout hasn't been added to the workout library");;
    }
}
