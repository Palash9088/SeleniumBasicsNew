package Base;//import java.util.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class PredefinedActions {
    static WebDriver driver;
    static Workbook myWorkbook;

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

    public static Object[][] readExcel(String path, String sheetName) {
        try {
            File file = new File(path);
            FileInputStream inputStream = new FileInputStream(file);
            myWorkbook = new XSSFWorkbook(inputStream);

        } catch (IOException e) {
            System.out.println("No File Found");
            throw new RuntimeException(e);
        }

        Sheet sheet = myWorkbook.getSheet(sheetName);
        int totalRows = sheet.getLastRowNum();
        int totalCols = sheet.getRow(sheet.getFirstRowNum()).getLastCellNum();

        Object[][] data = new Object[totalRows][totalCols];

        for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
            for (int colIndex = 0; colIndex < totalCols; colIndex++) {
                Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
                DataFormatter dataFormatter = new DataFormatter();

                if(CellType.NUMERIC == cell.getCellType())
                    data[rowIndex-1][colIndex] = dataFormatter.formatCellValue(cell);
                else if (CellType.STRING == cell.getCellType())
                    data[rowIndex-1][colIndex] = cell.getStringCellValue();
                else
                    data[rowIndex-1][colIndex] = " ";
            }
        }

        return data;
    }
}