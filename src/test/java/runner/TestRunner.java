package runner;

import org.testng.TestNG;
import test.ApiTest;

public class TestRunner {
    public static void main(String[] args) {
        TestNG tng = new TestNG();
        tng.setTestClasses(new Class[] {ApiTest.class});
        tng.run();
    }
}
