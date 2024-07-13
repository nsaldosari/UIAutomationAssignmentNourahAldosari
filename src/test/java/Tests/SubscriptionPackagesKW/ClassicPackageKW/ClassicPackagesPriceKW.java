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

// Test class for verifying Classic package price in Kuwait for both English and Arabic
public class ClassicPackagesPriceKW {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String classicPackagePrice;
    public static ExtentTest test;
    static ExtentReports extent = new ExtentReports();

    // Method to setup WebDriver and initialize page objects
    @BeforeClass
    public void setUp() {
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize Page Objects "SubscribePage"
        subscribePage = new SubscribePage(driver);
        // Set expected price for Classic package in English and Arabic
        classicPackagePrice = Constants.SubscribePageFields.PackagesPrice.CLASSIC_PACKAGE_ACTUAL_PRICE_KW;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Classic package price in English for Kuwait
    @Test
    public void testClassicPackagesPriceEN() {
        test = extent.createTest("Verify Classic Package price in English for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        /// Verify Classic package price in English
        subscribePage.checkClassicPackagePriceEN(classicPackagePrice);
    }

    // Test to verify Classic package price in Arabic for Kuwait
    @Test
    public void testClassicPackagesPriceAR() {
        test = extent.createTest("Verify Classic Package price in Arabic for Kuwait");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Classic package price in Arabic
        subscribePage.checkClassicPackagePriceAR(classicPackagePrice);
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