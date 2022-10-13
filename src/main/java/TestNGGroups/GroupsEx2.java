package TestNGGroups;//import java.util.*;

import org.testng.annotations.Test;

public class GroupsEx2  {

    @Test(groups = "smoke")
    public void m5()
    {
        System.out.println("M5" + " "+ Thread.currentThread().getId());
    }
    @Test(groups = "smoke")
    public void m6()
    {
        System.out.println("M6" + Thread.currentThread().getId());
    }
    @Test(groups = "regression")
    public void m7()
    {
        System.out.println("M7" + Thread.currentThread().getId());
    }
    @Test(groups = "regression")
    public void m8()
    {
        System.out.println("M8" + Thread.currentThread().getId());
    }
}
