
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookLoginParameterTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://en-gb.facebook.com/login/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }


    @Test
    @Parameters({"username","password","expectedText"})
    public void facebookLoginTest(String username, String password, boolean expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();

        Boolean actualText = wait.until(ExpectedConditions.titleIs("Facebook"));
        Assert.assertEquals(actualText, expectedText);

    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
        System.out.println("Driver closed");
    }
}
