package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShopPage {

    private WebDriver driver;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
    }

    public void buyItem(String itemName, int quantity) {
        for (int i = 0; i < quantity; i++) {
            driver.findElement(By.xpath("//h4[text()='" + itemName + "']/following-sibling::p/a")).click();
        }
    }

    public void goToCart() {
        driver.findElement(By.linkText("Cart")).click();
    }
}
