package models.pages.cart;

import models.components.cart.CardFooterComponent;
import models.components.cart.CartComponent;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {

    private final WebDriver driver;
    private CardFooterComponent cardFooterComponent;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public CartComponent shoppingCartItemComp(){
        return new CartComponent(driver);
    }

    public CardFooterComponent cardFooterComponent() {
        return new CardFooterComponent(driver);
    }
}
