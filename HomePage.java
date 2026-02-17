package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public ContactPage goToContactPage() {
        driver.findElement(By.linkText("Contact")).click();
        return new ContactPage(driver);
    }

    public ShopPage goToShopPage() {
        driver.findElement(By.linkText("Shop")).click();
        return new ShopPage(driver);
    }
}
