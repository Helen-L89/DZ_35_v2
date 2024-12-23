package factory;

import browser.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriverFactory {

    private static final Logger logger = Logger.getLogger(WebDriverFactory.class.getName());

    public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case CHROME:
                // Используем WebDriverManager для установки ChromeDriver
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                // Используем WebDriverManager для установки GeckoDriver (для Firefox)
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                logger.log(Level.SEVERE, "Unsupported browser: " + browserType);
                break;
        }

        return driver;
    }
    /*public static WebDriver createDriver(BrowserType browserType) {
        WebDriver driver = null;

        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                logger.log(Level.SEVERE, "Unsupported browser: " + browserType);
                break;
        }

        return driver;
    }*/
    /*public static WebDriver createDriver(BrowserType browserType, Object options) {
        WebDriver driver = null;

        // Логика для создания ChromeDriver
        if (browserType == BrowserType.CHROME) {
            if (options != null && options instanceof ChromeOptions) {
                WebDriverManager.chromedriver().setup();  // Настройка драйвера через WebDriverManager
                driver = new ChromeDriver((ChromeOptions) options);  // Используем переданные настройки
            } else {
                WebDriverManager.chromedriver().setup();  // Настройка драйвера
                driver = new ChromeDriver();  // Без дополнительных настроек
            }
        }
        // Логика для создания FirefoxDriver
        else if (browserType == BrowserType.FIREFOX) {
            if (options != null && options instanceof FirefoxOptions) {
                WebDriverManager.firefoxdriver().setup();  // Настройка драйвера через WebDriverManager
                driver = new FirefoxDriver((FirefoxOptions) options);  // Используем переданные настройки
            } else {
                WebDriverManager.firefoxdriver().setup();  // Настройка драйвера
                driver = new FirefoxDriver();  // Без дополнительных настроек
            }
        }
        return driver;
    }*/ //-- как вариант


}
