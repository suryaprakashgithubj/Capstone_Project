package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.BillPayPage;
import Utils.ExcelUtils;

public class BillPayTest extends BaseTest {

    @Test(priority = 1)
    public void billPayTest() {

        login();

        String payeeName =
                ExcelUtils.getCellData("BillPay", 1, 0);

        String address =
                ExcelUtils.getCellData("BillPay", 1, 1);

        String city =
                ExcelUtils.getCellData("BillPay", 1, 2);

        String state =
                ExcelUtils.getCellData("BillPay", 1, 3);

        String zipCode =
                ExcelUtils.getCellData("BillPay", 1, 4);

        String phoneNumber =
                ExcelUtils.getCellData("BillPay", 1, 5);

        String accountNumber =
                ExcelUtils.getCellData("BillPay", 1, 6);

        String amount =
                ExcelUtils.getCellData("BillPay", 1, 7);

        BillPayPage billPayPage =
                new BillPayPage(driver);

        billPayPage.clickBillPayLink();

        billPayPage.enterPayeeName(payeeName);
        billPayPage.enterAddress(address);
        billPayPage.enterCity(city);
        billPayPage.enterState(state);
        billPayPage.enterZipCode(zipCode);
        billPayPage.enterPhoneNumber(phoneNumber);

        billPayPage.enterAccountNumber(accountNumber);
        billPayPage.enterVerifyAccount(accountNumber);

        billPayPage.enterAmount(amount);

        billPayPage.selectFromAccount();

        billPayPage.clickSendPaymentButton();

        Assert.assertTrue(
                billPayPage.isBillPaymentSuccessful(),
                "Bill Payment Failed");
    }
}