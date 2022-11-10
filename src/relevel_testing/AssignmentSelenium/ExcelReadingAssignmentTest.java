import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelReadingAssignmentTest extends PredefinedActions {

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
         driver = start("http://bing.com");
    }
    @Test(dataProvider = "searchData",retryAnalyzer = retryAnalyzer.class)
    public void searchOnBing(String designation, String experience)
    {

        driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys(designation,experience);
        System.out.println("Passed data of Excel sheet");
        driver.findElement(By.xpath("//*[@id='search_icon']")).click();
        System.out.println("Clicked on Search Button");
    }
    @DataProvider(name = "searchData")
    public Object [][] searchData()
    {
        Object[][] searchData = readExcel("src/main/resources/searchData.xlsx","Data");
    return searchData;
    }
}
