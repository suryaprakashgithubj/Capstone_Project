package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;


public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {

    	login();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Accounts Overview"),
                "Login Failed");
    }
}