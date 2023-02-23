package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverUtils {
    public static WebDriver initDriver(WebDriver driver) {
        switch (ReadProperties.readConfigBrowser().toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ReadProperties.readConfigChromePath());
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", ReadProperties.readConfigFirefoxPath());
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Please make sure to provide a valid browser name in 'Configurations.properties' file !");
        }
        return driver;
    }

    public static void configDriver(WebDriver driver) {
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
    public static void closeDriver(WebDriver driver) {
        driver.quit();
    }
}
