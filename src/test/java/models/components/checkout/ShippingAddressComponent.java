package models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingAddressComponent {
    private WebDriver driver;
    private final By continueBtnSel = By.cssSelector(".new-address-next-step-button");
    private final WebElement shippingAddComp;

    public ShippingAddressComponent(WebDriver driver) {
        this.driver = driver;
        shippingAddComp = driver.findElement(By.cssSelector("#checkout-step-shipping"));
    }

    public WebElement continueBtn() {
        return shippingAddComp.findElement(continueBtnSel);
    }
}
