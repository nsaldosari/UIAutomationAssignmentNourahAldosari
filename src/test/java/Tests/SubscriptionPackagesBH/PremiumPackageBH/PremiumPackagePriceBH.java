// Import necessary packages and libraries
package Tests.SubscriptionPackagesBH.PremiumPackageBH;

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

// Test class for verifying Premium package price in Bahrain for both English and Arabic
public class PremiumPackagePriceBH {
    private WebDriver driver;
    private SubscribePage subscribePage;
    private String actuaPremiumPackagePrice;
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
        // Set expected price for Premium package in English and Arabic
        actuaPremiumPackagePrice = Constants.SubscribePageFields.PackagesPrice.PREMIUM_PACKAGE_ACTUAL_PRICE_BH;
        // Initialize ExtentReports with HTML output configuration
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        extent.attachReporter(spark);
    }

    // Test to verify Premium package price in English for Bahrain
    @Test
    public void testPremiumPackagesPriceEN() {
        test = extent.createTest("Verify Premium Package price in English for Bahrain");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change country to Bahrain
        subscribePage.changeCountryToBahrain();
        // Verify Premium package price in English
        subscribePage.checkPremiumPackagePriceEN(actuaPremiumPackagePrice);
    }

    // Test to verify Premium package price in Arabic for Bahrain
    @Test
    public void testPremiumPackagesPriceAR() {
        test = extent.createTest("Verify Premium Package currency in Arabic for Bahrain");
        // Navigate to the base URL
        driver.get(Constants.BASE_URL);
        // Change Language to Arabic
        subscribePage.changeToArabic();
        // Change country to Bahrain
        subscribePage.changeCountryToBahrain();
        // Verify Premium package price in Arabic
        subscribePage.checkPremiumPackagePriceAR(actuaPremiumPackagePrice);
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