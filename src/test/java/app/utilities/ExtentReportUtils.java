package app.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static app.utilities.MediaUtils.takeScreenshotOfTheEntirePageAsString;
public class ExtentReportUtils {
    protected static ExtentReports extentReports;
    protected static ExtentSparkReporter extentSparkReporter;
    protected static ExtentTest extentTest;
    /*
     Using static block will be called when ever I call ExtentReportUtils.somemethod....
     then the pre-requisites will be executed by the static block
    */
    static {
//        WHAT WILL BE REPORT NAME AND WHERE THE REPORT IS CREATED
//        PATH
        String now = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/Reports/"+now+"extent_reports.html";
//        Create the HTML template using extent spark reporter in the path
        extentSparkReporter = new ExtentSparkReporter(path);
//        Create extent report
        extentReports = new ExtentReports();
//        ***********ADDING CUSTOM SYSTEM INFORMATION ***********
        extentReports.setSystemInfo("Application Name","Apple M1 Unit");
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team Name","Eagles");
        extentReports.setSystemInfo("SQA","Seren");
        extentReports.setSystemInfo("Feature Number","FE1056");
//        ***********DOCUMENT INFORMATION************************
        extentSparkReporter.config().setReportName("My Regression Report");
        extentSparkReporter.config().setDocumentTitle("My Regression Extent Reports");
//        ***********DONE WITH CONFIGURATIONS********************
//        connecting extent reports and extent spark reporter
        extentReports.attachReporter(extentSparkReporter);
    }
    //
    /*
     **********CREATE EXTENT TEST THAT IS ALSO KNOWN AS LOGGER**
     * use this before any other report method to create test, otherwise you get exception
     */
    public static void createTestReport(String name,String description){
        extentTest=extentReports.createTest(name,description);
    }
    //    LOGGER METHODS
//    ExtentReportUtils.pass("message") -> Marks the log as pass , and the message shows up on the report
    public static void pass(String message){
        extentTest.log(Status.PASS,message);
    }
    //    ExtentReportUtils.info("message") -> Marks the log as info , and the message shows up on the report
    public static void info(String message){
        extentTest.log(Status.INFO,message);
    }
    //    ExtentReportUtils.fail("message") -> Marks the log as fail , and the message shows up on the report
    public static void fail(String message){
        extentTest.log(Status.FAIL,message);
    }
    //    This method will log AND captures screenshot AND attached them to the html report
    public static void passAndCaptureScreenshot(String message)  {
        try {
            extentTest
                    .log(Status.PASS,message)
                    .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void failAndCaptureScreenshot(String message)  {
        try {
            extentTest
                    .log(Status.FAIL,message)
                    .addScreenCaptureFromPath(takeScreenshotOfTheEntirePageAsString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    FLUSH MUST BE USED AT THE VERY END TO GENERATE THE REPORT
    ExtentReportUtils.flush
    */
    public static void flush(){
        extentReports.flush();
    }
}