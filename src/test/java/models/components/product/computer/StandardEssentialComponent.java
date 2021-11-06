package models.components.product.computer;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testdata.purchasing.ComputerSpec;

import java.util.List;

public class StandardEssentialComponent extends ComputerEssentialComponent {

    private final WebDriver driver;
    private final By productAttributeSel = By.xpath("//select[contains(@id, 'product_attribute')]");
    private static final int PROCESSOR_DROPDOWN_INDEX = 0;
    private static final int RAM_DROPDOWN_INDEX = 1;
    private WebElement element;

    public StandardEssentialComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
        element = driver.findElement(productAttributeSel);
    }

    @Step("Select Processor type as {type}")
    public void selectProcessorType(String type) {
        selectOption(processorDropDown(), type);
    }

    @Step("Select ram capability as {type}")
    public void selectRAM(String type) {
        selectOption(ramDropDown(), type);
    }

    private void selectOption(WebElement dropdown, String valuePrefix){
        String optionValue =  ComputerSpec.valueOf(valuePrefix).value().replaceAll(" ","");
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        String fullValueOfExpectedOption = optionValue;
        for (WebElement option : allOptions) {
            String optionText = option.getText().replaceAll(" ", "");
            if (optionText.startsWith(optionValue))
                fullValueOfExpectedOption = option.getText();
        }
        select.selectByVisibleText(fullValueOfExpectedOption);
    }

    private WebElement processorDropDown() {
        return driver.findElements(productAttributeSel).get(PROCESSOR_DROPDOWN_INDEX);
    }

    private WebElement ramDropDown() {
        return driver.findElements(productAttributeSel).get(RAM_DROPDOWN_INDEX);
    }

}
