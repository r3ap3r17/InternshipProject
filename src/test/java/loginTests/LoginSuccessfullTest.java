package loginTests;

import data.CommonStrings;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;
import utils.Comment;
import utils.DriverUtils;

public class LoginSuccessfullTest {
    WebDriver driver;
    Comment comment = new Comment();

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void successfullLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        comment.printStep("open login page");
        loginPage.typeToUsername(CommonStrings.STANDARD_USER);
        comment.printStep("type username");
        loginPage.typeToPassword(CommonStrings.PASSWORD);
        comment.printStep("type password");
        ProductsPage productsPage = loginPage.clickLoginButtonSuccess();
        comment.printStep("click login button");

        Assert.assertTrue(productsPage.verifyProductsPage());
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }

}

