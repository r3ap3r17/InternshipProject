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

public class LoginNoPasswordTest {
    WebDriver driver;
    Comment comment = new Comment();

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void failedLoginNoPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        comment.printStep("open login page");
        loginPage.openLoginPage();

        loginPage.typeToUsername(CommonStrings.STANDARD_USER);
        comment.printStep("type username");
        Assert.assertEquals(ErrorMessages.NO_PASSWORD_ERROR, loginPage.clickLoginButtonFail().getErrorMessage());
        comment.printStep("click login button");
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }
}
