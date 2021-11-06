package models.pages.computer;

import models.components.product.computer.StandardEssentialComponent;
import models.pages.ItemDetailsPage;
import org.openqa.selenium.WebDriver;

public class StandardComputerItemDetailsPage extends ItemDetailsPage {

    private final WebDriver driver;

    public StandardComputerItemDetailsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public StandardEssentialComponent computerEssentialComp(){
        return new StandardEssentialComponent(driver);
    }
}
