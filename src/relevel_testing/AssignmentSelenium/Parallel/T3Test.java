package Parallel;//import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T3Test extends ParallelTestAssignmentTest{
    WebDriver driver;
    @BeforeClass
    public void init()
    {
        initializeDriver("https://google.com");
    }

    @Test
    public void m1() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

}
