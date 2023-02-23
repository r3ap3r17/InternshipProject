package loginTests;

import data.ErrorMessages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Comment;
import utils.DriverUtils;

public class LoginNoCredsTest {
    WebDriver driver;
    Comment comment = new Comment();

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void failedLoginNoCredsTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        comment.printStep("open login page");

        Assert.assertEquals(ErrorMessages.NO_CREDS_ERROR, loginPage.clickLoginButtonFail().getErrorMessage());
        comment.printStep("click login button");
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }
}
