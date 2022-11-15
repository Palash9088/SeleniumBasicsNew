package FLipkartLoginDependsOn;//import java.util.*;

import Base.PredefinedActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlipkartLoginDependsOnTest extends PredefinedActions {

    Logger log = Logger.getLogger(getClass());
    WebDriver driver;
    WebDriverWait wait;

    public FlipkartLoginDependsOnTest()  {
    }

    @Test()
    public void setDriver() {
        driver = start("https://flipkart.com");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test(dependsOnMethods = "setDriver")
    public void doLoginIntoFlipkart() {
        log.info("depends on setDriver");
        System.out.println("Step -> Login into Flipkart");
        WebElement userLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='_2IX_2- VJZDxU']")));
        userLogin.sendKeys("userId");

        driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input[@type='password']")).sendKeys("password");

        driver.findElement(By.xpath("//div[@class='_1D1L_j']/button[@type='submit']")).click();
    }

    @Test(dependsOnMethods = "doLoginIntoFlipkart")
    public void verifyHoverList() {
        log.info("depends on do login");
        log.info("Step -> Hover on User");
        Actions actions = new Actions(driver);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#container > div > div._1kfTjk > div._1rH5Jn > div._2Xfa2_ > div:nth-child(3) > div > div > div > div")));
        actions.moveToElement(userName).build().perform();

        int expectedList = 9;
        int actualList = driver.findElements(By.xpath("//ul[@class='pO9syL undefined']/li")).size();
        Assert.assertEquals(expectedList, actualList);
    }
}
