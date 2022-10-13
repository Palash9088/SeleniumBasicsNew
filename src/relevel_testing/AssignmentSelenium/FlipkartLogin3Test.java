import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class FlipkartLogin3Test extends PredefinedActions {
    WebDriver driver;
    @BeforeClass
    public void setDriver()
    {
        driver = start("https://www.flipkart.com/");
    }
    @Test
    public void loginFlipkart() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_2Sn47c']//descendant::button[@class='_2KpZ6l _2doB4z']"))).click();
        driver.findElement(By.xpath("//a[text()='Login']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='_36HLxm col col-3-5']"))).sendKeys("himanshuKeshari987@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Himsans@123");
        driver.findElement(By.xpath("//span[@class='_36KMOx']/span")).submit();
        WebElement menu= driver.findElement(By.xpath("//body/div[@id='container']/div[1]/div[1]/div[1]/div[2]/div[3]"));
        Actions act = new Actions(driver);
        act.moveToElement(menu).perform();
        driver.findElement(By.xpath("//span[text()='Cart']")).click();
        WebElement el= driver.findElement(By.xpath("//img[@class='_2xm1JU']"));
        Boolean flag=  el.isDisplayed();
        Assert.assertTrue(flag, "Flipkart is not displayed");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));//Closes the current window
    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }
}
