package pl.ps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderDetailsPage {

    @FindBy(xpath = "//div[@class='woocommerce-order']//p")
    private WebElement orderNotice;

    @FindBy(xpath = "//td[contains(@class, 'product-name')]")
    private WebElement productName;

    public OrderDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        orderNotice = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='woocommerce-order']//p")));
    }

    public WebElement getOrderNotice() {
        return orderNotice;
    }

    public WebElement getProductName() {
        return productName;
    }
}
