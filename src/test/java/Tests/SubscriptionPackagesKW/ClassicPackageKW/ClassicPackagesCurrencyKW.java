// Import necessary packages and libraries
package Tests.SubscriptionPackagesKW.ClassicPackageKW;

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

// Test class for verifying Classic package currency in Kuwait for both English and Arabic
public class ClassicPackagesCurrencyKW {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String classicPackageCurrencyEN;
    private String classicPackageCurrencyAR;
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
        // Set expected currencies for Classic package in English and Arabic
        classicPackageCurrencyEN = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_KW_EN;
        classicPackageCurrencyAR = Constants.SubscribePageFields.Currency.ACTUAL_CURRENCY_KW_AR;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Classic package currency in English for Kuwait
    @Test
    public void testClaccisPackagesCurrencyEN() {
        test = extent.createTest("Verify Classic Package currency in English for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Classic package currency in English
        subscribePage.checkClassicCurrencyPriceEN(classicPackageCurrencyEN);
    }

    // Test to verify Classic package currency in Arabic for Kuwait
    @Test
    public void testClaccisPackagesCurrencyAR() {
        test = extent.createTest("Verify Classic Package currency in Arabic for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Classic package currency in Arabic
        subscribePage.checkClassicCurrencyPriceAR(classicPackageCurrencyAR);
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