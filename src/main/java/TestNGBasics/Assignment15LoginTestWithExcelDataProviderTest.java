package TestNGBasics;//import java.util.*;

import Base.PredefinedActions;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

public class Assignment15LoginTestWithExcelDataProviderTest extends PredefinedActions {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = start();
    }

    @Test(dataProvider = "loginDataProvider")

    public void loginTest(String uname, String pass, String expText) {
        System.out.println("Step -> Go to Login Page");
        driver.findElement(By.linkText("Registration")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("Step -> Fill login information");
        WebElement userNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='unameSignin']")));
        userNameElement.sendKeys(uname);

        driver.findElement(By.xpath("//input[@id='pwdSignin']")).sendKeys(pass);

        System.out.println("Step -> Click on submit");
        driver.findElement(By.xpath("//button[@id='btnsubmitdetails']")).click();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        alert.accept();

        Assert.assertEquals(expText, actualText);

    }

    @DataProvider(name = "loginDataProvider")
    public Object[][] loginData() throws IOException {
        //Open File
        String path = "src/main/resources/Demo.xlsx";
        File file = new File(path);
        //To read
        FileInputStream input = new FileInputStream(file);
        //File Opening
        Workbook wb = new XSSFWorkbook(input);
        Sheet sheet = wb.getSheetAt(0);

        int rowNumber = sheet.getLastRowNum()+1;
        int colsNumber = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowNumber][colsNumber];

        System.out.println(rowNumber + " " + colsNumber);

        for(int rowIndex=0;rowIndex<rowNumber;rowIndex++){
            for(int colsIndex=0;colsIndex<colsNumber;colsIndex++){
                data[rowIndex][colsIndex] =sheet.getRow(rowIndex).getCell(colsIndex).getStringCellValue();
            }
        }

        return data;
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
