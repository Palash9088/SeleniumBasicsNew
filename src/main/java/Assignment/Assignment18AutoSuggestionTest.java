package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assignment18AutoSuggestionTest extends PredefinedActions {
    WebDriver driver;
    String actualDate;

    @BeforeTest
    public void setDriver() {
        driver = start("https://www.goibibo.com/");
    }

    @BeforeTest
    public void date() {
        String pattern = "MMMM yyyy dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        this.actualDate = date;
        System.out.println(date);
    }
    @BeforeTest
    public void weekVerify()
    {

        List <String> weekList = new ArrayList<>();
        weekList.add("Monday");
        weekList.add("Tuesday");
        weekList.add("Wednesday");
        weekList.add("Thursday");
        weekList.add("Friday");
        weekList.add("Saturday");
        weekList.add("Sunday");


    }

    @Test
    public void verifyAutoSuggestion() throws InterruptedException {
        String expectedSource = "Pune, India";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Selecting round trip");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='sc-fvxzrP cCkBwj']//li[2]/span[text()='Round-trip']"))).click();
        //driver.findElement(By.xpath("//span[@class='sc-GEbAx izHSju']")).click();
        boolean roundTrip = driver.findElement(By.xpath("//ul[@class='sc-fvxzrP cCkBwj']//li[2]/span[text()='Round-trip']")).isEnabled();
        Assert.assertTrue(roundTrip);

        System.out.println("Print all Options & Choose Pune");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sc-hiCibw dGZLZw']//p[@class='sc-iJKOTD iipKRx fswWidgetPlaceholder']"))).click();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("pun");
        Thread.sleep(1500);
        List<WebElement> fromList = driver.findElements(By.xpath("//ul[@id='autoSuggest-list']//div//p//span[1]"));
        int listSize = driver.findElements(By.xpath("//ul[@id='autoSuggest-list']//div//p//span[1]")).size();
        String actualSource = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li[1]//p/span[1]")).getText();
        for (int i = 1; i <= listSize; i++) {
            WebElement source = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li[" + i + "]//p/span[1]"));
            System.out.println(source.getText());
        }
        for (WebElement element : fromList) {
            if (element.getText().contains("Pune, India")) {
                element.click();
                break;
            }
        }
        Assert.assertEquals(actualSource, "Pune, India ");

        //for Destination
        Actions actions = new Actions(driver);
        System.out.println("Print all destination options & Choose Delhi");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@type='text']"))).sendKeys("Del");
        driver.findElement(By.xpath("//*[@type='text']")).click();
        List<WebElement> toList = driver.findElements(By.xpath("//ul[@id='autoSuggest-list']//div//p//span[1]"));
        System.out.println("List of all available Destination");
        String actualDestination = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li[1]//p/span[1]")).getText();
        for (int i = 1; i <= listSize; i++) {
            WebElement source = driver.findElement(By.xpath("//ul[@id='autoSuggest-list']//li[" + i + "]//p/span[1]"));
            System.out.println(source.getText());
        }
        for (WebElement toElement : toList) {
            System.out.println(toElement.getText());
            if (toElement.getText().contains("New Delhi, India ")) {
                actions.click(toElement).build().perform();
                break;
            }
        }
        Assert.assertEquals(actualDestination, "New Delhi, India ");

        System.out.println("Select today's date");
        driver.findElement(By.xpath("//*[@class='DayPicker-Body']//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']")).click();

        String expectedDate = (driver.findElement(By.xpath("//*[@class='DayPicker-Body']//div[@class='DayPicker-Day DayPicker-Day--start DayPicker-Day--selected DayPicker-Day--today']/p[@class='fsw__date']")).getText());
        String expectedMonthYear = driver.findElement(By.xpath("//*[contains(text(),'October 2022')]")).getText();

        String expectedDates = expectedMonthYear + " " + expectedDate;
        System.out.println(expectedDates);
        Assert.assertEquals(actualDate, expectedDates);




    }
}
