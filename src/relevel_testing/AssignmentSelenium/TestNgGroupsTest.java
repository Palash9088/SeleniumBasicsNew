import org.testng.annotations.Test;

public class TestNgGroupsTest {

    @Test(groups = {"DemoGoogle"})
    public void m1() {
        System.out.println("Browser Login Google.com");
        System.out.println("Check User Details");
        System.out.println("Google Logout");
    }

    @Test(groups = {"DemoFacebook"})
    public void m2() {
        System.out.println( "Browser Login facebook.com");
        System.out.println("Check User Details");
        System.out.println("Facebook Logout");
    }
}
