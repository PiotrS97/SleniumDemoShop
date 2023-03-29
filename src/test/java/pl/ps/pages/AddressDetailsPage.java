package pl.ps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;
import pl.ps.models.Customer;

import java.time.Duration;

public class AddressDetailsPage {
    @FindBy(id = "billing_first_name")
    private WebElement firstNameInput;

    @FindBy(id = "billing_last_name")
    private WebElement lastNameInput;

    @FindBy(id = "billing_company")
    private WebElement companyInput;

    @FindBy(id = "billing_country")
    private WebElement customerCountrySelect;

    @FindBy(id = "billing_address_1")
    private WebElement addressInput;

    @FindBy(id = "billing_postcode")
    private WebElement postcodeInput;

    @FindBy(id = "billing_city")
    private WebElement cityInput;

    @FindBy(id = "billing_phone")
    private WebElement phoneInput;

    @FindBy(id = "billing_email")
    private WebElement emailInput;

    @FindBy(id = "order_comments")
    private WebElement commentsInput;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    private WebDriver driver;

    public AddressDetailsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public OrderDetailsPage fillAddressDetails(Customer customer, String comments) throws InterruptedException {
        firstNameInput.sendKeys(customer.getFirstName());
        lastNameInput.sendKeys(customer.getLastName());
        companyInput.sendKeys(customer.getCompany());
        Select countrySelect = new Select(customerCountrySelect);
        countrySelect.selectByVisibleText(customer.getCountry());
        addressInput.sendKeys(String.format("%s %s", customer.getStreet(), customer.getFlatNumber()));
        postcodeInput.sendKeys(customer.getZipCode());
        cityInput.sendKeys(customer.getCity());
        phoneInput.sendKeys(customer.getPhone());
        emailInput.sendKeys(customer.getEmail());
        commentsInput.sendKeys(comments);
        Thread.sleep(100); //implicit wait didn't solve the problem
        placeOrderButton.click();
        return new OrderDetailsPage(driver);
    }
}
