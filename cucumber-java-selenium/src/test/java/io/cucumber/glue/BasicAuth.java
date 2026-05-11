package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.Then;
import io.cucumber.pages.BasicAuthPage;
import org.junit.Assert;

public class BasicAuth extends Context {

    private final BasicAuthPage basicAuthPage;

    public BasicAuth(Manager manager) {
        super(manager);
        this.basicAuthPage = new BasicAuthPage(manager.getDriver());
    }

    @Then("the message {string} is displayed")
    public void validateMessage(String expectedMessage) {
        Assert.assertEquals("Message validation", expectedMessage, basicAuthPage.getMessage());
    }
}
