package tests;


import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.CalendarPage;
import pages.HomePage;
import pages.LoginPage;
import utils.PropertyReader;

//TODO почистить импорты
//TODO удалить Selenide и несиаопьзуемые либы из pom.xml
import java.time.Duration;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@Log4j2
@Listeners(TestListener.class)
public class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    CalendarPage calendarPage;

    public static final String INVALID_EMAIL = "bla@gmail.com";
    public static final String INVALID_PASSWORD = "/bla/";

    public static final String user = utils.PropertyReader.getProperty("user");
    public static final String password = utils.PropertyReader.getProperty("password");

    //TODO либо удалить лишнее либбо добавить считывание параметра
    @Parameters({"browser"})
    @BeforeMethod(description = "Opening the browser")
    public void setup(@Optional("chrome") String browser, ITestContext testContext) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        testContext.setAttribute("driver", driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        calendarPage = new CalendarPage(driver);
    }

    @AfterMethod(alwaysRun = true, description = "Closing the browser")
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
