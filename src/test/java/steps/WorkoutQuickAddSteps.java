package steps;

import dto.WorkoutQuickAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.WorkoutQuickAddModal;

import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutQuickAddSteps {

    CalendarPage calendarPage;
    WorkoutQuickAddModal WorkoutQuickAddModal;

    public WorkoutQuickAddSteps (WebDriver driver) {
        calendarPage = new CalendarPage(driver);
        WorkoutQuickAddModal = new WorkoutQuickAddModal(driver);
    }

    @Step("Adding of a new workout with valid data to the library")
    public void addWorkoutWithValidData(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Adding of a new workout to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheQuickAddButton();
        assertTrue(WorkoutQuickAddModal.isPageOpened(), "Workout Quick Add modal hasn't been opened");
        WorkoutQuickAddModal.fillInWorkoutAddForm(workoutQuickAdd);
    }

    @Step("Adding of a new workout with invalid data to the library")
    public void addWorkoutWithInvalidData(WorkoutQuickAdd workoutQuickAdd) {
        log.info("Adding of a new workout  with invalid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheQuickAddButton();
        assertTrue(WorkoutQuickAddModal.isPageOpened(), "Workout Quick Add modal hasn't been opened");
        WorkoutQuickAddModal.fillInWorkoutAddForm(workoutQuickAdd);
    }
}
