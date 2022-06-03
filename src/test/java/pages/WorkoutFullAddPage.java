package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Log4j2
public class WorkoutFullAddPage extends BasePage{

    public static final By ACTIVITY_LIST = By.id("blog_accordion_left"),
            RUN_TYPE = By.xpath("//div[@id='col0']//a[@data-code='run']"),
            FARTLEK_SUBTYPE = By.xpath("//div//ul//li//a[text()='Fartlek']"),
            BIKE_TYPE = By.xpath("//div[@id='col0']//a[@data-code='bike']"),
            TEMPO_SUBTYPE = By.xpath("//div//ul//li//a[text()='Tempo']"),
            ERROR_MESSAGE = By.xpath("//div[@class='alert alert-error']");

    public WorkoutFullAddPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(ACTIVITY_LIST);
    }

    @Step("Opening Workout page")
    public void open() {
        log.info("Opening Workout Page {}", BASE_URL);
        driver.get(BASE_URL + "WorkoutAdd.cshtml");
        wait.until(ExpectedConditions.visibilityOfElementLocated(ACTIVITY_LIST));
    }

    @Step("Selecting RUN as the workout type and FARTLEK as the subtype")
    public void selectRunType(){
        driver.findElement(RUN_TYPE).click();
        driver.findElement(FARTLEK_SUBTYPE).click();
    }

    @Step("Selection of the type and subtype of a workout")
    public void selectBikeType() {
        driver.findElement(BIKE_TYPE).click();
        driver.findElement(TEMPO_SUBTYPE).click();
    }

    @Step("Getting the error message")
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
