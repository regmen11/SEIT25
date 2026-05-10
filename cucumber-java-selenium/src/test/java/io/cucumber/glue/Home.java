package io.cucumber.glue;

import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.pages.HomePage;
import org.junit.Assert;

import java.util.List;

public class Home extends Context {

  public Home(Manager manager) {
    super(manager);
  }

  private final HomePage homePage = new HomePage(this.getDriver());

  @Given("^the page under test is '(.+)'$")
  public void navToPage(String url) {
    homePage.navigateToHomePage(url);
  }

  @And("^header title is '(.+)'$")
  public void getHeader(String expectedHeader) {
    Assert.assertEquals("Header validation", expectedHeader, homePage.getTitleHeader());
  }

  @Then("^the displayed list of Available Examples should match the following:")
  public void validateListOfExample(List<String> expectedList) {
    // Note: the list on GIT README does not match the actual list in the site.
    // I followed the site's actual list
    String expectedStr = "";
    String actualStr = "";

    List<String> actualList = homePage.getAvailableExamples();

    // assert count of list
    Assert.assertEquals("Count validation", expectedList.size(), actualList.size());

    // assert values for expected and actual
    for (int i = 0; i < expectedList.size(); i++) {
      expectedStr = expectedList.get(i);
      actualStr = actualList.get(i);
      Assert.assertEquals("Available Example validation " + i, expectedStr, actualStr);
    }
  }

  @When("the {string} example link is displayed")
  public void validateExampleName(String exampleName) {
    Assert.assertTrue("Presence of Example link validation", homePage.validateExampleName(exampleName));
  }

  @And("credentials username {string} and password {string} are entered for {string}")
  public void enterCredentials(String username, String password, String exampleName) {
    homePage.loginWithCredentials(username, password, exampleName);
  }

  @And("the {string} example link is clicked")
  public void clickExampleLink(String exampleName) {
    homePage.clickExampleName(exampleName);
  }

}