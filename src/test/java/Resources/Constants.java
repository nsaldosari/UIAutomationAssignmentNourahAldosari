package Resources;

// Constants class containing URLs, locators, and package details
public class Constants {
    // Base URL
    public static final String BASE_URL = "https://subscribe.stctv.com/sa-en";

    // XPath for the language button
    public static final String LANGUAGE_BUTTON = "//*[@id=\"translation-btn\"]";

    // Nested class for country
    public static class Countries{
        public static final String COUNTRIES_BUTTON = "//*[@id=\"header\"]/div/div[2]/div[1]";
        public static final String KSA = "//*[@id=\"sa\"]";
        public static final String BAHRAIN = "//*[@id=\"bh\"]";
        public static final String KUWAIT = "//*[@id=\"kw\"]";
    }

    // Nested class for subscribe page field constants
    public static class SubscribePageFields {
        // Nested class for currency constants
        public static class Currency{
            public static final String ACTUAL_CURRENCY_SA_EN = "SAR";
            public static final String ACTUAL_CURRENCY_SA_AR = "ريال سعودي";
            public static final String ACTUAL_CURRENCY_BH_EN = "BHD";
            public static final String ACTUAL_CURRENCY_BH_AR = "دينار بحريني";
            public static final String ACTUAL_CURRENCY_KW_EN = "KWD";
            public static final String ACTUAL_CURRENCY_KW_AR = "دينار كويتي";
        }

        // Nested class for package name constants
        public static class PackagesName{
            public static final String LITE_PACKAGE_ACTUAL_NAME_EN = "LITE";
            public static final String LITE_PACKAGE_ACTUAL_NAME_AR = "لايت";
            public static final String CLASSIC_PACKAGE_ACTUAL_NAME_EN = "CLASSIC";
            public static final String CLASSIC_PACKAGE_ACTUAL_NAME_AR = "الأساسية";
            public static final String PREMIUM_PACKAGE_ACTUAL_NAME_EN = "PREMIUM";
            public static final String PREMIUM_PACKAGE_ACTUAL_NAME_AR = "بريميوم";
        }

        // Nested class for package price constants
        public static class PackagesPrice {
            public static final String LITE_PACKAGE_ACTUAL_PRICE_SA = "15";
            public static final String CLASSIC_PACKAGE_ACTUAL_PRICE_SA = "25";
            public static final String PREMIUM_PACKAGE_ACTUAL_PRICE_SA = "60";
            public static final String LITE_PACKAGE_ACTUAL_PRICE_BH = "2";
            public static final String CLASSIC_PACKAGE_ACTUAL_PRICE_BH = "3";
            public static final String PREMIUM_PACKAGE_ACTUAL_PRICE_BH = "6";
            public static final String LITE_PACKAGE_ACTUAL_PRICE_KW = "1.2";
            public static final String CLASSIC_PACKAGE_ACTUAL_PRICE_KW = "2.5";
            public static final String PREMIUM_PACKAGE_ACTUAL_PRICE_KW = "4.8";
        }

        // Nested class for Lite package field locators in English
        public static class LitePackageFieldsEN {
            public static final String LITE_PACKAGE_NAME_FIELD_EN = "name-lite";
            public static final String LITE_PACKAGE_PRICE_FIELD_EN = "//*[@id=\"currency-lite\"]/b";
            public static final String LITE_PACKAGE_CURRENCY_FIELD_EN = "//*[@id=\"currency-lite\"]/i";
        }

        // Nested class for Lite package field locators in Arabic
        public static class LitePackageFieldsAR {
            public static final String LITE_PACKAGE_NAME_FIELD_AR = "name-لايت";
            public static final String LITE_PACKAGE_PRICE_FIELD_AR = "/html/body/div[1]/div[3]/div/div/div/div[1]/div[3]/div[2]/div[1]/div/b";
            public static final String LITE_PACKAGE_CURRENCY_FIELD_AR = "//*[@id=\"currency-لايت\"]/i";
        }

        // Nested class for Classic package field locators in English
        public static class ClassicPackageFieldsEN {
            public static final String CLASSIC_PACKAGE_NAME_FIELD_EN = "name-classic";
            public static final String CLASSIC_PACKAGE_PRICE_FIELD_EN = "//*[@id=\"currency-classic\"]/b";
            public static final String CLASSIC_PACKAGE_CURRENCY_FIELD_EN = "//*[@id=\"currency-classic\"]/i";
        }

        // Nested class for Classic package field locators in Arabic
        public static class ClassicPackageFieldsAR {
            public static final String CLASSIC_PACKAGE_NAME_FIELD_AR = "name-الأساسية";
            public static final String CLASSIC_PACKAGE_PRICE_FIELD_AR = "//*[@id=\"currency-الأساسية\"]/b";
            public static final String CLASSIC_PACKAGE_CURRENCY_FIELD_AR = "//*[@id=\"currency-الأساسية\"]/i";
        }

        // Nested class for Premium package field locators in English
        public static class PremiumPackageFieldsEN {
            public static final String PREMIUM_PACKAGE_NAME_FIELD_EN = "name-premium";
            public static final String PREMIUM_PACKAGE_PRICE_FIELD_EN = "//*[@id=\"currency-premium\"]/b";
            public static final String PREMIUM_PACKAGE_CURRENCY_FIELD_EN = "//*[@id=\"currency-premium\"]/i";
        }

        // Nested class for Premium package field locators in Arabic
        public static class PremiumPackageFieldsAR {
            public static final String PREMIUM_PACKAGE_NAME_FIELD_AR = "name-بريميوم";
            public static final String PREMIUM_PACKAGE_PRICE_FIELD_AR = "//*[@id=\"currency-بريميوم\"]/b";
            public static final String PREMIUM_PACKAGE_CURRENCY_FIELD_AR = "//*[@id=\"currency-بريميوم\"]/i";
        }
    }
}