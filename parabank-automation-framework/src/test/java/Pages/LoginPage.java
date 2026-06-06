package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By username = By.name("username");

    By password = By.name("password");

    By loginButton =
            By.cssSelector("input[value='Log In']");

    public void enterUsername(String uname) {

        driver.findElement(username).sendKeys(uname);
    }

    public void enterPassword(String pwd) {

        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginButton() {

        driver.findElement(loginButton).click();
    }
}