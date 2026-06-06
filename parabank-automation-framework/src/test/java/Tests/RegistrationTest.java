package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.RegistrationPage;
import Utils.ExcelUtils;

public class RegistrationTest extends BaseTest {
	private static int outputRow = 1;
    @DataProvider(name = "registrationData")
    public Object[][] getData() {

        int rowCount =
                ExcelUtils.getRowCount(
                        "Registration");

        Object[][] data =
                new Object[rowCount][10];

        for (int i = 1; i <= rowCount; i++) {

            for (int j = 0; j < 10; j++) {

                data[i - 1][j] =
                        ExcelUtils.getCellData(
                                "Registration",
                                i,
                                j);
            }
        }

        return data;
    }

    @Test(dataProvider = "registrationData")
    public void registrationTest(

            String firstName,
            String lastName,
            String address,
            String city,
            String state,
            String zipCode,
            String phone,
            String ssn,
            String username,
            String password) {

        RegistrationPage regPage =
                new RegistrationPage(driver);

        regPage.clickRegisterLink();

        regPage.enterFirstName(firstName);

        regPage.enterLastName(lastName);

        regPage.enterAddress(address);

        regPage.enterCity(city);

        regPage.enterState(state);

        regPage.enterZipCode(zipCode);

        regPage.enterPhoneNumber(phone);

        regPage.enterSSN(ssn);

        String uniqueUsername =
                username +
                        System.currentTimeMillis();

        regPage.enterUsername(
                uniqueUsername);

        regPage.enterPassword(password);

        regPage.enterConfirmPassword(password);

        regPage.clickRegisterButton();
       
        ExcelUtils.writeData(
                "RegisteredUsers",
                outputRow,
                0,
                uniqueUsername);

        ExcelUtils.writeData(
                "RegisteredUsers",
                outputRow,
                1,
                password);

        ExcelUtils.writeData(
                "RegisteredUsers",
                outputRow,
                2,
                "PASS");

        outputRow++;

        System.out.println(
                "Generated Username : "
                        + uniqueUsername);

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Welcome"),
                "Registration Failed");
        System.out.println(
                "Generated Username : "
                        + uniqueUsername);

        Assert.assertTrue(
                driver.getPageSource()
                        .contains("Welcome"),
                "Registration Failed");
    }
}