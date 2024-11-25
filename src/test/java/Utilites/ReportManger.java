package Utilites;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportManger {
    private static ExtentReports extent;
    private static ExtentTest test;
    public static void initReport() {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Tester", "Mohra");
        extent.setSystemInfo("Environment", "QA");
    }

    // Get the ExtentTest instance
    public static ExtentTest createTest(String testName, String description) {
        test = extent.createTest(testName, description);
        return test;
    }

    // Flush the report to save it
    public static void flushReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

