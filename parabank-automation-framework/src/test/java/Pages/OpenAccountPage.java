package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import Utils.WaitUtils;

public class OpenAccountPage {

    WebDriver driver;

    public OpenAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By openNewAccountLink = By.linkText("Open New Account");

    By accountTypeDropdown = By.id("type");

    By fromAccountDropdown = By.id("fromAccountId");

    By openNewAccountButton =
            By.cssSelector("input[value='Open New Account']");

    public void clickOpenNewAccountLink() {

        WaitUtils.waitForClickable(
                driver,
                openNewAccountLink);

        driver.findElement(openNewAccountLink)
                .click();
    }

    public void selectAccountType(String accountType) {

        Select select =
                new Select(driver.findElement(accountTypeDropdown));

        select.selectByVisibleText(accountType);
    }

    public void selectExistingAccount() {

        Select select =
                new Select(driver.findElement(fromAccountDropdown));

        select.selectByIndex(0);
    }

    public void clickOpenNewAccountButton() {

        driver.findElement(openNewAccountButton).click();
    }
}