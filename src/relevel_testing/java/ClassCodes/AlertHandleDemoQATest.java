
package java.ClassCodes;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class AlertHandleDemoQATest extends PredefinedActions {
    WebDriver driver;

    public void setUp() {
        driver = start("https://demoqa.com/alerts");
    }

    public void handleAlert() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("Step -> Click on  button");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//button[@id='promtButton']")));
        driver.findElement(By.xpath("//button[@id='promtButton']")).click();

        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        String keyText = "Palash";
        alert.sendKeys(keyText);
        alert.accept();

        String expText = driver.findElement(By.xpath("//span[@id='promptResult']")).getText();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(expText, "You entered " + keyText, "hello");
    }

    public void tearDown() {
        System.out.println("Closing the driver");
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException {
        AlertHandleDemoQATest alertHandle = new AlertHandleDemoQATest();
        alertHandle.setUp();
        alertHandle.handleAlert();
        alertHandle.tearDown();
    }
}

