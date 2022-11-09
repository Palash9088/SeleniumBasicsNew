
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClass {
    public static class TestCaseCheck {
        String baseUrl = "https://www.google.com/";
        WebDriver driver;

        @BeforeMethod
        public void beforeMethod() {
            String driverpath = "src/main/resources/chromedriver.exe";

            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();

            driver.get("https://en-gb.facebook.com/login/");
            driver.get(baseUrl);
            System.out.println("Test case started");
        }

        @Test
        public void getGoogleTest() {
            String testTitle = "Google";
            String originalTitle = driver.getTitle();
            Assert.assertEquals(originalTitle, testTitle);
        }

        @AfterMethod
        public void afterMethod() {
            driver.close();
            System.out.println("test cased finished");
        }
    }
}
