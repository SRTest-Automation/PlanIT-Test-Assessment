package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ShopTests extends BaseTest {

    @Test
    public void validateCartTotals() {
        HomePage home = new HomePage(driver);
        ShopPage shop = home.goToShopPage();
        CartPage cart = new CartPage(driver);

        shop.buyItem("Stuffed Frog", 2);
        shop.buyItem("Fluffy Bunny", 5);
        shop.buyItem("Valentine Bear", 3);
        shop.goToCart();

        double frogTotal = cart.getPrice("Stuffed Frog") * 2;
        double bunnyTotal = cart.getPrice("Fluffy Bunny") * 5;
        double bearTotal = cart.getPrice("Valentine Bear") * 3;

        Assert.assertEquals(cart.getSubtotal("Stuffed Frog"), frogTotal, 0.01);
        Assert.assertEquals(cart.getSubtotal("Fluffy Bunny"), bunnyTotal, 0.01);
        Assert.assertEquals(cart.getSubtotal("Valentine Bear"), bearTotal, 0.01);

        double expectedTotal = frogTotal + bunnyTotal + bearTotal;
        Assert.assertEquals(cart.getTotal(), expectedTotal, 0.01);
    }
}
