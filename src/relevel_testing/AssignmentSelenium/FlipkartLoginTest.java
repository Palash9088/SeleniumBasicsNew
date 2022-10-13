


import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class FlipkartLoginTest extends PredefinedActions {
    WebDriver driver;

    @BeforeClass
    public void setDriver()
    {
        driver = start("https://www.flipkart.com/");
    }
    @Test
    public void loginFlipkart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Step -> Login into Flipkart");
        WebElement userLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='IiD88i _351hSN']/input[@class='_2IX_2- VJZDxU']")));
        userLogin.sendKeys("TestUser");

        driver.findElement(By.xpath("//div[@class='IiD88i _351hSN']/input[@type='password']")).sendKeys("TestPass");

        driver.findElement(By.xpath("//div[@class='_1D1L_j']/button[@type='submit']")).click();

        System.out.println("Step -> Hover on User");
        Actions actions = new Actions(driver);
        WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_1kfTjk']//following::div[@class='go_DOp']/div/div/div/div[text()='Palash']")));
        actions.moveToElement(userName).build().perform();

        int expectedList = 9;
        int actualList = driver.findElements(By.xpath("//ul[@class='pO9syL undefined']/li")).size();
        Assert.assertEquals(expectedList,actualList);

    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
