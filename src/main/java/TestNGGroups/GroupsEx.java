package TestNGGroups;//import java.util.*;

import org.testng.annotations.Test;

public class GroupsEx {


    @Test(dependsOnMethods = "m2")
    public void m1()
    {
        System.out.println("M1 " + Thread.currentThread().getId());
    }
    @Test(dependsOnMethods = "m3")
    public void m2()
    {
        System.out.println("M2 " + Thread.currentThread().getId());
    }
    @Test(dependsOnMethods = "m4")
    public void m3()
    {
        System.out.println("M3 " + Thread.currentThread().getId());
    }
    @Test
    public void m4()
    {
        System.out.println("M4 " + Thread.currentThread().getId());
    }
}
