package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutCalculatorsPage extends BasePage {

    public static final By HANSONS_BUTTON = By.xpath("//a[contains(text(), 'Hansons')]"),
            MCMILLAN_BUTTON = By.xpath("//a[contains(text(), 'McMillan')]"),
            TINMAN_BUTTON = By.xpath("//a[contains(text(), 'Tinman')]"),
            PALLADINO_BUTTON = By.xpath("//a[contains(text(), 'Palladino')]"),
            SUCCESS_MESSAGE = By.xpath("//h4[contains(text(), 'Your Workout Paces')]");
    public static final String IFRAME = "IntensityCalciFrame";

    public WorkoutCalculatorsPage (WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(HANSONS_BUTTON);
    }

    @Step("Opening the Hansons calculator on the Calculator page")
    public void clickOnTheHansonsButton() {
        driver.switchTo().frame(IFRAME);
        log.info("Clicking on {} to open the Hansons calculator on the Calculator page", HANSONS_BUTTON);
        driver.findElement(HANSONS_BUTTON).click();
    }

    @Step("Opening the McMillan calculator on the Calculator page")
    public void clickOnTheMcMillanButton() {
        driver.switchTo().frame(IFRAME);
        log.info("Clicking on {} to open the McMillan calculator on the Calculator page", MCMILLAN_BUTTON);
        driver.findElement(MCMILLAN_BUTTON).click();
    }

    @Step("Opening the Tinman calculator on the Calculator page")
    public void clickOnTheTinmanButton() {
        driver.switchTo().frame(IFRAME);
        log.info("Clicking on {} to open the Tinman calculator on the Calculator page", TINMAN_BUTTON);
        driver.findElement(TINMAN_BUTTON).click();
    }

    @Step("Opening the Palladino calculator on the Calculator page")
    public void clickOnThePalladinoButton() {
        driver.switchTo().frame(IFRAME);
        log.info("Clicking on {} to open the Palladino calculator on the Calculator page", PALLADINO_BUTTON);
        driver.findElement(PALLADINO_BUTTON).click();
    }

    @Step("Getting the success message")
    public String getSuccessMessage() {
        return driver.findElement(SUCCESS_MESSAGE).getText();
    }
}
