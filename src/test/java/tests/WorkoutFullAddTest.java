package tests;

import dto.WorkoutFullAdd;
import dto.WorkoutFullAddFactory;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class WorkoutFullAddTest extends BaseTest{

    @Test(description = "Creating of the RUN workout with valid data using the Full Add feature")
    public void RunWorkoutShouldBeAdded() {
        loginSteps.login(USER, PASSWORD);
        WorkoutFullAdd workoutFullAdd = WorkoutFullAddFactory.getRunWorkoutWithValidData();
        workoutFullAddSteps.addRunWorkoutWithValidData(workoutFullAdd);
    }

    @Test(description = "Creating of the BIKE workout with valid data using the Full Add feature")
    public void BikeWorkoutShouldBeAdded() {
        loginSteps.login(USER, PASSWORD);
        WorkoutFullAdd workoutFullAdd = WorkoutFullAddFactory.getBikeWorkoutWithValidData();
        workoutFullAddSteps.addBikeWorkoutWithValidData(workoutFullAdd);
    }

    @Test(description = "Creating of the BIKE workout with invalid data using the Full Add feature")
    public void BikeWorkoutShouldBeNotAdded() {
        loginSteps.login(USER, PASSWORD);
        WorkoutFullAdd workoutFullAdd = WorkoutFullAddFactory.getBikeWorkoutWithInvalidData();
        workoutFullAddSteps.addBikeWorkoutWithInvalidData(workoutFullAdd);
    }




}
