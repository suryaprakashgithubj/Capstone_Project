package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountOverviewPage {

    WebDriver driver;

    public AccountOverviewPage(WebDriver driver) {

        this.driver = driver;
    }
    By accountsOverviewLink =
            By.linkText("Accounts Overview");

    By accountNumberLink =
            By.xpath(
                    "//a[contains(@href,'activity.htm?id=')]");

    By activityPeriodDropdown =
            By.id("month");

    By transactionTypeDropdown =
            By.id("transactionType");
    By goButton =
            By.xpath("//input[@value='Go']");
    public void clickAccountsOverviewLink() {

        driver.findElement(
                accountsOverviewLink)
                .click();
    }
    public boolean isAccountDisplayed() {

        return driver.findElement(
                accountNumberLink)
                .isDisplayed();
    }
    public void clickAccountNumber() {

        driver.findElement(
                accountNumberLink)
                .click();
    }
    public void selectActivityPeriod(
            String month) {

        Select select =
                new Select(
                        driver.findElement(
                                activityPeriodDropdown));

        select.selectByVisibleText(
                month);
    }
    public void selectTransactionType(
            String type) {

        Select select =
                new Select(
                        driver.findElement(
                                transactionTypeDropdown));

        select.selectByVisibleText(
                type);
    }
    public void clickGoButton() {

        driver.findElement(
                goButton)
                .click();
    }
}