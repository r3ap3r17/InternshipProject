import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.BaseActions;
import utils.DriverUtils;

public class ExampleTest {
    WebDriver driver;

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void exampleTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        loginPage.clickLoginButton();
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }


}
