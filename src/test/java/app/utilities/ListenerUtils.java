package app.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
public class ListenerUtils implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {
    @Override
    public void onStart(ITestContext context) {
//        like BeforeSuite annotation
        System.out.println("onStart : executes only ONCE BEFORE ALL test cases(@Test)"+context.getName());
    }
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish : executes only ONCE AFTER ALL test cases(@Test)" + context.getName());
    }
    @Override
    public void onTestStart(ITestResult result) {
//        like BeforeEach
        System.out.println("onTestStart : executes ONCE BEFORE EACH test cases(@Test)"+result.getName());
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess : executes ONLY AFTER EACH PASSING test cases(@Test)"+result.getName());
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped : executes ONLY AFTER EACH SKIPPED test cases(@Test)"+result.getName());
    }
    @Override
    public void onTestFailure(ITestResult result) {
//        System.out.println("onTestFailed : executes ONLY AFTER EACH FAILED test cases(@Test)"+result.getName());
//        We want ot take a screenshot after test failures
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //    @Override
//    public void onTestFailedWithTimeout(ITestResult result) {
//    }
//    @Override
//    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//    }
//    Rerun Failed Test Cases automatically one more time
//    IRetryAnalyzer Method Is Implemented
//    This method will be called automatically to RETRY THE FAILED TEST CASES
    private int retryCount = 0;
    private static final int maxRetryCount = 1;//RERUN COUNT
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }
    //    IIAnnotationTransformer method is added
//    This makes the failed test cases automatically rerun using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenerUtils.class);
    }

}