package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.BasicAuthPage;
import org.junit.Assert;

public class BasicAuth extends Context {

    public BasicAuth(Manager manager) {
        super(manager);
    }

    private final BasicAuthPage basicAuthPage = new BasicAuthPage(this.getDriver());

    @Then("the message {string} is displayed")
    public void validateMessage(String expectedMessage) {
        Assert.assertEquals("Message validation", expectedMessage, basicAuthPage.getMessage());
    }
}
