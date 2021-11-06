package models.components.product.computer;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testdata.purchasing.ComputerSpec;

import java.util.List;

public abstract class ComputerEssentialComponent {

    private final WebDriver driver;
    private final By allOptionsSel = By.cssSelector(".option-list input");
    private final By addToCartBtnSel = By.cssSelector("[id^='add-to-cart-button']");

    public ComputerEssentialComponent(WebDriver driver) {
        this.driver = driver;
    }

    public abstract void selectProcessorType(String type);
    public abstract void selectRAM(String type);

    @Step("Select HDD with value {type}")
    public void selectHDD(String type) {
        selectCompSpecOption(type);
    }

    public void selectSoftware(String type) {
        selectCompSpecOption(type);
    }

    protected void selectCompSpecOption(String option){
        String optionValue =  ComputerSpec.valueOf(option).value();
        String selectorString = "//label[contains(text(), \"" + optionValue + "\")]";
        By optionSel = By.xpath(selectorString);
        driver.findElement(optionSel).click();
    }

    public void unSelectAllDefaultOptions(){
        List<WebElement> allOptionsElems = driver.findElements(allOptionsSel);
        for (WebElement option : allOptionsElems) {
            if(option.getAttribute("checked") != null)
                option.click();
        }
    }

    @Step("Click on [Add to cart]")
    public void clickOnAddToCartBtn(){
        driver.findElement(addToCartBtnSel).click();
    }

}
