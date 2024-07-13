package Pages;

import Helpers.TestHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Resources.Constants;
import org.testng.Assert;

import static Tests.SubscriptionPackagesBH.ClassicPackageBH.ClassicPackagesCurrencyBH.test;

// Page Object class representing the Subscribe Page with methods to interact with packages
public class SubscribePage {
    private final TestHelper testHelper;

    // Locators for package elements and buttons
    private final By litePackageNameEN;
    private final By litePackagePriceEN;
    private final By litePackageCurrencyEN;
    private final By litePackageNameAR;
    private final By litePackagePriceAR;
    private final By litePackageCurrencyAR;
    private final By classicPackageNameEN;
    private final By classicPackagePriceEN;
    private final By classicPackageCurrencyEN;
    private final By classicPackageNameAR;
    private final By classicPackagePriceAR;
    private final By classicPackageCurrencyAR;
    private final By premiumPackageNameEN;
    private final By premiumPackagePriceEN;
    private final By premiumPackageCurrencyEN;
    private final By premiumPackageNameAR;
    private final By premiumPackagePriceAR;
    private final By premiumPackageCurrencyAR;
    private final By languageButton;
    private final By countriesButton;
    private final By BAHRAIN;
    private final By KUWAIT;

    // Constructor
    public SubscribePage(WebDriver driver) {
        testHelper = new TestHelper(driver);
        litePackageNameEN = By.id(Constants.SubscribePageFields.LitePackageFieldsEN.LITE_PACKAGE_NAME_FIELD_EN);
        litePackagePriceEN = By.xpath(Constants.SubscribePageFields.LitePackageFieldsEN.LITE_PACKAGE_PRICE_FIELD_EN);
        litePackageCurrencyEN = By.xpath(Constants.SubscribePageFields.LitePackageFieldsEN.LITE_PACKAGE_CURRENCY_FIELD_EN);
        litePackageNameAR = By.id(Constants.SubscribePageFields.LitePackageFieldsAR.LITE_PACKAGE_NAME_FIELD_AR);
        litePackagePriceAR = By.xpath(Constants.SubscribePageFields.LitePackageFieldsAR.LITE_PACKAGE_PRICE_FIELD_AR);
        litePackageCurrencyAR = By.xpath(Constants.SubscribePageFields.LitePackageFieldsAR.LITE_PACKAGE_CURRENCY_FIELD_AR);
        classicPackageNameEN = By.id(Constants.SubscribePageFields.ClassicPackageFieldsEN.CLASSIC_PACKAGE_NAME_FIELD_EN);
        classicPackagePriceEN = By.xpath(Constants.SubscribePageFields.ClassicPackageFieldsEN.CLASSIC_PACKAGE_PRICE_FIELD_EN);
        classicPackageCurrencyEN = By.xpath(Constants.SubscribePageFields.ClassicPackageFieldsEN.CLASSIC_PACKAGE_CURRENCY_FIELD_EN);
        classicPackageNameAR = By.id(Constants.SubscribePageFields.ClassicPackageFieldsAR.CLASSIC_PACKAGE_NAME_FIELD_AR);
        classicPackagePriceAR = By.xpath(Constants.SubscribePageFields.ClassicPackageFieldsAR.CLASSIC_PACKAGE_PRICE_FIELD_AR);
        classicPackageCurrencyAR = By.xpath(Constants.SubscribePageFields.ClassicPackageFieldsAR.CLASSIC_PACKAGE_CURRENCY_FIELD_AR);
        premiumPackageNameEN = By.id(Constants.SubscribePageFields.PremiumPackageFieldsEN.PREMIUM_PACKAGE_NAME_FIELD_EN);
        premiumPackagePriceEN = By.xpath(Constants.SubscribePageFields.PremiumPackageFieldsEN.PREMIUM_PACKAGE_PRICE_FIELD_EN);
        premiumPackageCurrencyEN = By.xpath(Constants.SubscribePageFields.PremiumPackageFieldsEN.PREMIUM_PACKAGE_CURRENCY_FIELD_EN);
        premiumPackageNameAR = By.id(Constants.SubscribePageFields.PremiumPackageFieldsAR.PREMIUM_PACKAGE_NAME_FIELD_AR);
        premiumPackagePriceAR = By.xpath(Constants.SubscribePageFields.PremiumPackageFieldsAR.PREMIUM_PACKAGE_PRICE_FIELD_AR);
        premiumPackageCurrencyAR = By.xpath(Constants.SubscribePageFields.PremiumPackageFieldsAR.PREMIUM_PACKAGE_CURRENCY_FIELD_AR);
        countriesButton =  By.xpath(Constants.Countries.COUNTRIES_BUTTON);
        languageButton =  By.xpath(Constants.LANGUAGE_BUTTON);
        BAHRAIN =  By.xpath(Constants.Countries.BAHRAIN);
        KUWAIT =  By.xpath(Constants.Countries.KUWAIT);
    }

