package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BillPayPage {

    WebDriver driver;

    public BillPayPage(WebDriver driver) {

        this.driver = driver;
    }

    By billPayLink = By.linkText("Bill Pay");

    By payeeName = By.name("payee.name");

    By address = By.name("payee.address.street");

    By city = By.name("payee.address.city");

    By state = By.name("payee.address.state");

    By zipCode = By.name("payee.address.zipCode");

    By phoneNumber = By.name("payee.phoneNumber");

    By accountNumber = By.name("payee.accountNumber");

    By verifyAccount = By.name("verifyAccount");

    By amount = By.name("amount");

    By fromAccountDropdown =
            By.name("fromAccountId");

    By sendPaymentButton =
            By.cssSelector("input[value='Send Payment']");

    public void clickBillPayLink() {

        driver.findElement(billPayLink).click();
    }

    public void enterPayeeName(String value) {

        driver.findElement(payeeName).sendKeys(value);
    }

    public void enterAddress(String value) {

        driver.findElement(address).sendKeys(value);
    }

    public void enterCity(String value) {

        driver.findElement(city).sendKeys(value);
    }

    public void enterState(String value) {

        driver.findElement(state).sendKeys(value);
    }

    public void enterZipCode(String value) {

        driver.findElement(zipCode).sendKeys(value);
    }

    public void enterPhoneNumber(String value) {

        driver.findElement(phoneNumber).sendKeys(value);
    }

    public void enterAccountNumber(String value) {

        driver.findElement(accountNumber).sendKeys(value);
    }

    public void enterVerifyAccount(String value) {

        driver.findElement(verifyAccount).sendKeys(value);
    }

    public void enterAmount(String value) {

        driver.findElement(amount).sendKeys(value);
    }

    public void selectFromAccount() {

        Select select =
                new Select(driver.findElement(fromAccountDropdown));

        select.selectByIndex(0);
    }

    public void clickSendPaymentButton() {

        driver.findElement(sendPaymentButton).click();
    }

    public boolean isBillPaymentSuccessful() {

        return driver.getPageSource()
                .contains("was successful");
    }
}