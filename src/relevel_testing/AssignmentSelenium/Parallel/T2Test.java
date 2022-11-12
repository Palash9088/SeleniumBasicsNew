package Parallel;//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T2Test  extends ParallelTestAssignmentTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void init()
    {
        initializeDriver("https://www.easemytrip.com/");
    }
    @Test
    public void m1() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divnewlogin']//span[@id='spnMyAcc']"))).click();
        String expTitle = "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expTitle);
        System.out.println(Thread.currentThread().getId());
    }
}
