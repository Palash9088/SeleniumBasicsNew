import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelTestAssignmentTest extends PredefinedActions {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void initializeDriver() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @Test
    public void m1() {

        driver.get("https://relevel.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@rel-name='HeaderRegisterCTAClicked']"))).click();
        String expectedTitle = "Relevel - Unlock your dream job";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void m2() {

        driver.get("https://www.easemytrip.com/");
        System.out.println(Thread.currentThread().getId());


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='divnewlogin']//span[@id='spnMyAcc']"))).click();
        String expTitle = "Book Flights, Hotels, Bus Tickets & Holidays - EaseMyTrip.com";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expTitle);
        System.out.println(Thread.currentThread().getId());
    }

    @Test
    public void m3() {
        driver.get("https://google.com");
    }

    //@AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("Driver Closed");
    }

}
