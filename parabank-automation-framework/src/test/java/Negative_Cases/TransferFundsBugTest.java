package Negative_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.TransferFundsPage;

public class TransferFundsBugTest extends BaseTest {

    @Test(priority = 1)
    public void sameAccountTransferBugTest() {

        login();

        TransferFundsPage transferPage =
                new TransferFundsPage(driver);

        transferPage.clickTransferFundsLink();

        transferPage.enterAmount("500");

        transferPage.selectSameAccount();

        transferPage.clickTransferButton();

        Assert.assertFalse(
                driver.getPageSource()
                        .contains("Transfer Complete!"),
                "Bug Found: Same account transfer is allowed");
    }

    @Test(priority = 2)
    public void zeroAmountTransferBugTest() {

        login();

        TransferFundsPage transferPage =
                new TransferFundsPage(driver);

        transferPage.clickTransferFundsLink();

        transferPage.enterAmount("0");

        transferPage.selectSameAccount();

        transferPage.clickTransferButton();

        Assert.assertFalse(
                driver.getPageSource()
                        .contains("Transfer Complete!"),
                "Bug Found: Zero amount transfer is allowed");
    }
}