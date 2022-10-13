package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;

public class Assignment16TableTest extends PredefinedActions {
    WebDriver driver;

    @BeforeMethod
    public void setDriver() {
        driver = start("https://editor.datatables.net/examples/extensions/excel");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    }

    @Test(priority = 1)
    public void uniqueOfficeLocations() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        //  boolean flag = driver.findElement(By.xpath("//*[@id='example_paginate']/a[@class='paginate_button next disabled']")).isDisplayed();
        //List<WebElement> listEle = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td[5]"));
        HashSet<String> uniquePlace = new HashSet<>();
        int tableSize = driver.findElements(By.xpath("//span/a[@tabindex='0']")).size();

        for (int i = 1; i <= tableSize; i++) {
            int rowSize = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td[5]")).size();
            for (int j = 1; j <= rowSize; j++) {
                uniquePlace.add(driver.findElement(By.xpath("//*[@id='example']/tbody/tr[" + j + "]/td[5]")).getText());
            }
            driver.findElement(By.xpath("//*[@id='example_paginate']/span/a[" + i + "]")).click();
        }
        System.out.println("Unique offices");
        for (String uni : uniquePlace) {
            System.out.println(uni + " ");
        }
        System.out.println("-----------------------------------------------------------");
    }

    @Test(priority = 2)
    public void uniquePosition() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        HashSet<String> uniquePosition = new HashSet<>();
        int tableSize = driver.findElements(By.xpath("//span/a[@tabindex='0']")).size();
        for (int i = 1; i <= tableSize; i++) {
            int rowSize = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td[4]")).size();
            for (int j = 1; j <= rowSize; j++) {
                uniquePosition.add(driver.findElement(By.xpath("//*[@id='example']/tbody/tr[" + j + "]/td[4]")).getText());
            }
            driver.findElement(By.xpath("//*[@id='example_paginate']/span/a[" + i + "]")).click();
        }
        System.out.println("Unique Positions");
        for (String uni : uniquePosition) {
            System.out.println(uni + " ");
        }
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
