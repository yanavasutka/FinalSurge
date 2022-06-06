package steps;

import dto.WorkoutFullAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.WorkoutFullAddDetailsPage;
import pages.WorkoutFullAddModal;
import pages.WorkoutFullAddPage;

import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutFullAddSteps {

    CalendarPage calendarPage;
    WorkoutFullAddModal workoutFullAddModal;
    WorkoutFullAddPage workoutFullAddPage;
    WorkoutFullAddDetailsPage workoutFullAddDetailsPage;

    public WorkoutFullAddSteps(WebDriver driver) {
        calendarPage = new CalendarPage(driver);
        workoutFullAddModal = new WorkoutFullAddModal(driver);
        workoutFullAddPage = new WorkoutFullAddPage(driver);
        workoutFullAddDetailsPage = new WorkoutFullAddDetailsPage(driver);
    }

    @Step("Adding of the RUN workout with valid data to the library")
    public void addRunWorkoutWithValidData(WorkoutFullAdd workoutAdd) {
        log.info("Adding of the RUN workout with valid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectRunType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInRunWorkoutFullAddForm(workoutAdd);
    }

    @Step("Adding of the BIKE workout with valid data to the library")
    public void addBikeWorkoutWithValidData(WorkoutFullAdd workoutAdd) {
        log.info("Adding of the BIKE workout with valid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectBikeType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInBikeWorkoutFullAddForm(workoutAdd);
    }

    @Step("Adding of the BIKE workout with invalid data to the library")
    public void addBikeWorkoutWithInvalidData(WorkoutFullAdd workoutAdd) {
        log.info("Adding of the BIKE workout with invalid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectBikeType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInBikeWorkoutFullAddForm(workoutAdd);
    }
}
