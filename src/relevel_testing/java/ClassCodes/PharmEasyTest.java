package ClassCodes;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PharmEasyTest extends PredefinedActions {

    WebDriver driver;

    public void setDriver(String url) {
        driver = start(url);
    }

    public void searchTest() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='c-PJLV c-bXbWpx c-bXbWpx-icOztnM-css']")));
        element.click();

        driver.findElement(By.id("topBarInput")).sendKeys("Shelcal");

        driver.findElement(By.xpath("//*[@class='c-PJLV c-bXbWpx c-bXbWpx-bZJlhX-direction-column c-bXbWpx-iieFQlv-css']//following-sibling::a[@class='c-iWbDBM c-iWbDBM-ibSXgdl-css']")).click();
    }

    public static void main(String[] args) {
        PharmEasyTest test = new PharmEasyTest();
        test.setDriver("https://pharmeasy.in/");
        test.searchTest();
    }
}
