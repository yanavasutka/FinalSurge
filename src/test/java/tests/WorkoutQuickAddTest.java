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
        loginSteps.login(USER, PASSWORD);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithValidData();
        workoutQuickAddSteps.addWorkoutWithValidData(workoutQuickAdd);
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
    }

    @Test(description = "Creating of a workout with invalid data using the Quick Add feature")
    public void workoutShouldNotBeCreated() {
        loginSteps.login(USER, PASSWORD);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithInvalidData();
        workoutQuickAddSteps.addWorkoutWithInvalidData(workoutQuickAdd);
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
    }

    @Test(description = "Deleting of the workout from the calendar")
    public void workoutShouldBeDeleted() {
        loginSteps.login(USER, PASSWORD);
        WorkoutQuickAdd workoutQuickAdd = WorkoutQuickAddFactory.getWorkoutWithValidData();
        workoutQuickAddSteps.addWorkoutWithValidData(workoutQuickAdd);
        assertTrue(calendarPage.isPageOpened(), "Calendar page hasn't been opened");
        calendarPage.deleteWorkout(workoutQuickAdd.getWorkoutName());

    }
}
