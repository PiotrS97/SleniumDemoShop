package pl.ps.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ps.pages.HomePage;

public class LoginTest extends BaseTest {
    private String password = "Test123!Test";
    private String randomPassword = password + System.currentTimeMillis();
    private String email = "abc@cbz.pl";

    @Test
    public void logInTest() {
        WebElement dashboardLink = new HomePage(driver)
                .openMyAccountPage()
                .logInValidData(email, password)
                .getDashboardLink();
        Assert.assertEquals(dashboardLink.getText(), "Dashboard");
    }

    @Test
    public void logInWithInvalidPasswordTest() {
        WebElement error = new HomePage(driver)
                .openMyAccountPage()
                .logInInvalidData(email, randomPassword)
                .getError();
        Assert.assertTrue(error.getText().contains("Incorrect username or password"),
                "Expected error doesn't match");
    }
}
