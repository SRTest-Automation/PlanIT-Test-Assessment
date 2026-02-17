package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public double getPrice(String product) {
        return Double.parseDouble(
            driver.findElement(By.xpath("//td[text()='" + product + "']/following-sibling::td[@class='price']"))
                  .getText().replace("$", "")
        );
    }

    public double getSubtotal(String product) {
        return Double.parseDouble(
            driver.findElement(By.xpath("//td[text()='" + product + "']/following-sibling::td[3]"))
                  .getText().replace("$", "")
        );
    }

    public double getTotal() {
        return Double.parseDouble(
            driver.findElement(By.className("total"))
                  .getText().replace("Total: ", "").replace("$", "")
        );
    }
}
