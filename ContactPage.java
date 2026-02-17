package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By forenameField = By.id("forename");
    private By emailField = By.id("email");
    private By messageField = By.id("message");
    private By submitBtn = By.cssSelector("a.btn-contact");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillMandatoryFields(String forename, String email, String message) {
        driver.findElement(forenameField).sendKeys(forename);
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(messageField).sendKeys(message);
    }

    public void submitForm() {
        driver.findElement(submitBtn).click();
    }

    public boolean isErrorDisplayed(String field) {
        try {
            return driver.findElement(By.id(field + "-err")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void waitForErrorToDisappear(String field) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(field + "-err")));
    }

    public boolean isSuccessMessageDisplayed(String forename) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success"))
        ).getText().contains("Thanks " + forename);
    }
}
