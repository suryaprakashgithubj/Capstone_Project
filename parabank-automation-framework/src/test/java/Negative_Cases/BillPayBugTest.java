package Negative_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.BillPayPage;

public class BillPayBugTest extends BaseTest {

    @Test(priority = 1)
    public void zeroAmountBillPayBugTest() {

        login();

        BillPayPage billPayPage =
                new BillPayPage(driver);

        billPayPage.clickBillPayLink();

        billPayPage.enterPayeeName("surya");
        billPayPage.enterAddress("Coimbatore");
        billPayPage.enterCity("Coimbatore");
        billPayPage.enterState("Tamil Nadu");
        billPayPage.enterZipCode("641001");
        billPayPage.enterPhoneNumber("9876543210");
        billPayPage.enterAccountNumber("12345");
        billPayPage.enterVerifyAccount("12345");
        billPayPage.enterAmount("0");

        billPayPage.selectFromAccount();

        billPayPage.clickSendPaymentButton();

        Assert.assertFalse(
                driver.getPageSource()
                        .contains("Bill Payment Complete"),
                "Bug Found: Zero amount bill payment is allowed");
    }

    @Test(priority = 2)
    public void negativeAmountBillPayBugTest() {

        login();

        BillPayPage billPayPage =
                new BillPayPage(driver);

        billPayPage.clickBillPayLink();

        billPayPage.enterPayeeName("surya");
        billPayPage.enterAddress("Coimbatore");
        billPayPage.enterCity("Coimbatore");
        billPayPage.enterState("Tamil Nadu");
        billPayPage.enterZipCode("641001");
        billPayPage.enterPhoneNumber("9876543210");
        billPayPage.enterAccountNumber("12345");
        billPayPage.enterVerifyAccount("12345");
        billPayPage.enterAmount("-100");

        billPayPage.selectFromAccount();

        billPayPage.clickSendPaymentButton();

        Assert.assertFalse(
                driver.getPageSource()
                        .contains("Bill Payment Complete"),
                "Bug Found: Negative amount bill payment is allowed");
    }
}