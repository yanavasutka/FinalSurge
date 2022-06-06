package pages;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutFullAddDetailsPage extends BasePage {

    public static final By SHARE_BUTTON = By.cssSelector("[data-target='#ShareDiv']");

    public WorkoutFullAddDetailsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementPresent(SHARE_BUTTON);
    }
}
