package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.LoginSteps;
import steps.WorkoutCalculatorSteps;
import steps.WorkoutFullAddSteps;
import steps.WorkoutQuickAddSteps;
import tests.base.TestListener;

import java.time.Duration;


@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CalendarPage calendarPage;
    LoginSteps loginSteps;
    WorkoutQuickAddSteps WorkoutQuickAddSteps;
    WorkoutFullAddSteps workoutFullAddSteps;
    WorkoutFullAddPage workoutFullAddPage;
    WorkoutFullAddDetailsPage workoutFullAddDetailsPage;
    WorkoutCalculatorSteps workoutCalculatorsSteps;

    public static final String INVALID_EMAIL = "bla@gmail.com";
    public static final String INVALID_PASSWORD = "/bla/";
    public static final String user = utils.PropertyReader.getProperty("user");
    public static final String password = utils.PropertyReader.getProperty("password");


    @BeforeMethod(description = "Opening the browser")
    public void setup(ITestContext testContext) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        testContext.setAttribute("driver", driver);

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        calendarPage = new CalendarPage(driver);
        loginSteps = new LoginSteps(driver);
        WorkoutQuickAddSteps = new WorkoutQuickAddSteps(driver);
        workoutFullAddSteps = new WorkoutFullAddSteps(driver);
        workoutFullAddPage = new WorkoutFullAddPage(driver);
        workoutFullAddDetailsPage = new WorkoutFullAddDetailsPage(driver);
        workoutCalculatorsSteps = new WorkoutCalculatorSteps(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
