package models.components.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BillingAddressComponent {

    private final WebDriver driver;
    private final By firstnameSel = By.cssSelector("#BillingNewAddress_FirstName");
    private final By lastnameSel = By.cssSelector("#BillingNewAddress_LastName");
    private final By emailSel = By.cssSelector("#BillingNewAddress_Email");
    private final By countryDropdownSel = By.cssSelector("#BillingNewAddress_CountryId");
    private final By stateDropdownSel = By.cssSelector("#BillingNewAddress_StateProvinceId");
    private final By citySel = By.cssSelector("#BillingNewAddress_City");
    private final By address1Sel = By.cssSelector("#BillingNewAddress_Address1");
    private final By zipCodeSel = By.cssSelector("#BillingNewAddress_ZipPostalCode");
    private final By phoneNumberSel = By.cssSelector("#BillingNewAddress_PhoneNumber");
    private final By continueBtnSel = By.cssSelector(".new-address-next-step-button");

    public BillingAddressComponent(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement firstname() {
        return driver.findElement(firstnameSel);
    }

    public WebElement lastname() {
        return driver.findElement(lastnameSel);
    }

    public WebElement email() {
        return driver.findElement(emailSel);
    }

    public void selectCountry(String country) {
        Select select = new Select(driver.findElement(countryDropdownSel));
        select.selectByVisibleText(country);
    }

    public void selectState(String state) {
        Select select = new Select(driver.findElement(stateDropdownSel));
        select.selectByVisibleText(state);
    }

    public WebElement city() {
        return driver.findElement(citySel);
    }

    public WebElement address1() {
        return driver.findElement(address1Sel);
    }

    public WebElement zipCode() {
        return driver.findElement(zipCodeSel);
    }

    public WebElement phoneNumber() {
        return driver.findElement(phoneNumberSel);
    }

    public WebElement continueBtn() {
        return driver.findElement(continueBtnSel);
    }
}
