package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.LinkedHashSet;
import java.util.Set;

public class Assignment9EmployeeTableExComparator extends PredefinedActions {
    WebDriver driver;
    void setUp() {
        driver = start(); // if we did not catch here in driver it will give null pointer exception
    }
    void openPage() throws InterruptedException {
        System.out.println("Opening Demo Table page");
        driver.findElement(By.linkText("Demo Tables")).click();
        Thread.sleep(3000);
    }

    void addEmpToSet() {
        Set<Assignment9Employee> employeesSet = new LinkedHashSet<>();
        int totalRows = driver.findElements(By.xpath("//table[@class='table table-striped']/tbody/tr")).size();
        for (int index = 1; index <= totalRows; index++) {
            int empId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[2]")).getText());
            String empName = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[3]")).getText();
            int empMgrId = Integer.parseInt(driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[4]")).getText());
            String empDept = driver.findElement(By.xpath("//table[@class='table table-striped']/tbody/tr[" + index + "]/td[5]")).getText();

            Assignment9Employee e1 = new Assignment9Employee();
            e1.setEmpId(empId);
            e1.setEmpName(empName);
            e1.setEmpManagerId(empMgrId);
            e1.setEmpDept(empDept);

            boolean flag = employeesSet.add(e1);
            {
                if (!flag)
                {
                    System.out.println("Duplicate row "+" Employee Id is :" + e1.getEmpId() + " Employee Name is :" + e1.getEmpName());
                }
            }
            employeesSet.add(e1);
        }
        System.out.println("No. of Unique Rows are :" + employeesSet.size());

    }

    public static void main(String[] args) throws InterruptedException {
        Assignment9EmployeeTableExComparator obj = new Assignment9EmployeeTableExComparator();
        obj.setUp();
        obj.openPage();
        obj.addEmpToSet();
        obj.tearDown();
    }

    void tearDown() {
        driver.quit();
    }
}

