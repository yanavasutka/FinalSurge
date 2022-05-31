package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Input {

    WebDriver driver;
    String label;
    String inputLocator = "//input[@id='%s']";

    public Input (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));
        //JS set style
        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }


}
