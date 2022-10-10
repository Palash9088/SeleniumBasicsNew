import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlipkartLogin2Test extends PredefinedActions {
    WebDriver driver;
    @BeforeClass
    public void setDriver()
    {
        driver = start("https://www.flipkart.com/");
    }
    @Test
    public void loginFlipkart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_2Sn47c']//descendant::button[@class='_2KpZ6l _2doB4z']"))).click();

        driver.findElement(By.xpath("//span[text()='Cart']")).click();

       WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_2KpZ6l _1sbqEe _3AWRsL']/span")));
       el.click();
       String text = el.getText();
       Assert.assertEquals(text,"Login");
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
