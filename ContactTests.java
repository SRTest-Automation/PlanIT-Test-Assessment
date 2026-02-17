package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactPage;
import pages.HomePage;

public class ContactTests extends BaseTest {

    @Test(invocationCount = 5)
    public void validateContactFormErrors() {
        HomePage home = new HomePage(driver);
        ContactPage contact = home.goToContactPage();

        contact.submitForm();

        Assert.assertTrue(contact.isErrorDisplayed("forename"));
        Assert.assertTrue(contact.isErrorDisplayed("email"));
        Assert.assertTrue(contact.isErrorDisplayed("message"));

        contact.fillMandatoryFields("SR Test", "sr@testing.com", "A message is entered");

        contact.waitForErrorToDisappear("forename");
        contact.waitForErrorToDisappear("email");
        contact.waitForErrorToDisappear("message");

        Assert.assertFalse(contact.isErrorDisplayed("forename"));
        Assert.assertFalse(contact.isErrorDisplayed("email"));
        Assert.assertFalse(contact.isErrorDisplayed("message"));
    }

    @Test(invocationCount = 5)
    public void validateSuccessfulSubmission() {
        HomePage home = new HomePage(driver);
        ContactPage contact = home.goToContactPage();

        contact.fillMandatoryFields("SR Test", "sr@testing.com", "A message is entered");
        contact.submitForm();

        Assert.assertTrue(contact.isSuccessMessageDisplayed("SR Test"));
    }
}
