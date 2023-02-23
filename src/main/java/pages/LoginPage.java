package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseActions;

public class LoginPage extends BaseActions {
    private final String URL = "https://www.saucedemo.com/";
    private final By loginButton = By.xpath("//input[@id='login-button']");
    private final By usernameInput = By.xpath("//input[@id='user-name']");
    private final By passwordInput = By.xpath("//input[@id='password']");
    private final By errorMessageBox = By.xpath("//h3[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openLoginPage() {
        openUrl(URL);
        return this;
    }

    public boolean verifyLoginPage() {
        return getCurrentUrl().equals(URL);
    }

    public ProductsPage clickLoginButtonSuccess() {
        clickWebElement(loginButton);
        return new ProductsPage(driver);
    }

    public LoginPage clickLoginButtonFail() {
        clickWebElement(loginButton);
        return this;
    }

    public void typeToUsername(String text) {
        clearAndTypeToWebElement(usernameInput, text);
    }

    public void typeToPassword(String text) {
        clearAndTypeToWebElement(passwordInput, text);
    }

    public String getErrorMessage() {
        return getTextFromWebElement(errorMessageBox);
    }

}
