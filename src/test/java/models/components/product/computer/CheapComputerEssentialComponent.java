package models.components.product.computer;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class CheapComputerEssentialComponent extends ComputerEssentialComponent {

    private final WebDriver driver;

    public CheapComputerEssentialComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Select Processor type as {type}")
    public void selectProcessorType(String type) {
        selectCompSpecOption(type);
    }

    @Step("Select ram capability as {type}")
    public void selectRAM(String type) {
        selectCompSpecOption(type);
    }

}
