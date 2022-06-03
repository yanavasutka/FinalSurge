package steps;

import dto.WorkoutCalculators;
import dto.WorkoutCalculatorsFactory;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;

import static org.testng.Assert.assertTrue;

public class WorkoutCalculatorsSteps {

    HomePage homePage;
    WorkoutCalculatorsPage workoutCalculatorsPage;
    IntensityModal intensityModal;


    public WorkoutCalculatorsSteps(WebDriver driver) {
        homePage = new HomePage(driver);
        workoutCalculatorsPage = new WorkoutCalculatorsPage(driver);
        intensityModal = new IntensityModal(driver);
    }

    @Step("Choosing a calculator, entering data and getting the result")
    public void calculateWorkoutData (WorkoutCalculators workoutCalculators) {
        assertTrue(homePage.isPageOpened(), "The Home page page hasn't been opened");
        homePage.clickOnTheWorkoutCalculatorsButton();
        assertTrue(workoutCalculatorsPage.isPageOpened(), "The Workout Calculators page hasn't been opened");
        intensityModal.fillInIntensityCalculatorForm(workoutCalculators);
        String message = workoutCalculatorsPage.getSuccessMessage();
        Assert.assertEquals(message, "Your workout paces");
    }
}
