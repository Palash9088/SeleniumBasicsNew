

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class FacebookTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://en-gb.facebook.com/login/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @Test(dataProvider = "loginData")
    public void facebookLoginNegativeScenarioTest(String username, String password, String expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();
        //if(driver.findElement(By.xpath("//span[@class='_97w1 _50f6']/div[@class='_9axz']")).getText().equals("Log in to Facebook"))

        String actualText = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
        Assert.assertEquals(actualText, expectedText);

    }
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        Object[][] data = new Object[5][3];

        data[0][0] = "kailashsoni007test@gmail.com";
        data[0][1] = "kailashbaba";
        data[0][2] = "The password that you've entered is incorrect. Forgotten password?";

        data[1][0] = "kailashsoni007test@yahoo.com";
        data[1][1] = "WrongPassword";
        data[1][2] = "The email address you entered isn't connected to an account. Find your account and log in.";

        data[2][0] = "RelevelTest@gmail.com";
        data[2][1] = "relevel";
        data[2][2] = "The email address you entered isn't connected to an account. Find your account and log in.";

        data[3][0] = "";
        data[3][1] = "";
        data[3][2] = "The email address or mobile number you entered isn't connected to an account. Find your account and log in.";

        data[4][0] = "RelevelTest@gmail.com";
        data[4][1] = "";
        data[4][2] = "The email address you entered isn't connected to an account. Find your account and log in.";

        return data;
    }

    @Test(dataProvider = "loginDataPositive")
    public void facebookLoginNegativeScenarioTest(String username, String password, boolean expectedText) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys(username);
        driver.findElement(By.id("pass")).sendKeys(password);
        driver.findElement(By.id("loginbutton")).click();

        Boolean actualText = wait.until(ExpectedConditions.titleIs("Facebook"));
        Assert.assertEquals(actualText, expectedText);
    }
    @DataProvider(name = "loginDataPositive")
    public Object[][] loginDataPositive() {
        Object[][] data = new Object[1][3];
        data[0][0] = "kailashsoni007test@gmail.com";
        data[0][1] = "Kailash_somnath";
        data[0][2] = true;
        return data;
    }

}
