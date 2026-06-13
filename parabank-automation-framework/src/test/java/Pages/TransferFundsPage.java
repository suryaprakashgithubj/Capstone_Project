package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.WaitUtils;

public class TransferFundsPage {

    WebDriver driver;
    WebDriverWait wait;

    public TransferFundsPage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By transferFundsLink = By.linkText("Transfer Funds");

    By amount = By.id("amount");

    By fromAccountDropdown = By.id("fromAccountId");

    By toAccountDropdown = By.id("toAccountId");

    By transferButton =
            By.cssSelector("input[value='Transfer']");

    By transferCompleteMessage =
            By.xpath("//h1[text()='Transfer Complete!']");

    public void clickTransferFundsLink() {

        WaitUtils.waitForClickable(
                driver,
                transferFundsLink);

        driver.findElement(
                transferFundsLink)
                .click();
    }

    public void enterAmount(
            String transferAmount) {

        WaitUtils.waitForVisibility(
                driver,
                amount);

        driver.findElement(amount)
                .clear();

        driver.findElement(amount)
                .sendKeys(transferAmount);
    }

    public void selectFromAccount() {

        Select select =
                new Select(driver.findElement(fromAccountDropdown));

        select.selectByIndex(0);
    }

    public void selectToAccount() {

        Select select =
                new Select(driver.findElement(toAccountDropdown));

        if (select.getOptions().size() > 1) {

            select.selectByIndex(1);

        } else {

            select.selectByIndex(0);
        }
    }
    public void selectSameAccount() {

        Select fromAccount =
                new Select(driver.findElement(
                        By.id("fromAccountId")));

        String account =
                fromAccount.getFirstSelectedOption()
                        .getText();

        Select toAccount =
                new Select(driver.findElement(
                        By.id("toAccountId")));

        toAccount.selectByVisibleText(account);
    }
    public void clickTransferButton() {

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        transferButton));

        driver.findElement(transferButton).click();
    }

    public boolean isTransferSuccessful() {

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        transferCompleteMessage));

        return driver.findElement(
                transferCompleteMessage).isDisplayed();
    }
}