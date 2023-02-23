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

public class LoginWrongPasswordTest {
    WebDriver driver;
    Comment comment = new Comment();

    @Before
    public void beforeTest() {
        driver = DriverUtils.initDriver(driver);
        DriverUtils.configDriver(driver);
    }

    @Test
    public void loginWrongPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        comment.printStep("open login page");
        loginPage.openLoginPage();

        loginPage.typeToUsername(CommonStrings.STANDARD_USER);
        comment.printStep("type username");
        loginPage.typeToPassword(CommonStrings.PASSWORD + "123");
        comment.printStep("type password");
        Assert.assertEquals(ErrorMessages.WRONG_PASSWORD_ERROR, loginPage.clickLoginButtonFail().getErrorMessage());
        comment.printStep("click login button");
    }

    @After
    public void afterTest() {
        DriverUtils.closeDriver(driver);
    }
}
