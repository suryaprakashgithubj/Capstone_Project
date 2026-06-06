package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.OpenAccountPage;

public class OpenAccountTest extends BaseTest {

    @Test
    public void openAccountTest() {
    	
    	login();

        OpenAccountPage openAccountPage =
                new OpenAccountPage(driver);

        openAccountPage.clickOpenNewAccountLink();

        openAccountPage.selectAccountType("SAVINGS");

        openAccountPage.selectExistingAccount();

        openAccountPage.clickOpenNewAccountButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Account Opened!"),
                "Account Creation Failed");
    }
}