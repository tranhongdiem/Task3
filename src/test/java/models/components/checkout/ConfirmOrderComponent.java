package models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ConfirmOrderComponent {
    private final WebDriver driver;
    private final By confirmBtnSel = By.className("confirm-order-next-step-button");
    private final By finishBtnSel = By.className("order-completed-continue-button");

    public ConfirmOrderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement confirmBtn() {
        return driver.findElement(confirmBtnSel);
    }

    public WebElement finishBtn() {
        return driver.findElement(finishBtnSel);
    }
}
