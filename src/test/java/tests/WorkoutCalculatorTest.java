package tests;

import dto.WorkoutCalculator;
import org.testng.annotations.Test;
import tests.base.Retry;

public class WorkoutCalculatorTest extends BaseTest {

    @Test(description = "Checking if the Intensity Calculator functions correctly when fields are filled in with valid data")
    public void intensityCalculatorShouldCalculatePacesCorrectly () {
        loginSteps.login(user, password);
        WorkoutCalculator workoutCalculators = WorkoutCalculator.builder()
                .selectEvent("Mile")
                .hoursIntensity("0")
                .minutesIntensity("10")
                .secondsIntensity("20")
                .build();
        workoutCalculatorsSteps.calculateWorkoutData(workoutCalculators);
        workoutCalculatorsSteps.validateResults("34:27", "5:20:58", "12:15 /mi",
                "13:33 /mi", "11:25 /mi", "11:05 /mi", "10:37 /mi");
    }

    @Test(description = "Checking if the Intensity Calculator shows an error message when mismatched data is selected and entered")
    public void intensityCalculatorShouldNotBeSuccessful () {
        loginSteps.login(user, password);
        WorkoutCalculator workoutCalculators = WorkoutCalculator.builder()
                .selectEvent("Mile")
                .hoursIntensity("1")
                .minutesIntensity("50")
                .secondsIntensity("20")
                .build();
        workoutCalculatorsSteps.calculateWorkoutData(workoutCalculators);
        workoutCalculatorsSteps.validateErrorMessage("×\n" + "Please fix the following errors:\n" +
                "*Your Mile time cannot be greater than 15:45 in order to use this calculator.");
    }
}
