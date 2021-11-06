package models.pages;

import models.components.checkout.*;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {

    private final WebDriver driver;
    private BillingAddressComponent billingAddressComp;
    private ShippingAddressComponent shippingAddressComp;
    private ShippingMethodComponent shippingMethodComponent;
    private PaymentMethodComponent paymentMethodComp;
    private PaymentInformationComponent paymentInformationComp;
    private ConfirmOrderComponent confirmOrderComp;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
    }

    public BillingAddressComponent billingAddressComp() {
        return new BillingAddressComponent(driver);
    }

    public ShippingAddressComponent shippingAddressComp() {
        return new ShippingAddressComponent(driver);
    }

    public ShippingMethodComponent shippingMethodComponent() {
        return new ShippingMethodComponent(driver);
    }

    public PaymentMethodComponent paymentMethodComp() {
        return new PaymentMethodComponent(driver);
    }

    public PaymentInformationComponent paymentInformationComp() {
        return new PaymentInformationComponent(driver);
    }

    public ConfirmOrderComponent confirmOrderComp() {
        return new ConfirmOrderComponent(driver);
    }
}