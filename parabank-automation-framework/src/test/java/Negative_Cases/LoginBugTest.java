package Negative_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;

public class LoginBugTest extends BaseTest {

    @Test(priority = 1)
    public void invalidLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.enterUsername("invalidUser");

        loginPage.enterPassword("invalidPass");

        loginPage.clickLoginButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("The username and password could not be verified."),
                "Invalid login validation failed");
    }

    @Test(priority = 2)
    public void emptyLoginTest() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.enterUsername("");

        loginPage.enterPassword("");

        loginPage.clickLoginButton();

        String pageText =
                driver.findElement(org.openqa.selenium.By.tagName("body"))
                      .getText();

        Assert.assertTrue(
                pageText.contains("Please enter a username and password."),
                "Empty login validation failed");
    }
}