package wrappers;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Input {

    WebDriver driver;
    String label;
    String inputLocator = "//input[@id='%s']";

    public Input (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        log.info("Writing text {} into the Input element with the label {}", text, label);
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }


}
