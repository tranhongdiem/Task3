package models.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutOptionPage {

    private final WebDriver driver;
    private AsGuestOrRegisteredUserComp asGuestOrRegisteredUserComp;

    public CheckOutOptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public AsGuestOrRegisteredUserComp asGuestOrRegisteredUserComp() {
        return new AsGuestOrRegisteredUserComp(driver);
    }

    public static class AsGuestOrRegisteredUserComp {
        private final WebDriver driver;
        private final By checkoutAsGuestBtnSel = By.cssSelector(".checkout-as-guest-button");

        public AsGuestOrRegisteredUserComp(WebDriver driver) {
            this.driver = driver;
        }

        public WebElement checkoutAsGuestBtn() {
            return driver.findElement(checkoutAsGuestBtnSel);
        }
    }
}