    // Clicks the language button to change the language to Arabic.
    public void changeToArabic(){
        testHelper.clickButton(languageButton);
    }

    // Clicks on countries button and then on BAHRAIN to change the country.
    public void changeCountryToBahrain(){
        testHelper.clickButton(countriesButton);
        testHelper.clickButton(BAHRAIN);
    }

    // Clicks on countries button and then on KUWAIT to change the country.
    public void changeCountryToKuwait(){
        testHelper.clickButton(countriesButton);
        testHelper.clickButton(KUWAIT);
    }

    // Lite Package Methods:

    // Compares the actual Lite package name in English with the expected name.
    public void checkLitePackageNameEN(String actual){
        String expected = testHelper.getText(litePackageNameEN);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Lite package price in English with the expected price.
    public void checkLitePackagePriceEN(String actual){
        String expected = testHelper.getText(litePackagePriceEN);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Lite package currency in English with the expected currency.
    public void checkLiteCurrencyPriceEN(String actual){
        String currencyText = testHelper.getText(litePackageCurrencyEN).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }

    // Compares the actual Lite package name in Arabic with the expected name.
    public void checkLitePackageNameAR(String actual){
        String expected = testHelper.getText(litePackageNameAR);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Lite package price in Arabic with the expected price.
    public void checkLitePackagePriceAR(String actual){
        String expected = testHelper.getText(litePackagePriceAR);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Lite package currency in Arabic with the expected currency.
    public void checkLiteCurrencyPriceAR(String actual){
        String currencyText = testHelper.getText(litePackageCurrencyAR).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }

    // Classic Package Methods:

    // Compares the actual Classic package name in English with the expected name.
    public void checkClassicPackageNameEN(String actual){
        String expected = testHelper.getText(classicPackageNameEN);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Classic package price in English with the expected price.
    public void checkClassicPackagePriceEN(String actual){
        String expected = testHelper.getText(classicPackagePriceEN);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Classic package currency in English with the expected currency.
    public void checkClassicCurrencyPriceEN(String actual){
        String currencyText = testHelper.getText(classicPackageCurrencyEN).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }

    // Compares the actual Classic package name in Arabic with the expected name.
    public void checkClassicPackageNameAR(String actual){
        String expected = testHelper.getText(classicPackageNameAR);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Classic package price in Arabic with the expected price.
    public void checkClassicPackagePriceAR(String actual){
        String expected = testHelper.getText(classicPackagePriceAR);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Classic package currency in Arabic with the expected currency.
    public void checkClassicCurrencyPriceAR(String actual){
        String currencyText = testHelper.getText(classicPackageCurrencyAR).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }

    // Premium Package Methods:

    // Compares the actual Premium package name in English with the expected name.
    public void checkPremiumPackageNameEN(String actual){
        String expected = testHelper.getText(premiumPackageNameEN);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Premium package price in English with the expected price.
    public void checkPremiumPackagePriceEN(String actual){
        String expected = testHelper.getText(premiumPackagePriceEN);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Premium package currency in English with the expected currency.
    public void checkPremiumCurrencyPriceEN(String actual){
        String currencyText = testHelper.getText(premiumPackageCurrencyEN).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }

    // Compares the actual Premium package name in Arabic with the expected name.
    public void checkPremiumPackageNameAR(String actual){
        String expected = testHelper.getText(premiumPackageNameAR);
        testHelper.compareText(actual, expected);
    }

    // Compares the actual Premium package price in Arabic with the expected price.
    public void checkPremiumPackagePriceAR(String actual){
        String expected = testHelper.getText(premiumPackagePriceAR);
        testHelper.compareText(actual, expected);
    }

    // Extracts and compares the actual Premium package currency in Arabic with the expected currency.
    public void checkPremiumCurrencyPriceAR(String actual){
        String currencyText = testHelper.getText(premiumPackageCurrencyAR).trim();
        // Extract the currency part
        String currency = testHelper.extractCurrency(currencyText);
        Assert.assertEquals(actual, currency);
    }
}