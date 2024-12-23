package tests;

import pageObject.FormPage;
import pageObject.BasePage;
import factory.WebDriverFactory;
import browser.BrowserType;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;


//import org.testng.annotations.*;
import utils.LoggerSetup;
import java.util.logging.Logger;
import org.apache.logging.log4j.LogManager;
import utils.LoggerSetup;
//import org.apache.log4j.Logger;

import java.util.Optional;

public class FormTest {

    private WebDriver driver;
    private FormPage formPage;
    //private static final Logger logger = LoggerSetup.getLogger(FormTest.class);
    private static final Logger logger = Logger.getLogger(FormTest.class.getName());

    public static void main(String[] args) {
        logger.info("This is a log message.");
    }


    @BeforeAll
    static void initLogger() {
        logger.info("Starting test suite...");
    }

    @BeforeEach
    void setUp() {
        String browser = System.getProperty("browser", "firefox");
        String url = System.getProperty("url", "https://otus.home.kartushin.su/form.html");

        logger.info("Initializing WebDriver...");
        driver = WebDriverFactory.createDriver(BrowserType.fromString(browser));
        //driver = WebDriverFactory.create("firefox", null);
        formPage = new FormPage(driver);
        driver.manage().window().maximize();
        logger.info("Navigating to URL: " + url);
        formPage.openUrl(url);
    }
    /*public void setUp() {
        // Пример создания ChromeDriver с настройками
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // Пример настройки Chrome
        driver = WebDriverFactory.createDriver(BrowserType.CHROME, chromeOptions); // Используем метод фабрики с ChromeOptions

        formPage = new FormPage(driver);
        driver.get("https://otus.home.kartushin.su/form.html");
    }*/


    @Test
    void testFormFillAndSubmit() {
        String username = Optional.ofNullable(System.getProperty("username")).orElse("JohnDoe");
        String email = Optional.ofNullable(System.getProperty("email")).orElse("john.doe@example.com");
        String password = Optional.ofNullable(System.getProperty("password")).orElse("123456");
        String birthdate = Optional.ofNullable(System.getProperty("birthdate")).orElse("1990-01-01");
        String languageLevel = Optional.ofNullable(System.getProperty("languageLevel")).orElse("Intermediate");

        logger.info("Filling the form...");
        formPage.fillForm(username, email, password, password, birthdate, languageLevel);
        logger.info("Submitting the form...");
        formPage.submitForm();
        // Add assertions if required to verify the result
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            logger.info("Closing WebDriver...");
            driver.quit();
        }
    }

    @AfterAll
    static void completeLogger() {
        logger.info("Test suite execution completed.");
    }
}