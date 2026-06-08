package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.BillPayPage;


public class BillPayTest extends BaseTest {

    @Test(priority = 1)
    public void billPayTest() {

        

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
        billPayPage.enterAmount("500");

        billPayPage.selectFromAccount();

        billPayPage.clickSendPaymentButton();

        Assert.assertTrue(
                billPayPage.isBillPaymentSuccessful(),
                "Bill Payment Failed");
    }

    
}