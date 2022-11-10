import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AssertionOnPracticeAutomationTest extends PredefinedActions {
    WebDriver driver;
    String id;
    String password;

    @BeforeClass
    public void setUp() {
        driver = start("https://practicetestautomation.com/practice-test-login/");

    }

    @Test
    public void enterDetailsAndSubmit() throws IOException {
        propertyRead();
        driver.findElement(By.id("username")).sendKeys(id);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Logged In Successfully | Practice Test Automation");

        String text = driver.findElement(By.xpath("//*[@class='has-text-align-center']")).getText();

        Assert.assertEquals(text, "Congratulations student. You successfully logged in!");
        verifyLoginButton();
    }

    public void verifyLoginButton() {
        boolean flag = driver.findElement(By.xpath("//*[text()='Log out']")).isDisplayed();
        Assert.assertTrue(flag);
    }

    public void propertyRead() throws IOException {
        File file = new File("src/main/resources/loginDetailsProp.properties");
        // to open the file
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not find");
            throw new RuntimeException(e);
        }
        // to read the file
        Properties properties = new Properties();

        // to load the file in memory
        properties.load(fileInputStream);

        id = properties.getProperty("firstName");
        password = properties.getProperty("password");
    }
}

