package tests;

import dto.WorkoutFullAdd;
import dto.WorkoutFullAddFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutFullAddTest extends BaseTest{

    @Test(description = "Creating of the RUN workout with valid data using the Full Add feature")
    public void RunWorkoutShouldBeAdded() {
        loginSteps.login(user, password);
        WorkoutFullAdd workoutAdd = WorkoutFullAddFactory.getRunWorkoutWithValidData();
        workoutFullAddSteps.addRunWorkoutWithValidData(workoutAdd);
        assertTrue(workoutFullAddDetailsPage.isPageOpened(), "The workout hasn't been added to the workout library");
    }

    @Test(description = "Creating of the BIKE workout with valid data using the Full Add feature")
    public void BikeWorkoutShouldBeAdded() {
        loginSteps.login(user, password);
        WorkoutFullAdd workoutAdd = WorkoutFullAddFactory.getBikeWorkoutWithValidData();
        workoutFullAddSteps.addBikeWorkoutWithValidData(workoutAdd);
        assertTrue(workoutFullAddDetailsPage.isPageOpened(), "The workout hasn't been added to the workout library");
    }

    @Test(description = "Creating of the BIKE workout with invalid data using the Full Add feature")
    public void BikeWorkoutShouldNotBeAdded() {
        loginSteps.login(user, password);
        WorkoutFullAdd workoutAdd = WorkoutFullAddFactory.getBikeWorkoutWithInvalidData();
        workoutFullAddSteps.addBikeWorkoutWithInvalidData(workoutAdd);
        workoutFullAddPage.validateErrorMessage("×\n" +
                "Please fix the following errors:\n" +
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
