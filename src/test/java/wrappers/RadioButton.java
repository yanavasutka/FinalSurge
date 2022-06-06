package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class RadioButton {

    WebDriver driver;
    String label;
    String radioButtonLocator = "//label[contains(.,'%s')]/input";

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void selectButton(String text) {
        log.info("Choosing the option {} from the RadioButton element with the label {}", text, label);
        driver.findElement(By.xpath(String.format(radioButtonLocator, label))).click();
    }
}
