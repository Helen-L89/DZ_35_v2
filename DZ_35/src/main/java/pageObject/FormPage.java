package pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//mport org.junit.jupiter.api.Test;


public class FormPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "confirm_password")
    private WebElement confirmPasswordInput;

    @FindBy(id = "birthdate")
    private WebElement birthdateInput;

    @FindBy(id = "language_level")
    private WebElement languageDropdown;

    @FindBy(css = "input[type='submit'][value='Зарегистрироваться']")
    private WebElement submitButton;

    public FormPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillForm(String username, String email, String password, String confirmPassword, String birthdate, String languageLevel) {
        usernameInput.sendKeys(username);
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(confirmPassword);
        birthdateInput.sendKeys(birthdate);
        languageDropdown.sendKeys(languageLevel);
    }

    public void submitForm() {
        submitButton.click();
    }
}