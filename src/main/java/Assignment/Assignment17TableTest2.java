package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Assignment17TableTest2 extends PredefinedActions {
    WebDriver driver;

    @BeforeTest
    public void setDriver() {
        driver = start("https://editor.datatables.net/examples/extensions/excel");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void officeAndNumberOfEmployees() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        Map<String,Integer> empMap = new HashMap<>();
        int tableSize = driver.findElements(By.xpath("//span/a[@tabindex='0']")).size();

        for (int i = 1; i <= tableSize; i++) {
            int rowSize = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td[5]")).size();
            for (int j = 1; j <= rowSize; j++) {
                String empOffice = driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+j+"]/td[5]")).getText();
                if (empMap.containsKey(empOffice)) {
                    empMap.put(empOffice,empMap.get(empOffice)+1);
                } else {
                    empMap.put(empOffice,1);
                }
            }
            driver.findElement(By.xpath("//*[@id='example_paginate']/span/a[" + i + "]")).click();
        }
        System.out.println(empMap);
    }
    @Test(priority = 2)
    public void positionAndNumberOfEmployees() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        Map<String,Integer> empMap = new HashMap<>();
        int tableSize = driver.findElements(By.xpath("//span/a[@tabindex='0']")).size();

        for (int i = 1; i <= tableSize; i++) {
            int rowSize = driver.findElements(By.xpath("//*[@id='example']/tbody/tr/td[5]")).size();
            for (int j = 1; j <= rowSize; j++) {
                String empPosition = driver.findElement(By.xpath("//*[@id='example']/tbody/tr["+j+"]/td[4]")).getText();
                if (empMap.containsKey(empPosition)) {
                    empMap.put(empPosition,empMap.get(empPosition)+1);
                } else {
                    empMap.put(empPosition,1);
                }
            }
            driver.findElement(By.xpath("//*[@id='example_paginate']/span/a[" + i + "]")).click();
        }
        for(Map.Entry<String,Integer> entry : empMap.entrySet())
        {
            System.out.println(" " + entry.getKey() + " "+entry.getValue());
        }
    }
    @Test(priority = 3)
    public void addRecord()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement newBotton = driver.findElement(By.xpath("//button[@class='dt-button buttons-create']"));
        js.executeScript("arguments[0].click()",newBotton);

        js.executeScript("document.getElementById('DTE_Field_first_name').value='Palash'");
        js.executeScript("document.getElementById('DTE_Field_last_name').value='Soni'");
        js.executeScript("document.getElementById('DTE_Field_position').value='Office Manager'");

        driver.findElement(By.xpath("//input[@id='DTE_Field_office']")).sendKeys("TechnoCredits");
        driver.findElement(By.xpath("//input[@id='DTE_Field_salary']")).sendKeys("90460");
        driver.findElement(By.xpath("//button[@class='btn']")).click();

        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Palash Soni");

        String expectedFName = "Palash";
        String expectedLName = "Soni";
        String expectedPosition = "Office Manager";

        String actFirstName = driver.findElement(By.xpath("//tr[@id='row_58']//td[2]")).getText();
        String actLastName = driver.findElement(By.xpath("//tr[@id='row_58']//td[3]")).getText();
        String actPosition = driver.findElement(By.xpath("//tr[@id='row_58']//td[4]")).getText();

        Assert.assertEquals(actFirstName,expectedFName);
        Assert.assertEquals(actLastName,expectedLName);
        Assert.assertEquals(actPosition,expectedPosition);



    }
    @Test(priority = 4)
    public void deleteRecord()
    {
        driver.findElement(By.xpath("//tr[@id='row_58']/td[1]")).click();
        driver.findElement(By.xpath("//button[@class='dt-button buttons-selected buttons-remove']")).click();
        driver.findElement(By.xpath("//div[@data-dte-e='form_buttons']/button[@class='btn']")).click();

        String expText = "No matching records found";
        String actualText = driver.findElement(By.xpath("//tr[@class='odd']/td[@class='dataTables_empty']")).getText();

        Assert.assertEquals(actualText,expText);

    }
    /*@AfterMethod
    public void tearDown()
    {
        driver.quit();
    }*/
}
