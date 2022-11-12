package FacebookSignUpUnitTest;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpPageTest extends PredefinedActions {
    WebDriver driver;
    WebDriverWait wait;
    Select oSelect;

    @BeforeClass
    @Parameters("browser")
    public void startBrowser(String browser) {
        driver = multiBrowser("https://www.facebook.com/", browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test(priority = 1)
    public void verifyLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        boolean loginButtonDisplayed = loginButton.isDisplayed();
        boolean loginButtonEnabled = loginButton.isEnabled();
        Assert.assertTrue(loginButtonDisplayed);
        Assert.assertTrue(loginButtonEnabled);
    }

    @Test(priority = 2)
    public void clickOnLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        loginButton.click();
        System.out.println("Clicked on Signup");
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='_6j mvm _6wk _6wl _58mi _3ma _6o _6v']")));
        boolean elementDisplayed = element.isDisplayed();
        Assert.assertTrue(elementDisplayed);
        System.out.println("Login button Displayed");
    }

    @Test(priority = 3)
    public void verifySignUpForm() {
        boolean firstName = driver.findElement(By.xpath("//input[@name='firstname']")).isDisplayed();
        boolean lastName = driver.findElement(By.xpath("//input[@aria-label='Surname']")).isDisplayed();
        boolean email = driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).isDisplayed();
        boolean pass = driver.findElement(By.xpath("//input[@aria-label='New password']")).isDisplayed();
        boolean day = driver.findElement(By.id("day")).isDisplayed();
        boolean month = driver.findElement(By.id("month")).isDisplayed();
        boolean year = driver.findElement(By.id("year")).isDisplayed();
        boolean gender = driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']")).isDisplayed();

        Assert.assertTrue(firstName);
        Assert.assertTrue(lastName);
        Assert.assertTrue(email);
        Assert.assertTrue(pass);
        Assert.assertTrue(day);
        Assert.assertTrue(month);
        Assert.assertTrue(year);
        Assert.assertTrue(gender);
        System.out.println("All fields are displayed");
    }

    @Test(priority = 4)
    public void verifyInputs() {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Palash");
        driver.findElement(By.xpath("//input[@aria-label='Surname']")).sendKeys("Soni");
        driver.findElement(By.xpath("//input[@aria-label='Mobile number or email address']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@aria-label='New password']")).sendKeys("p@ss");

        System.out.println("Step -> sing Select class select Date, Month and Year using sequentially selectByValue(), selectByIndex() and selectByVisibleText()");
        WebElement dateOfBirth = driver.findElement(By.id("day"));
        oSelect = new Select(dateOfBirth);
        //Select oSelect = new Select(driver.findElement(By.id("day")));
        oSelect.selectByValue("6");

        WebElement birthMonth = driver.findElement(By.id("month"));
        oSelect = new Select(birthMonth);
        oSelect.selectByIndex(8);

        WebElement birthYear = driver.findElement(By.id("year"));
        oSelect = new Select(birthYear);
        //int year = Integer.parseInt("1996");
        oSelect.selectByVisibleText("1996");

        System.out.println("Step -> Select gender from given radio button options.");
        driver.findElement(By.xpath("//span[@class='_5k_2 _5dba']")).click();

        System.out.println("Step -> Click on SignUp button");
        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
    }
}
