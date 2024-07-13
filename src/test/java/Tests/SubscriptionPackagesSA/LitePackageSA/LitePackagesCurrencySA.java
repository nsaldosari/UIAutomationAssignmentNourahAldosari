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

// Test class for verifying Lite package currency in KSA for both English and Arabic
public class LitePackagesCurrencySA {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String actualLitePackageCurrencyEN;
    private String actualLitePackageCurrencyAR;
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
        // Set expected currencies for Lite package in English and Arabic
        actualLitePackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_EN;
        actualLitePackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_SA_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Lite package currency in English for KSA
    @Test
    public void testLitePackagesCurrencyEN() {
        test = extent.createTest("Verify Lite Package currency in English for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Verify Lite package currency in English
        subscribePage.checkLiteCurrencyPriceEN(actualLitePackageCurrencyEN);
    }

    // Test to verify Lite package currency in Arabic for KSA
    @Test
    public void testLitePackagesCurrencyAR() {
        test = extent.createTest("Verify Lite Package currency in Arabic for KSA");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Verify Lite package currency in Arabic
        subscribePage.checkLiteCurrencyPriceAR(actualLitePackageCurrencyAR);
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