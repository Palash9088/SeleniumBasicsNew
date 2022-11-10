import Base.PredefinedActions;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ExcelTest extends PredefinedActions {
    public static Object print2D(Object[][] mat)
    {
        // Loop through all rows
        for (Object[] row : mat)

            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
        return "";
    }
    @Test
    public void excelRead()
    {
        Object[][] data = readExcel("src/main/resources/Demo.xlsx","LoginData");

        System.out.println(print2D(data));
    }
}
