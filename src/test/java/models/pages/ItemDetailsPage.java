package models.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemDetailsPage {

    private final WebDriver driver;
    private final By barNotificationContentSel = By.cssSelector("#bar-notification p");
    private final By barNotificationHyperlinkSel = By.cssSelector("#bar-notification p a");

    public ItemDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getNotificationContent(){
        return driver.findElement(barNotificationContentSel).getText();
    }

    public String getNotificationHyperlink(){
        return driver.findElement(barNotificationHyperlinkSel).getAttribute("href");
    }

    @Step("Wait for item added to cart")
    public boolean isMyItemAddedToCart(){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            String addToCartSuccessMsg = "The product has been added to your shopping cart";
            wait.until(ExpectedConditions.textToBePresentInElementLocated(barNotificationContentSel, addToCartSuccessMsg));
        } catch (Exception e){
            return false;
        }

        return true;
    }

    @Step("Wait for item added to cart")
    public void waitUntilItemAddedToCart(){
        isMyItemAddedToCart();
    }

}
