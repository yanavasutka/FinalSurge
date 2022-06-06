package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Log4j2
public class DropDown {

    WebDriver driver;
    String label;

    public DropDown (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        log.info("Choosing the option {} from the DropDown element with the label {}", option, label);
        WebElement dropdown = driver.findElement(By.id(label));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
}
