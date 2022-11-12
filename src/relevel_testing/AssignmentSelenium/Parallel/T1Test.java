package Parallel;//import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T1Test extends ParallelTestAssignmentTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void init()
    {
        initializeDriver("https://relevel.com/");
    }
    @Test
    public void m1() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@rel-name='HeaderRegisterCTAClicked']"))).click();
        String expectedTitle = "Relevel - Unlock your dream job";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        System.out.println(Thread.currentThread().getId());
    }

}
