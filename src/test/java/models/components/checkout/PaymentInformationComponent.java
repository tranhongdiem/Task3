package models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentInformationComponent {
    private final WebDriver driver;
    private final By continueBtnSel = By.cssSelector(".payment-info-next-step-button");

    public PaymentInformationComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement continueBtn() {
        return driver.findElement(continueBtnSel);
    }
}
