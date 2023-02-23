package utils;

import data.Time;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public abstract class BaseActions {
    protected WebDriver driver;

    public BaseActions(WebDriver driver) {
        this.driver = driver;
    }
    public void openUrl(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Waits until element is visible | locator
    protected WebElement waitForWebElement(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time * 1000);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickWebElement(By locator) {
        WebElement element = waitForWebElement(locator, Time.TIMEOUT_MEDIUM);
        element.click();
    }

    private void typeToWebElement(By locator, String text) {
        WebElement element = waitForWebElement(locator, Time.TIMEOUT_MEDIUM);
        element.sendKeys(text);
    }

    private void clearFromWebElement(By locator) {
        WebElement element = waitForWebElement(locator, Time.TIMEOUT_MEDIUM);
        element.clear();
    }

    public void clearAndTypeToWebElement(By locator, String text) {
        clearFromWebElement(locator);
        typeToWebElement(locator, text);
    }

}
