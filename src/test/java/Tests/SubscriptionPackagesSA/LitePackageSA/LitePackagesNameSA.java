// Import necessary packages and libraries
package Tests.SubscriptionPackagesSA.LitePackageSA;

import Resources.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.SubscribePage;

// Test class for verifying Lite package name in KSA for both English and Arabic
public class LitePackagesNameSA {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String actualLitePackageNameEN;
    private String actualLitePackageNameAR;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    // Method to setup WebDriver and initialize page objects
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects
        subscribePage = new SubscribePage(driver);
        // Set expected name for Lite package in English and Arabic
        actualLitePackageNameEN = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_EN;
        actualLitePackageNameAR = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Lite package name in English for KSA
    @Test
    public void testLitePackagesNameEN() {
        test = extent.createTest("Verify Lite Package name in English for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Verify Lite package name in English
        subscribePage.checkLitePackageNameEN(actualLitePackageNameEN);
    }

    // Test to verify Lite package name in Arabic for KSA
    @Test
    public void testLitePackagesNameAR() {
        test = extent.createTest("Verify Lite Package name in Arabic for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Verify Lite package name in Arabic
        subscribePage.checkLitePackageNameAR(actualLitePackageNameAR);
    }

    // Method to close the browser after all tests are executed
    @AfterClass
    public void cleanUp() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
        // Flush ExtentReports to write test information to the HTML report
        extent.flush();
    }
}