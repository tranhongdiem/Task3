package testflows.order.computer;

import models.components.checkout.BillingAddressComponent;
import models.components.product.computer.ComputerEssentialComponent;
import models.pages.CheckOutOptionPage;
import models.pages.CheckOutPage;
import models.pages.ItemDetailsPage;
import models.pages.cart.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import testdata.purchasing.ComputerDataObject;
import testdata.purchasing.ComputerSpec;

import java.lang.reflect.InvocationTargetException;

public class BuyingComputerFlow<T extends ComputerEssentialComponent> implements ComputerPriceType {

    private final WebDriver driver;
    private T essentialCompGeneric;

    public BuyingComputerFlow(WebDriver driver) {
        this.driver = driver;
    }

    public BuyingComputerFlow<T> withComputerEssentialComp(Class<T> computerType) {
        try {
            essentialCompGeneric = computerType.getConstructor(WebDriver.class).newInstance(driver);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return this;
    }

    public void buildComputer(ComputerDataObject compData) {
        if (essentialCompGeneric == null) {
            throw new RuntimeException("Please call withComputerType to specify computer type!");
        }
        essentialCompGeneric.unSelectAllDefaultOptions();
        ItemDetailsPage detailsPage = new ItemDetailsPage(driver);

        // Build Comp specs
        essentialCompGeneric.selectProcessorType(compData.getProcessorType());
        essentialCompGeneric.selectRAM(compData.getRam());
        essentialCompGeneric.selectHDD(compData.getHdd());

        // Add To cart
        essentialCompGeneric.clickOnAddToCartBtn();
        try {
            detailsPage.waitUntilItemAddedToCart();
        } catch (Exception e) {
            throw new Error("[ERR] Item is not added after 15s!");
        }
    }

    public void verifyComputerAdded(ComputerDataObject computerDataObject, double startPrice) {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

        // Get additional fee
        double additionalFees = 0.0;
        additionalFees += ComputerSpec.valueOf(computerDataObject.getProcessorType()).additionPrice();
        additionalFees += ComputerSpec.valueOf(computerDataObject.getRam()).additionPrice();
        additionalFees += ComputerSpec.valueOf(computerDataObject.getHdd()).additionPrice();

        // Get Total current price for computer
        double currentCompPrice = startPrice + additionalFees;

        // Print all price list for the items
        System.out.println(shoppingCartPage.cardFooterComponent().cartTotalComponent().priceMap().get(subTotal));

        double itemTotalPrice = shoppingCartPage.cardFooterComponent().cartTotalComponent().priceMap().get(tax)
                + shoppingCartPage.cardFooterComponent().cartTotalComponent().priceMap().get(shipping)
                + shoppingCartPage.cardFooterComponent().cartTotalComponent().priceMap().get(total);

        // Compare
        Assert.assertEquals(itemTotalPrice, currentCompPrice, "[ERR] Total price is not correct!");
        shoppingCartPage.cardFooterComponent().cartTotalComponent().tosCheckBox().click();
        shoppingCartPage.cardFooterComponent().cartTotalComponent().checkoutBtn().click();
    }

    public void checkout(){
        CheckOutOptionPage checkOutOptionPage = new CheckOutOptionPage(driver);
        checkOutOptionPage.asGuestOrRegisteredUserComp().checkoutAsGuestBtn().click();

        CheckOutPage checkOutPage = new CheckOutPage(driver);
        BillingAddressComponent billingAddressComp = checkOutPage.billingAddressComp();
        billingAddressComp.firstname().sendKeys("Diem");
        billingAddressComp.lastname().sendKeys("Tran");
        billingAddressComp.email().sendKeys("diem.tran@gmail.com");
        billingAddressComp.selectCountry("United States");
        billingAddressComp.selectState("Texas");
        billingAddressComp.city().sendKeys("HCM City");
        billingAddressComp.address1().sendKeys("Nguyen Hue");
        billingAddressComp.zipCode().sendKeys("7000");
        billingAddressComp.phoneNumber().sendKeys("123 856 8951");
        billingAddressComp.continueBtn().click();

        checkOutPage.shippingAddressComp().continueBtn().click();
        checkOutPage.shippingMethodComponent().nextDayOption().click();
        checkOutPage.shippingMethodComponent().continueBtn().click();
        checkOutPage.paymentMethodComp().continueBtn().click();
        checkOutPage.paymentInformationComp().continueBtn().click();
        checkOutPage.confirmOrderComp().confirmBtn().click();
        checkOutPage.confirmOrderComp().finishBtn().click();
    }
}
