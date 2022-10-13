import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class AssignmentFacebookUsingWaitTest extends PredefinedActions {
    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        driver = start("https://www.facebook.com/");
    }

    @Test
    public void facebookLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expectedTitle = "Facebook – log in or sign up";
        String actualTitle = driver.getTitle();

        System.out.println("Enter Login Details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']"))).sendKeys("1");
        driver.findElement(By.cssSelector("input#pass")).sendKeys("1");
        driver.findElement(By.xpath("//button[@name='login']")).click();

        System.out.println("Verify title");
        Assert.assertEquals(expectedTitle, actualTitle);

        System.out.println("Verify wait till image is available");
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Create story']")));
        boolean flag = driver.findElement(By.xpath("//a[@aria-label='Create story']")).isDisplayed();
        Assert.assertTrue(flag, "Visible");
        image.click();

        System.out.println("Verify Story page title");
        wait.until(ExpectedConditions.titleIs("Create Stories | Facebook"));
        String actualStoryTitle = driver.getTitle();
        String expectedStoryTitle = "Create Stories | Facebook";
        Assert.assertEquals(expectedStoryTitle, actualStoryTitle);

    }
    @AfterTest
    public void tearDown()
    {
        driver.close();
    }

}
