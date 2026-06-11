package Tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import Base.BaseTest;
import Pages.AccountOverviewPage;
public class AccountOverviewTest
        extends BaseTest {
    @Test(priority = 1)
    public void accountOverviewTest() {

        login();

        AccountOverviewPage accountPage =
                new AccountOverviewPage(
                        driver);

        accountPage
                .clickAccountsOverviewLink();

        Assert.assertTrue(
                accountPage
                        .isAccountDisplayed(),
                "Account details not displayed");
    }

    @Test(priority = 2)
    public void accountActivityFilterTest() {

        login();

        AccountOverviewPage accountPage =
                new AccountOverviewPage(
                        driver);

        accountPage
                .clickAccountsOverviewLink();

        accountPage
                .clickAccountNumber();

        accountPage
                .selectActivityPeriod(
                        "All");

        accountPage
                .selectTransactionType(
                        "All");

        accountPage
                .clickGoButton();

        Assert.assertTrue(
                driver.getPageSource()
                        .contains(
                                "Account Activity"),
                "Account Activity page not displayed");
    }
}