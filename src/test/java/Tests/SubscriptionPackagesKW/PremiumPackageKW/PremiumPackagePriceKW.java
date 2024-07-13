// Import necessary packages and libraries
package Tests.SubscriptionPackagesKW.PremiumPackageKW;

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

// Test class for verifying Premium package price in Kuwait for both English and Arabic
public class PremiumPackagePriceKW {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String actualPremiumPackagePrice;
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
        // Set expected currencies for Premium price in English and Arabic
        actualPremiumPackagePrice = Constants.SubscribePageFields.PackagesPrice.PREMIUM_PACKAGE_ACTUAL_PRICE_KW;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Premium package price in English for Kuwait
    @Test
    public void testPremiumPackagesPriceEN() {
        test = extent.createTest("Verify Premium Package price in English for Kuwait");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Premium package price in English
        subscribePage.checkPremiumPackagePriceEN(actualPremiumPackagePrice);
    }

    // Test to verify Premium package price in Arabic for Kuwait
    @Test
    public void testPremiumPackagesPriceAR() {
        test = extent.createTest("Verify Premium Package price in Arabic for Kuwait");
        // Navigate to the URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Change country to Kuwait
        subscribePage.changeCountryToKuwait();
        // Verify Premium package price in Arabic
        subscribePage.checkPremiumPackagePriceAR(actualPremiumPackagePrice);
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