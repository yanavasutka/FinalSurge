package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown {

    WebDriver driver;
    String label;

    public DropDown (WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void select(String option) {
        WebElement dropdown = driver.findElement(By.id(label));
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
}
