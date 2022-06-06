package steps;

import dto.WorkoutCalculator;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.WorkoutCalculatorModal;

import static org.testng.Assert.assertTrue;

@Log4j2
public class WorkoutCalculatorSteps {

    HomePage homePage;
    WorkoutCalculatorModal workoutCalculatorsModal;


    public WorkoutCalculatorSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        workoutCalculatorsModal = new WorkoutCalculatorModal(driver);
    }

    @Step("Choosing a calculator, entering data and clicking on the Calculate Paces button")
    public void calculateWorkoutData (WorkoutCalculator workoutCalculators) {
        assertTrue(homePage.isPageOpened(), "The Home page hasn't been opened");
        homePage.clickOnTheWorkoutCalculatorsButton();
        assertTrue(workoutCalculatorsModal.isPageOpened(), "The Workout Calculators Modal hasn't been opened");
        //workoutCalculatorsModal.selectCalculator(calculator);
        workoutCalculatorsModal.fillInIntensityCalculatorForm(workoutCalculators);
    }

    @Step("Validation of the Intensity calculator results")
    public void validateResults(String correct5KPR, String correctMarathonPR, String correctMarathonPace,
                                String correctLongRunPace, String correctAnaerobicThreshold, String correctVO2MaxSlow, String correctVO2MaxFast) {
        log.info("Validation of the Intensity calculator results");
        workoutCalculatorsModal.validateResults(correct5KPR, correctMarathonPR, correctMarathonPace,
                correctLongRunPace, correctAnaerobicThreshold, correctVO2MaxSlow, correctVO2MaxFast);
    }

    @Step("Validation of the error message when adding a workout with invalid data")
    public void validateErrorMessage(String correctErrorMessage) {
        log.info("Validation of the error message when adding a workout with invalid data");
        workoutCalculatorsModal.validateErrorMessage(correctErrorMessage);
    }


}
