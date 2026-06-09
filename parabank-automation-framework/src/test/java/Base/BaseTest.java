//package Base;
//
//import java.time.Duration;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//
//import Pages.LoginPage;
//import Pages.RegistrationPage;
//import Utils.ConfigReader;
//import Utils.ScreenshotUtils;
//import Utils.UserManager;
//
//public class BaseTest {
//
//    protected WebDriver driver;
//
//    ConfigReader config =
//            new ConfigReader();
//
//    @BeforeSuite
//    public void createUser() {
//
//        WebDriver tempDriver =
//                new ChromeDriver();
//
//        tempDriver.manage()
//                .window()
//                .maximize();
//
//        tempDriver.get(
//                "https://parabank.parasoft.com/parabank/index.htm");
//
//        RegistrationPage regPage =
//                new RegistrationPage(tempDriver);
//
//        regPage.clickRegisterLink();
//
//        regPage.enterFirstName("Surya");
//        regPage.enterLastName("Prakash");
//        regPage.enterAddress("Coimbatore");
//        regPage.enterCity("Coimbatore");
//        regPage.enterState("Tamil Nadu");
//        regPage.enterZipCode("641001");
//        regPage.enterPhoneNumber("9876543210");
//        regPage.enterSSN("123456789");
//
//        String user =
//                "surya"
//                + System.currentTimeMillis();
//
//        UserManager.username = user;
//
//        regPage.enterUsername(user);
//
//        regPage.enterPassword(
//                UserManager.password);
//
//        regPage.enterConfirmPassword(
//                UserManager.password);
//
//        regPage.clickRegisterButton();
//
//        System.out.println(
//                "Generated User : "
//                        + UserManager.username);
//
//        tempDriver.quit();
//    }
//
//    @BeforeMethod
//    public void setup() {
//
//        String browser =
//                config.getBrowser();
//
//        String url =
//                config.getUrl();
//
//        if (browser.equalsIgnoreCase("chrome")) {
//
//            driver =
//                    new ChromeDriver();
//
//        } else if (browser.equalsIgnoreCase("firefox")) {
//
//            driver =
//                    new FirefoxDriver();
//        }
//
//        driver.manage()
//                .window()
//                .maximize();
//
//        driver.manage()
//                .timeouts()
//                .implicitlyWait(
//                        Duration.ofSeconds(10));
//
//        driver.get(url);
//    }
//
//    protected void login() {
//
//        LoginPage loginPage =
//                new LoginPage(driver);
//
//        loginPage.enterUsername(
//                UserManager.username);
//
//        loginPage.enterPassword(
//                UserManager.password);
//
//        loginPage.clickLoginButton();
//    }
//
//    @AfterMethod
//    public void tearDown(
//            ITestResult result) {
//
//        if (result.getStatus()
//                == ITestResult.FAILURE) {
//
//            ScreenshotUtils.captureScreenshot(
//                    driver,
//                    result.getName());
//        }
//
//        if (driver != null) {
//
//            driver.quit();
//        }
//    }
//}
package Base;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import Pages.LoginPage;
import Pages.RegistrationPage;
import Utils.ConfigReader;
import Utils.ScreenshotUtils;
import Utils.UserManager;

public class BaseTest {

    protected WebDriver driver;

    ConfigReader config = new ConfigReader();

    @BeforeSuite
    public void createUser() throws Exception {

        ChromeOptions options = new ChromeOptions();

        WebDriver tempDriver =
                new RemoteWebDriver(
                        new URL("http://localhost:4444/wd/hub"),
                        options);

        tempDriver.manage().window().maximize();

        tempDriver.get(
                "https://parabank.parasoft.com/parabank/index.htm");

        RegistrationPage regPage =
                new RegistrationPage(tempDriver);

        regPage.clickRegisterLink();

        regPage.enterFirstName("Surya");
        regPage.enterLastName("Prakash");
        regPage.enterAddress("Coimbatore");
        regPage.enterCity("Coimbatore");
        regPage.enterState("Tamil Nadu");
        regPage.enterZipCode("641001");
        regPage.enterPhoneNumber("9876543210");
        regPage.enterSSN("123456789");

        String user =
                "surya" + System.currentTimeMillis();

        UserManager.username = user;

        regPage.enterUsername(user);

        regPage.enterPassword(
                UserManager.password);

        regPage.enterConfirmPassword(
                UserManager.password);

        regPage.clickRegisterButton();

        System.out.println(
                "Generated User : "
                        + UserManager.username);

        tempDriver.quit();
    }

    @BeforeMethod
    public void setup() throws Exception {

        String browser =
                config.getBrowser();

        String url =
                config.getUrl();

        if (browser.equalsIgnoreCase("chrome")) {

            ChromeOptions options =
                    new ChromeOptions();

            options.setPlatformName("linux");

            driver =
                    new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            FirefoxOptions options =
                    new FirefoxOptions();

            options.setPlatformName("linux");

            driver =
                    new RemoteWebDriver(
                            new URL("http://localhost:4444/wd/hub"),
                            options);
        }

        driver.manage()
                .window()
                .maximize();

        driver.manage()
                .timeouts()
                .implicitlyWait(
                        Duration.ofSeconds(10));

        driver.get(url);
    }

    protected void login() {

        LoginPage loginPage =
                new LoginPage(driver);

        loginPage.enterUsername(
                UserManager.username);

        loginPage.enterPassword(
                UserManager.password);

        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown(
            ITestResult result) {

        if (result.getStatus()
                == ITestResult.FAILURE) {

            ScreenshotUtils.captureScreenshot(
                    driver,
                    result.getName());
        }

        if (driver != null) {

            driver.quit();
        }
    }
}