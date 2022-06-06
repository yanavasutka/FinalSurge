package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

@Log4j2
public class WorkoutFullAddPage extends BasePage{

    public static final By ACTIVITY_LIST = By.id("blog_accordion_left"),
            RUN_TYPE = By.xpath("//div[@id='col0']//a[@data-code='run']"),
            FARTLEK_SUBTYPE = By.xpath("//div//ul//li//a[text()='Fartlek']"),
            BIKE_TYPE = By.xpath("//div[@id='col0']//a[@data-code='bike']"),
            TEMPO_SUBTYPE = By.xpath("//div//ul//li//a[text()='Tempo']"),
            FULL_ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");

    public WorkoutFullAddPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(ACTIVITY_LIST);
    }

    @Step("Selecting the RUN as a type and FARTLEK as a subtype of a workout")
    public void selectRunType() {
        log.info("Selecting the RUN {} as a type and FARTLEK {} as a subtype of a workout", RUN_TYPE, FARTLEK_SUBTYPE);
        driver.findElement(RUN_TYPE).click();
        driver.findElement(FARTLEK_SUBTYPE).click();
    }

    @Step("Selecting the BIKE as a type and TEMPO as a subtype of a workout")
    public void selectBikeType() {
        log.info("Selecting the BIKE {} as a type and TEMPO {} as a subtype of a workout", BIKE_TYPE, TEMPO_SUBTYPE);
        driver.findElement(BIKE_TYPE).click();
        driver.findElement(TEMPO_SUBTYPE).click();
    }

    @Step("Getting the error message")
    public String getErrorMessage() {
        log.info("Getting the error message {}", FULL_ERROR_MESSAGE);
        return driver.findElement(FULL_ERROR_MESSAGE).getText();
    }

    @Step("Validation of the error message when adding a workout with invalid data")
    public void validateErrorMessage(String correctErrorMessage) {
        log.info("Validation of the error message {} when adding a workout with invalid data", FULL_ERROR_MESSAGE);
        assertEquals(getErrorMessage(), correctErrorMessage, "The error message isn't correct");
    }
}
