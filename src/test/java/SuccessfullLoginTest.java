import data.CommonStrings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.DriverUtils;

public class SuccessfullLoginTest {
    WebDriver driver;

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void successfullLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();

        loginPage.typeToUsername(CommonStrings.STANDARD_USER);
        loginPage.typeToPassword(CommonStrings.PASSWORD);
        ProductsPage productsPage = loginPage.clickLoginButtonSuccess();

        Assert.assertTrue(productsPage.verifyProductsPage());
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }

}

