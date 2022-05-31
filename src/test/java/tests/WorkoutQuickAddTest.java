package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

@Log4j2
public class WorkoutQuickAddTest extends BaseTest {

    @Test(description = "Quick add workout test")
    public void workoutQuickAddTest() {

        loginPage.open()
                .login(user, password);
        calendarPage
                .open()
                .clickOnTheQuickAddButton()
                .quickAddWorkout(workoutQuickAdd);
    }

}
