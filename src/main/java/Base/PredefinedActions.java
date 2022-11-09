package Base;//import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PredefinedActions {
    static WebDriver driver;
   public static WebDriver start(String url) {
       System.out.println("STEP -> Opening Chrome Browser");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("STEP -> Opening Given " + url);
        driver.get(url);

        return driver;
    }
    public static WebDriver start() {
        System.out.println("STEP -> Opening Chrome Browser");
        System.setProperty("webdriver.chrome.driver", "src//main//resources//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("STEP -> Opening Given url");
        driver.get("http://automationbykrishna.com/");

        return driver;
    }
}
