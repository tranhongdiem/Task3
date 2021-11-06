package models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingMethodComponent {
    private final WebDriver driver;
    private WebElement shippingMethodComp;
    private final By groundOptionSel = By.cssSelector("[value='Ground___Shipping.FixedRate']");
    private final By nextDayOptionSel = By.cssSelector("[value='Next Day Air___Shipping.FixedRate']");
    private final By secondDayOptionSel = By.cssSelector("[value='2nd Day Air___Shipping.FixedRate']");
    private final By continueBtnSel = By.cssSelector(".shipping-method-next-step-button");

    public ShippingMethodComponent(WebDriver driver) {
        this.driver = driver;
        shippingMethodComp = driver.findElement(By.cssSelector("#opc-shipping_method"));
    }

    public WebElement groundOption() {
        return driver.findElement(groundOptionSel);
    }

    public WebElement nextDayOption() {
        return driver.findElement(nextDayOptionSel);
    }

    public WebElement secondDayOption() {
        return driver.findElement(secondDayOptionSel);
    }

    public WebElement continueBtn() {
        return shippingMethodComp.findElement(continueBtnSel);
    }
}
