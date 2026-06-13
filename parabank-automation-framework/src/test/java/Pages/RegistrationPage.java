package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utils.WaitUtils;

public class RegistrationPage {

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    By registerLink = By.xpath("//*[@id='loginPanel']/p[2]/a");

    By firstName = By.id("customer.firstName");
    By lastName = By.id("customer.lastName");
    By address = By.id("customer.address.street");
    By city = By.id("customer.address.city");
    By state = By.id("customer.address.state");
    By zipCode = By.id("customer.address.zipCode");
    By phoneNumber = By.id("customer.phoneNumber");
    By ssn = By.id("customer.ssn");
    By username = By.id("customer.username");
    By password = By.id("customer.password");
    By confirmPassword = By.id("repeatedPassword");

    By registerButton = By.cssSelector("input[value='Register']");

    public void clickRegisterLink() {

        WaitUtils.waitForClickable(
                driver,
                registerLink);

        driver.findElement(registerLink)
                .click();
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstName).sendKeys(fname);
    }

    public void enterLastName(String lname) {
        driver.findElement(lastName).sendKeys(lname);
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
    }

    public void enterCity(String cityName) {
        driver.findElement(city).sendKeys(cityName);
    }

    public void enterState(String stateName) {
        driver.findElement(state).sendKeys(stateName);
    }

    public void enterZipCode(String zip) {
        driver.findElement(zipCode).sendKeys(zip);
    }

    public void enterPhoneNumber(String phone) {
        driver.findElement(phoneNumber).sendKeys(phone);
    }

    public void enterSSN(String ssnNo) {
        driver.findElement(ssn).sendKeys(ssnNo);
    }

    public void enterUsername(String uname) {
        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void enterConfirmPassword(String cpwd) {
        driver.findElement(confirmPassword).sendKeys(cpwd);
    }

    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}