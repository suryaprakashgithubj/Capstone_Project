package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.TransferFundsPage;
public class TransferFundsTest extends BaseTest {

    @Test(priority = 1)
    public void transferFundsTest() {
    	login();

        TransferFundsPage transferPage =
                new TransferFundsPage(driver);

        transferPage.clickTransferFundsLink();

        transferPage.enterAmount("500");

        transferPage.selectFromAccount();

        transferPage.selectToAccount();

        transferPage.clickTransferButton();

        Assert.assertTrue(
                transferPage.isTransferSuccessful(),
                "Fund Transfer Failed");
    }

   
}