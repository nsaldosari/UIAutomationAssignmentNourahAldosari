// Import necessary packages and libraries
package Tests.SubscriptionPackagesSA.LitePackageSA;

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

// Test class for verifying Lite package price in KSA for both English and Arabic
public class LitePackagesPriceSA {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String actualLitePackagePrice;
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
        // Set expected price for Lite package in English and Arabic
        actualLitePackagePrice = Constants.SubscribePageFields.PackagesPrice.LITE_PACKAGE_ACTUAL_PRICE_SA;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Lite package price in English for KSA
    @Test
    public void testLitePackagesPriceEN() {
        test = extent.createTest("Verify Lite Package price in English for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Verify Lite package price in English
        subscribePage.checkLitePackagePriceEN(actualLitePackagePrice);
    }

    // Test to verify Lite package price in Arabic for KSA
    @Test
    public void testLitePackagesPriceAR() {
        test = extent.createTest("Verify Lite Package price in Arabic for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Verify Lite package price in Arabic
        subscribePage.checkLitePackagePriceAR(actualLitePackagePrice);
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