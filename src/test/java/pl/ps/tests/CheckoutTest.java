package pl.ps.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.ps.models.Customer;
import pl.ps.pages.HomePage;
import pl.ps.pages.OrderDetailsPage;

public class CheckoutTest extends BaseTest {
    @Test
    public void checkoutTest() throws InterruptedException {
        Customer customer = new Customer();

        OrderDetailsPage orderDetailsPage = new HomePage(driver)
                .openShopPage()
                .openProduct("Java Selenium WebDriver")
                .addProductToCart()
                .viewCart()
                .openAddressDetails()
                .fillAddressDetails(customer, "Random comment");

        Assert.assertEquals(orderDetailsPage.getOrderNotice().getText()
                , "Thank you. Your order has been received.");
        Assert.assertEquals(orderDetailsPage.getProductName().getText()
                , "Java Selenium WebDriver × 1");
    }
}
