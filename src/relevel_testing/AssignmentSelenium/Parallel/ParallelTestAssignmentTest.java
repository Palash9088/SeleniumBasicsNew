package Parallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class ParallelTestAssignmentTest  {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void initializeDriver(String url) {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.get(url);
    }
    //@AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Driver Closed");
    }

}
