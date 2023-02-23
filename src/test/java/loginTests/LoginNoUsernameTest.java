package loginTests;

import data.CommonStrings;
import data.ErrorMessages;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.Comment;
import utils.DriverUtils;

public class LoginNoUsernameTest {
    WebDriver driver;
    Comment comment = new Comment();

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void failedLoginNoUsernameTest() {
        LoginPage loginPage = new LoginPage(driver);
        comment.printStep("open login page");
        loginPage.openLoginPage();

        loginPage.typeToPassword(CommonStrings.PASSWORD);
        comment.printStep("type password");
        Assert.assertEquals(ErrorMessages.NO_CREDS_ERROR, loginPage.clickLoginButtonFail().getErrorMessage());
        comment.printStep("click login button");
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }
}
