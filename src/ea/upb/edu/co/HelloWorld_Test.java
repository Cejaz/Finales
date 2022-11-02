package ea.upb.edu.co;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;


public class HelloWorld_Test {

    @Test
    public void test1() {
        HelloWorld.main(null);
        Assert.assertTrue(true);
    }

    @Test
    public void test2() {
        Assert.assertEquals(HelloWorld.giveMeHello(), "Hello World");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite of tests");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite of tests");
    }

}
