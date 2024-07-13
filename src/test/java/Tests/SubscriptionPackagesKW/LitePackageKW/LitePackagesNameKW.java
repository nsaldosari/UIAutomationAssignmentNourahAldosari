// Import necessary packages and libraries
package Tests.SubscriptionPackagesKW.LitePackageKW;

import Pages.SubscribePage;
import Resources.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// Test class for verifying Lite package name in Kuwait for both English and Arabic
public class LitePackagesNameKW {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String litePackageNameEN;
    private String litePackageNameAR;
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
        litePackageNameEN = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_EN;
        litePackageNameAR = Constants.SubscribePageFields.PackagesName.LITE_PACKAGE_ACTUAL_NAME_AR;// Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Lite package name in English for Kuwait
    @Test
    public void testLitePackagesNameEN() {
        test = extent.createTest("Verify Lite Package name in English for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Lite package name in English
        subscribePage.checkLitePackageNameEN(litePackageNameEN);
    }

    // Test to verify Lite package name in Arabic for Kuwait
    @Test
    public void testLitePackagesNameAR() {
        test = extent.createTest("Verify Lite Package name in Arabic for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Lite package name in Arabic
        subscribePage.checkLitePackageNameAR(litePackageNameAR);
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