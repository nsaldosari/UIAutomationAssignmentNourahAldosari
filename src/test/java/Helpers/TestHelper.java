package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;

// Helper class for common WebDriver interactions and assertions.
public class TestHelper {
    private WebDriver driver;

    // Constructor
    public TestHelper(WebDriver driver) {
        this.driver = driver;
    }

    // Compares the actual and expected text using TestNG assertion.
    public void compareText(String actual, String expected) {
        // actual: The actual text to compare.
        // expected: The expected text for comparison.
        Assert.assertEquals(actual, expected);
    }

    // Retrieves the text of an element identified by the given locator.
    public String getText(By locator){
        //return The text of the element.
        try {
            return driver.findElement(locator).getText();
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found: " + locator, e);
        }
    }

    // Clicks the button element identified by the given locator.
    public void clickButton(By locator){
        try {
            driver.findElement(locator).click();
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("Element not found: " + locator, e);
        }
    }

    //Extracts the currency part from the given currency text.
    public String extractCurrency(String currencyText) {
        // Find the position of the slash
        int slashIndex = currencyText.indexOf('/');

        // Extract the currency part before the slash
        if (slashIndex != -1) {
            return currencyText.substring(0, slashIndex).trim();
        } else {
            // If there's no slash, return the entire string trimmed
            return currencyText.trim();
        }
    }
}
