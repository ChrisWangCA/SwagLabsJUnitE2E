package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author Chris Wang
 * @date 2025-02-27
 * The base class that manages WebDriver initialization and teardown. All other test classes can extend this to reuse the setup.
 */
public class BaseTest {

    protected static WebDriver driver;

    @BeforeAll
    public static void setUpBase() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDownBase() {
        if (driver != null) {
            driver.quit();
        }
    }
}
