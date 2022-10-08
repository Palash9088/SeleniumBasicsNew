/*
* https://relevel.com/courses/software-testing-course-0001/schedule/class-details/1a753a86-6c86-42e3-9945-2b5425a3abf8/assignment/280406fb-a2b1-4039-aa3b-5d81c79cebae
Home/Software Testing Course/Real Time UI Scenario - 2/Assignment -1

Assignment -1
Submission Date - 10th Oct, 2022, 10 AM
Requirements: Write code for handling the alerts and deleting the customer on the below-mentioned
* website.http://demo.guru99.com/test/delete_customer.php*/
package TestNGBasics;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AlertHandleTest extends PredefinedActions {
    WebDriver driver;

   public void setDriver()
    {
        driver = start("https://demo.guru99.com/test/delete_customer.php");
    }
    @Test
    void tHandleAlert() throws InterruptedException {
        setDriver();
        System.out.println("Step -> Enter Customer ID");
        driver.findElement(By.xpath("//*[@name='cusid']")).sendKeys("Palash");

        Thread.sleep(2000);
        System.out.println("Step -> Click on Submit button");
        driver.findElement(By.xpath("//*[@name='submit']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();

        Thread.sleep(3000);
        String actual = alert.getText();

        if(actual.equals("Customer Successfully Delete!"))
        {
            alert.accept();
            System.out.println("User Deleted successfully");
        }
        else
        {
            System.out.println("Please try again");
        }
        Assert.assertEquals(actual,"Customer Successfully Delete!");

    }

    void tearDown()
    {
        System.out.println("Closing the driver");
        driver.quit();
    }

   /* public static void main(String[] args) throws InterruptedException {
        AlertHandle alertHandle = new AlertHandle();
        alertHandle.setUp("https://demo.guru99.com/test/delete_customer.php");
        alertHandle.handleAlert();
        alertHandle.tearDown();
    }*/
}
