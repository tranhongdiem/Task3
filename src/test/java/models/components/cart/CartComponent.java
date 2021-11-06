package models.components.cart;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartComponent {

    private final WebDriver driver;
    private final By itemTotalPriceSel = By.className("product-subtotal");

    public CartComponent(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Get current total price")
    public Double itemTotalPrice(){
        String itemTotalPriceStr = driver.findElement(itemTotalPriceSel).getText();
        return Double.parseDouble(itemTotalPriceStr);
    }
}
