package steps;

import dto.WorkoutFullAdd;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.CalendarPage;
import pages.WorkoutFullAddDetailsPage;
import pages.WorkoutFullAddModal;
import pages.WorkoutFullAddPage;

import static org.testng.Assert.assertEquals;
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
    public void addRunWorkoutWithValidData(WorkoutFullAdd workoutFullAdd) {
        log.info("Adding of the RUN workout with valid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectRunType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInRunWorkoutFullAddForm(workoutFullAdd);
        assertTrue(workoutFullAddDetailsPage.isPageOpened(), "The workout hasn't been added to the workout library");
    }

    @Step("Adding of the BIKE workout with valid data to the library")
    public void addBikeWorkoutWithValidData(WorkoutFullAdd workoutFullAdd) {
        log.info("Adding of the BIKE workout with valid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectBikeType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInBikeWorkoutFullAddForm(workoutFullAdd);
        assertTrue(workoutFullAddDetailsPage.isPageOpened(), "The workout hasn't been added to the workout library");
    }

    @Step("Adding of the BIKE workout with invalid data to the library")
    public void addBikeWorkoutWithInvalidData(WorkoutFullAdd workoutFullAdd) {
        log.info("Adding of the BIKE workout with invalid data to the library");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.clickOnTheFullAddButton();
        workoutFullAddPage.selectBikeType();
        assertTrue(workoutFullAddModal.isPageOpened(), "Workout Full Add modal hasn't been opened");
        workoutFullAddModal.fillInBikeWorkoutFullAddForm(workoutFullAdd);
        String error = workoutFullAddPage.getErrorMessage();
        assertEquals(error, "×\n" +"Please fix the following errors:\n" +
                "*Please enter a value for Workout Date.\n" +
                "*Please enter a valid Time of Day.\n" +
                "*The Workout Name cannot be more than 200 characters.\n" +
                "*Please enter a valid Distance.\n" +
                "*Please enter a valid Planned Distance.\n" +
                "*Please enter a valid Integer for Overall Place (no decimals).\n" +
                "*Please enter a valid Integer for Age Group Place (no decimals).\n" +
                "*Please enter a valid Elevation Gain.\n" +
                "*Please enter a valid Elevation Loss.\n" +
                "*Please enter a valid Integer for Average Wattage (no decimals).\n" +
                "*Please enter a valid Integer for Maximum Wattage (no decimals).\n" +
                "*Please enter a valid Integer for Average Cadence (no decimals).\n" +
                "*Please enter a valid Integer for Maximum Cadence (no decimals).\n" +
                "*Please enter a valid Integer for Minimum Heartrate (no decimals).\n" +
                "*Please enter a valid Integer for Average Heartrate (no decimals).\n" +
                "*Maximum Heartrate cannot be greater than 300.\n" +
                "*Please enter a valid Integer for Calories Burned (no decimals).");
    }
}
