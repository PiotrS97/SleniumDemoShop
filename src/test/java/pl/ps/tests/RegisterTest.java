package pl.ps.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ps.pages.HomePage;

public class RegisterTest extends BaseTest {
    private String password = "Test123!Test";
    private String randomEmail = "abc" + System.currentTimeMillis() + "@cbz.pl";
    private String standardEmail = "abc@cbz.pl";

    @Test
    public void registerUserTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .registerUserValidData(randomEmail, password)
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void registerUserWithSameEmailTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .registerUserInvalidData(standardEmail, password)
                .getError();
        Assert.assertTrue(error.getText().contains("An account is already registered"),
                "Expected error doesn't match");
    }
}
