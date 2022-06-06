package tests;

import dto.WorkoutQuickAdd;
import dto.WorkoutQuickAddFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutQuickAddTest extends BaseTest {

    @Test(description = "Creating of a workout with valid data using the Quick Add feature")
    public void WorkoutShouldBeCreated() {
        loginSteps.login(user, password);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithValidData();
        WorkoutQuickAddSteps.addWorkoutWithValidData(workoutQuickAdd);
        calendarPage.validateErrorMessage("×\n" + "*The workout was successfully saved to your Workout Library.");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
    }

    @Test(description = "Creating of a workout with invalid data using the Quick Add feature")
    public void workoutShouldNotBeCreated() {
        loginSteps.login(user, password);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithInvalidData();
        WorkoutQuickAddSteps.addWorkoutWithInvalidData(workoutQuickAdd);
        calendarPage.validateErrorMessage("×\n" + "Please fix the following errors:\n" +
                "*Please select a valid Activity Type.\n" +
                "*Please enter a value for Workout Date.\n" +
                "*Please enter a valid Time of Day.\n" +
                "*The Workout Name cannot be more than 200 characters.\n" +
                "*Please enter a valid Planned Distance.\n" +
                "*Please enter a valid Distance.\n" +
                "*Please enter a valid Pace in the format minutes:seconds (mm:ss).\n" +
                "*Please enter a valid Integer for Overall Place (no decimals).\n" +
                "*Please enter a valid Integer for Age Group Place (no decimals).");
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
    }

    @Test(description = "Deleting of the workout from the calendar")
    public void workoutShouldBeDeleted() {
        loginSteps.login(user, password);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithValidData();
        WorkoutQuickAddSteps.addWorkoutWithValidData(workoutQuickAdd);
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.deleteWorkout(workoutQuickAdd.getWorkoutName());
    }
}
